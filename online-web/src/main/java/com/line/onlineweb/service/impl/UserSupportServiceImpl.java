package com.line.onlineweb.service.impl;

import com.line.exception.ErrorCode;
import com.line.exception.ErrorCodeException;
import com.line.onlineweb.dao.entity.UserSupport;
import com.line.onlineweb.dao.mapper.UserSupportMapper;
import com.line.onlineweb.service.UserSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSupportServiceImpl implements UserSupportService{

    @Autowired
    private UserSupportMapper userSupportMapper;

    @Override
    public void insert(UserSupport userSupport) {
        if(userSupportMapper.insert(userSupport) !=1){
            throw new ErrorCodeException(ErrorCode.DB_ERR);
        }
    }

    @Override
    public UserSupport findByPlanId(Long planId) {
        return userSupportMapper.findByPlanId(planId);
    }

    @Override
    public UserSupport findByPlanIdAndUserId(Long planId, Long userId) {
        return userSupportMapper.findByPlanIdAndUserId(planId, userId);
    }
}
