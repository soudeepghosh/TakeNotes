package com.soudeep.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.soudeep.beans.UserDetails;
import com.soudeep.utility.DBUtil;

public class UserRepoImpl implements IUserRepo{
	
	private static Connection connection = null;
	private static PreparedStatement pstmtInsert = null;
	private static PreparedStatement pstmtSelect = null;
	
	private static final String SQL_INSERT_QUERY = "INSERT INTO user(`name`, `email`, `password`) VALUES(?, ?, ?)";
	private static final String SQL_SELECT_QUERY = "SELECT id, name, email, password FROM user WHERE email=? and password=?";
	
	static {
		try {
			connection = DBUtil.getDBConnection();
			
			if (connection != null) {
				pstmtInsert = connection.prepareStatement(SQL_INSERT_QUERY);
				pstmtSelect = connection.prepareStatement(SQL_SELECT_QUERY);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String insertUser(UserDetails user) {
		String status = "";
		try {
			if (pstmtInsert != null) {
				pstmtInsert.setString(1, user.getName());
				pstmtInsert.setString(2, user.getEmail());
				pstmtInsert.setString(3, user.getPassword());
				
				int rowAff = pstmtInsert.executeUpdate();
				if (rowAff == 1) {
					status = "success";
				}
			}
		} catch (SQLException se) {
			int errorCode = se.getErrorCode();
			
			if (errorCode == 1064) {
				status = "some error in db operation";
			} else if (errorCode == 2006) {
				status = "connection lost at dbside";
			} else if (errorCode == 1045) {
				status = "acess denied for the user wrong credentials";
			} else if (errorCode == 1044) {
				status = "access denied for the user to database";
			} else {
				status = "Some Error at database side";
			}
			se.printStackTrace();
		} catch (Exception e) {
			status = "Some Unknown Exception ";
			return status;
		}
		return status;
	}

	@Override
	public UserDetails loginUser(UserDetails user) {
		try {
			if (pstmtSelect != null) {
				pstmtSelect.setString(1, user.getEmail());
				pstmtSelect.setString(2, user.getPassword());
				
				ResultSet result = pstmtSelect.executeQuery();
				if(result.next()){
					user.setId(result.getInt("id"));
					user.setName(result.getString("name"));
					return user;
				}
			}
		} catch(SQLException se){
			se.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
