package mapper;

import java.util.List;
import java.util.Map;

import service.note.dataobject.NoteDAO;

public interface NoteMapper {
    List<Map<String, Object>> findNotesByNotebookId(String notebookId);

    NoteDAO findNoteById(String noteId);

    int updateNote(NoteDAO note);

    int addNote(NoteDAO note);

}
