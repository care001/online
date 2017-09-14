package com.line.onlineweb.service.impl;

import com.line.exception.ErrorCode;
import com.line.exception.ErrorCodeException;
import com.line.onlineweb.dao.entity.LineUser;
import com.line.onlineweb.dao.mapper.LineUserMapper;
import com.line.onlineweb.service.UserService;
import com.line.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private LineUserMapper lineUserMapper;

    @Override
    public void insert(LineUser user) {
        if(lineUserMapper.insert(user)!= 1){
            throw new ErrorCodeException(ErrorCode.DB_ERR);
        }
    }

    @Override
    public LineUser findByNameAndPwd(String loginName, String pwd) {
        List<LineUser> users = lineUserMapper.findByNameAndPwd(loginName, pwd);
        if(CollectionUtil.listIsEmpty(users)){
            return null;
        }
        return users.get(0);
    }
}
