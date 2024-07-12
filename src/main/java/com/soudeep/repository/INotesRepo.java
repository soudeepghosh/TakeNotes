package com.soudeep.repository;

import java.util.List;

import com.soudeep.beans.Notes;

public interface INotesRepo {
	public String addNotes(Notes notes);
	public List<Notes> getNotes(Integer id);
	public Notes getNoteById(Integer id);
	public String editNote(Integer notesId, String title, String content);
	public String deleteNote(Integer notesId);
}
