package com.soudeep.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class DBUtil {
	private DBUtil() {}
	
	private static DataSource dataSource = null;
	
	static {
		String dsInfo = "java://comp/env/JNDI";
		
		try {
			InitialContext context = new InitialContext();
			dataSource = (DataSource)context.lookup(dsInfo);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
