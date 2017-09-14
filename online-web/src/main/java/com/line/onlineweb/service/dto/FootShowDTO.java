package com.line.onlineweb.service.dto;

import com.line.onlineweb.dao.entity.UserPlan;

import java.util.Date;

public class FootShowDTO extends UserPlan{
    private String loginName;

    private String showName;

    private String imgUrl;


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }


    private Long name;

    private String startTime;

    private String matchName;

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName == null ? null : matchName.trim();
    }
}
