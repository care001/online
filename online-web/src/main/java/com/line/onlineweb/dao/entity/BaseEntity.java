package com.line.onlineweb.dao.entity;

public abstract class BaseEntity {
    public String loginIp;

    public String nowIp;

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getNowIp() {
        return nowIp;
    }

    public void setNowIp(String nowIp) {
        this.nowIp = nowIp;
    }
}
