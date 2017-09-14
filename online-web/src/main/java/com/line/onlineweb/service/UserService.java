package com.line.onlineweb.service;

import com.line.onlineweb.dao.entity.LineUser;

public interface UserService {

    void insert(LineUser user);

    LineUser findByNameAndPwd(String loginName, String pwd);
}
