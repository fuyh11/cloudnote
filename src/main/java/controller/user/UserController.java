package controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.exception.PasswordException;
import service.exception.UserNameException;
import service.exception.UserNotFoundException;
import service.user.UserService;
import service.user.dataobject.UserDao;
import service.user.param.UserParam;
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
    public JsonResult regist(UserParam param) {
        UserDao user = userService.regist(param);
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












