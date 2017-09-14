package com.line.onlineweb.controller;

import com.line.onlineweb.bean.JsonResult;
import com.line.onlineweb.dao.entity.LineUser;
import com.line.onlineweb.service.UserService;
import com.line.utils.MD5Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String name, String pwd, HttpServletRequest request){
        LineUser user = userService.findByNameAndPwd(name, MD5Tools.MD5(pwd));
        Assert.notNull(user, "用户名或密码错误");
        putUser(request, user);
        return JsonResult.wrapper(user);
    }

    @RequestMapping("/register")
    @ResponseBody
    public JsonResult register(LineUser user){
        Assert.notNull(user, "请填写完整");
        userService.insert(user);
        return JsonResult.wrapper(user);
    }

}
