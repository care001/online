package com.line.onlineweb.controller;

import com.line.onlineweb.bean.JsonResult;
import com.line.onlineweb.controller.base.BaseController;
import com.line.onlineweb.dao.entity.LineUser;
import com.line.onlineweb.dao.entity.UserPlan;
import com.line.onlineweb.dao.entity.UserSupport;
import com.line.onlineweb.service.FootShowService;
import com.line.onlineweb.service.UserService;
import com.line.onlineweb.service.UserSupportService;
import com.line.utils.MD5Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private FootShowService footShowService;
    @Autowired
    private UserSupportService userSupportService;

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
        user.setCreateTime(new Date());
        user.setPwd(MD5Tools.MD5(user.getPwd()));
        userService.insert(user);
        return JsonResult.wrapper(user);
    }

    @RequestMapping("/mySupport")
    @ResponseBody
    public JsonResult register(Long userPlanId, HttpServletRequest request){
        LineUser lineUser = getUser(request);
        UserPlan userPlan = footShowService.findUserPlanById(userPlanId);
        Assert.notNull(userPlan, "方案不存在");
        UserSupport userSupport = userSupportService.findByPlanIdAndUserId(userPlanId, lineUser.getId());
        Assert.isNull(userPlan, "您已投票");

        return JsonResult.wrapper(true);
    }

}
