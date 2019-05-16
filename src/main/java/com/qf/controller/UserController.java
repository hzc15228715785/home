package com.qf.controller;

import com.qf.entity.User;
import com.qf.service.IUserService;
import com.qf.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @user hzc
 * @data 2019/5/16 20:01
 */

@Controller
@RequestMapping(value = "/userController")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/tologin")
    public String tologin(){
        return "login";
    }


    @RequestMapping(value = "/topass")
    public String topass(){
        return "password";
    }

    @RequestMapping(value = "/getpass")
    public String  getpass(String username) throws Exception {
        User user = userService.getpass(username);
        String email = user.getEmail();
        SendEmail.SendEmailInfoUser(email, "邮件的标题",
                "http://127.0.0.1:8080/userController/resetpass?id="+user.getId(), "");
        return "index";
    }

    @RequestMapping(value = "/resetpass")
    public String resetpass(Integer id, ModelMap map) {
        User user = userService.selectUserById(id);
        map.put("user", user);
        return "update";
    }

    @RequestMapping(value = "/update")
    public String update(User user) {
        int result = userService.update(user);
        return "ok";
    }
}
