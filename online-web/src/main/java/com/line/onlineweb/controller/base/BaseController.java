package com.line.onlineweb.controller.base;

import com.line.exception.ErrorCode;
import com.line.exception.ErrorCodeException;
import com.line.onlineweb.dao.entity.LineUser;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    /**
     * 登录保存用户
     * @param request
     * @return
     */
    protected LineUser putUser(HttpServletRequest request, LineUser user){
        user.setLoginIp(request.getRemoteAddr());
        request.getSession().setAttribute("user", user);
        return user;
    }

    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    protected LineUser getUser(HttpServletRequest request){
        LineUser user = (LineUser) request.getSession().getAttribute("user");
        if(user == null){
            throw new ErrorCodeException(ErrorCode.LOGIN_ERR);
        }
        user.setNowIp(request.getRemoteAddr());
        return user;
    }
    /**
     * 获取当前登录用户ID(未登录为-1)
     * @param request
     * @return
     */
    protected Long getUserId(HttpServletRequest request){
        LineUser user = (LineUser) request.getSession().getAttribute("user");
        if(user == null){
            return -1L;
        }
        user.setNowIp(request.getRemoteAddr());
        return user.getId();
    }

}
