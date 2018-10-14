package controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.notebook.NotebookService;
import util.JsonResult;

@RequestMapping("/notebook")
@Controller
public class NotebookController extends AbstractController {

    @Resource
    private NotebookService notebookService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonResult list(String userId) {
        List<Map<String, Object>> list = notebookService.listNotebooks(userId);
        return new JsonResult(list);
    }
}







