package com.soudeep.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soudeep.beans.Notes;
import com.soudeep.utility.DBUtil;

public class NotesRepoImpl implements INotesRepo {
	
	private static final String SQL_SELECT_QUERY_USING_UID = "SELECT id, title, content, date FROM notes WHERE uid = ? ORDER BY id DESC";
	private static final String SQL_INSERT_QUERY = "INSERT INTO notes(`title`,`content`,`uid`) VALUES(?,?,?)";
	private static final String SQL_SELECT_BY_ID = "SELECT id, title, content, date, uid FROM notes WHERE id = ?";
	private static final String SQL_UPDATE_QUERY = "UPDATE notes SET title=? ,content=? WHERE id=?";
	private static final String SQL_DELETE_QUERY = "DELETE FROM notes WHERE id=?";
	
	private static Connection connection = null;
	private static PreparedStatement pstmtSelect = null;
	private static PreparedStatement pstmtSelectById = null;
	private static PreparedStatement pstmtInsert = null;
	private static PreparedStatement pstmtUpdate = null;
	private static PreparedStatement pstmtDelete = null;
	
	static {
		try {
			connection = DBUtil.getDBConnection();
			
			if (connection != null) {
				pstmtInsert = connection.prepareStatement(SQL_INSERT_QUERY);
				pstmtSelect = connection.prepareStatement(SQL_SELECT_QUERY_USING_UID);
				pstmtSelectById = connection.prepareStatement(SQL_SELECT_BY_ID);
				pstmtUpdate = connection.prepareStatement(SQL_UPDATE_QUERY);
				pstmtDelete = connection.prepareStatement(SQL_DELETE_QUERY);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String addNotes(Notes notes) {
		String status = "";
		try {
			if (pstmtInsert != null) {
				pstmtInsert.setString(1, notes.getTitle());
				pstmtInsert.setString(2, notes.getContent());
				pstmtInsert.setInt(3, notes.getuId());
				
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
	public List<Notes> getNotes(Integer uid) {
		List<Notes> notesList = new ArrayList<Notes>();
		Notes notes = null;
		try {
			if(pstmtSelect != null) {
				pstmtSelect.setInt(1, uid);
			}
			ResultSet result = pstmtSelect.executeQuery();
			while(result.next()) {
				notes = new Notes();
				notes.setId(result.getInt("id"));
				notes.setTitle(result.getString("title"));
				notes.setContent(result.getString("content"));
				notes.setDate(result.getTimestamp("date"));
				
				notesList.add(notes);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notesList;
	}

	@Override
	public Notes getNoteById(Integer id) {
		Notes notes = new Notes();
		try {
			if(pstmtSelectById!=null) {
				pstmtSelectById.setInt(1, id);
			}
			ResultSet result = pstmtSelectById.executeQuery();
			while(result.next()) {
				notes = new Notes();
				notes.setId(result.getInt("id"));
				notes.setTitle(result.getString("title"));
				notes.setContent(result.getString("content"));
				notes.setDate(result.getTimestamp("date"));
				notes.setuId(result.getInt("uid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notes;
	}

	@Override
	public String editNote(Integer notesId, String title, String content) {
		String status = "";
		Notes notes = getNoteById(notesId);
		try {
			if(pstmtUpdate != null) {
				if(title!=null) {
					pstmtUpdate.setString(1, title);
				} else {
					pstmtUpdate.setString(1, notes.getTitle());
				}
				
				if(content!=null) {
					pstmtUpdate.setString(2, content);
				} else {
					pstmtUpdate.setString(2, notes.getContent());
				}
				
				pstmtUpdate.setInt(3, notesId);
				
				int rowAff = pstmtUpdate.executeUpdate();
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
	public String deleteNote(Integer notesId) {
		String status = "";
		Notes notes = getNoteById(notesId);
		if(notes!=null) {
			if(pstmtDelete!=null) {
				try {
					pstmtDelete.setInt(1, notesId);
					int rowAff = pstmtDelete.executeUpdate();
					if(rowAff==1) {
						status = "success";
					}
				} catch (SQLException e) {
					status = "failure";
					e.printStackTrace();
				}
			}
		} else {
			status = "Record not available for the given id :: " + notesId;
		}
		return status;
	}
}
