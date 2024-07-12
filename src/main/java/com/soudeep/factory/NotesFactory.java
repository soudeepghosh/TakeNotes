package com.soudeep.factory;

import com.soudeep.repository.INotesRepo;
import com.soudeep.repository.NotesRepoImpl;
import com.soudeep.service.INotesService;
import com.soudeep.service.NotesServiceImpl;

public class NotesFactory {
	private static NotesRepoImpl notesRepo = null;
	private static NotesServiceImpl notesService = null;
	
	private NotesFactory() {}
	
	public static INotesRepo getNotesRepo() {
		if (notesRepo == null) {
			notesRepo = new NotesRepoImpl();
		}
		return notesRepo;
	}
	
	public static INotesService getNotesService() {
		if (notesService == null) {
			notesService = new NotesServiceImpl();
		}
		return notesService;
	}
}
