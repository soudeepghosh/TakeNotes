package com.soudeep.service;

import java.util.List;

import com.soudeep.beans.Notes;

public interface INotesService {
	public String addNotes(Notes notes);
	public List<Notes> getNotes(Integer uid);
	public Notes getNoteById(Integer id);	
	public String editNote(Integer notesId, String title, String content);
	public String deleteNote(Integer notesId);
}
