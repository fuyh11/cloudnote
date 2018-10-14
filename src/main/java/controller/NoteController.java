package controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.note.NoteService;
import service.note.dataobject.NoteDAO;
import util.JsonResult;

@Controller
@RequestMapping("/note")
public class NoteController extends AbstractController {

    @Resource
    private NoteService noteService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonResult list(String notebookId) {
        List<Map<String, Object>> list = noteService.listNotes(notebookId);
        return new JsonResult(list);
    }

    @RequestMapping("/load")
    @ResponseBody
    public JsonResult load(String noteId) {
        NoteDAO note = noteService.getNote(noteId);
        return new JsonResult(note);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(String noteId, String title, String body) {
        boolean success = noteService.update(noteId, title, body);
        return new JsonResult(success);
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(String userId, String notebookId, String title) {
        NoteDAO note = noteService.addNote(userId, notebookId, title);
        return new JsonResult(note);
    }

}
