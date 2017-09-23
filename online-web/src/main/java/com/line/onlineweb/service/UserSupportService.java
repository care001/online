package com.line.onlineweb.service;

import com.line.onlineweb.dao.entity.UserSupport;

public interface UserSupportService {

    void insert(UserSupport userSupport);

    UserSupport findByPlanId(Long planId);

    UserSupport findByPlanIdAndUserId(Long planId, Long userId);
}
