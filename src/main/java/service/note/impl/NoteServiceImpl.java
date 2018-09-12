package service.note.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import mapper.NoteMapper;
import mapper.NotebookMapper;
import mapper.UserMapper;
import service.exception.NoteNotFoundException;
import service.exception.NotebookNotFoundException;
import service.exception.NotebookNoteFoundExcepotion;
import service.exception.UserNotFoundException;
import service.note.NoteService;
import service.note.dataobject.NoteDAO;
import service.user.dataobject.UserDao;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteMapper noteMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private NotebookMapper notebookMapper;

    public List<Map<String, Object>> listNotes(String notebookId) throws NotebookNoteFoundExcepotion {
        if (StringUtils.isEmpty(notebookId)) {
            throw new NotebookNoteFoundExcepotion("ID为空");
        }
        //Notebook notebook = notebookDao
        //		.findNotebookById(notebookId);
        //if(notebook==null){
        //	throw new NotebookNoteFoundExcepotion("没有笔记本");
        //}
        int n = notebookMapper.countNotebookById(notebookId);
        if (n != 1) {
            throw new NotebookNoteFoundExcepotion("没有笔记本");
        }

        return noteMapper.findNotesByNotebookId(notebookId);
    }

    public NoteDAO getNote(String noteId) throws NoteNotFoundException {
        if (noteId == null || noteId.trim().isEmpty()) {
            throw new NoteNotFoundException("ID空");
        }
        NoteDAO note = noteMapper.findNoteById(noteId);
        if (note == null) {
            throw new NoteNotFoundException("id错误");
        }
        return note;
    }

    public boolean update(String noteId, String title, String body) throws NoteNotFoundException {
        if (noteId == null || noteId.trim().isEmpty()) {
            throw new NoteNotFoundException("ID不能空");
        }
        NoteDAO note = noteMapper.findNoteById(noteId);
        if (note == null) {
            throw new NoteNotFoundException("没有对应的笔记");
        }
        NoteDAO data = new NoteDAO();
        if (title != null && !title.equals(note.getTitle())) {
            data.setTitle(title);
        }
        if (body != null && !body.equals(note.getBody())) {
            data.setBody(body);
        }
        data.setId(noteId);
        data.setLastModifyTime(System.currentTimeMillis());
        System.out.println(data);
        int n = noteMapper.updateNote(data);
        return n == 1;
    }

    public NoteDAO addNote(String userId, String notebookId, String title)
        throws UserNotFoundException, NotebookNotFoundException {

        if (userId == null || userId.trim().isEmpty()) {
            throw new UserNotFoundException("ID空");
        }
        UserDao user = userMapper.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("木有人");
        }
        if (notebookId == null || notebookId.trim().isEmpty()) {
            throw new NotebookNotFoundException("ID空");
        }
        int n = notebookMapper.countNotebookById(notebookId);
        if (n != 1) {
            throw new NotebookNotFoundException("没有笔记本");
        }
        if (title == null || title.trim().isEmpty()) {
            title = "葵花宝典";
        }
        String id = UUID.randomUUID().toString();
        String statusId = "0";
        String typeId = "0";
        String body = "";
        long time = System.currentTimeMillis();
        NoteDAO note = new NoteDAO(id, notebookId, userId, statusId, typeId, title, body, time, time);
        n = noteMapper.addNote(note);
        if (n != 1) {
            throw new NoteNotFoundException("保存失败");
        }
        return note;
    }

}



