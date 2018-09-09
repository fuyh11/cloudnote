package service;

import java.util.List;
import java.util.Map;

import dao.Note;
import service.exception.NoteNotFoundException;
import service.exception.NotebookNotFoundException;
import service.exception.NotebookNoteFoundExcepotion;
import service.exception.UserNotFoundException;

public interface NoteService {
	
	List<Map<String, Object>> listNotes(String notebookId)
		throws NotebookNoteFoundExcepotion;

	Note getNote(String noteId)
			throws NoteNotFoundException;
	
	boolean update(String noteId, String title, String body)
		throws NoteNotFoundException;
	
	public Note addNote(String userId, String notebookId, String title)
			throws UserNotFoundException, NotebookNotFoundException;

}
