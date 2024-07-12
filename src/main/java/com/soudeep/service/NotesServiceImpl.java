package com.soudeep.service;

import java.util.List;

import com.soudeep.beans.Notes;
import com.soudeep.factory.NotesFactory;

public class NotesServiceImpl implements INotesService {

	@Override
	public String addNotes(Notes notes) {
		return NotesFactory.getNotesRepo().addNotes(notes);
	}

	@Override
	public List<Notes> getNotes(Integer id) {
		return NotesFactory.getNotesRepo().getNotes(id);
	}

	@Override
	public Notes getNoteById(Integer id) {
		return NotesFactory.getNotesRepo().getNoteById(id);
	}

	@Override
	public String editNote(Integer notesId, String title, String content) {
		return NotesFactory.getNotesRepo().editNote(notesId, title, content);
	}

	@Override
	public String deleteNote(Integer notesId) {
		return NotesFactory.getNotesRepo().deleteNote(notesId);
	}

}
