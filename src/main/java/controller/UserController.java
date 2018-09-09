package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDao;
import service.PasswordException;
import service.UserNameException;
import service.UserNotFoundException;
import service.UserService;
import util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(String name, String password) {

        UserDao user = userService.login(name, password);
        return new JsonResult(user);

    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public JsonResult handleUserNotFound(UserNotFoundException e) {
        e.printStackTrace();
        return new JsonResult(2, e);
    }

    @ExceptionHandler(PasswordException.class)
    @ResponseBody
    public JsonResult handlePassword(PasswordException e) {
        e.printStackTrace();
        return new JsonResult(3, e);
    }

    @ExceptionHandler(UserNameException.class)
    @ResponseBody
    public JsonResult handleUserName(UserNameException e) {
        e.printStackTrace();
        return new JsonResult(4, e);
    }

    @RequestMapping("/regist.do")
    @ResponseBody
    public JsonResult regist(String name, String nick, String password, String confirm) {
        UserDao user = userService.regist(name, nick, password, confirm);
        return new JsonResult(user);
    }

    /**
     * 在其他控制器方法执行出现异常时候, 执行
     * 异常处理方法 handleException
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        e.printStackTrace();
        return new JsonResult(e);
    }
}












