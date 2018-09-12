package service.note;

import java.util.List;
import java.util.Map;

import service.exception.NoteNotFoundException;
import service.exception.NotebookNotFoundException;
import service.exception.NotebookNoteFoundExcepotion;
import service.exception.UserNotFoundException;
import service.note.dataobject.NoteDAO;

public interface NoteService {

    List<Map<String, Object>> listNotes(String notebookId) throws NotebookNoteFoundExcepotion;

    NoteDAO getNote(String noteId) throws NoteNotFoundException;

    boolean update(String noteId, String title, String body) throws NoteNotFoundException;

    NoteDAO addNote(String userId, String notebookId, String title)
        throws UserNotFoundException, NotebookNotFoundException;

}
