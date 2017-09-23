package com.line.onlineweb.service.dto;

import com.line.onlineweb.dao.entity.UserPlan;

import java.io.Serializable;
import java.util.Date;

public class FootShowDTO implements Serializable{


    private Long id;

    private Long userId;

    private Long siteId;

    private String sayInfo;

    private String footResult;

    private Long hot;

    private Long click;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSayInfo() {
        return sayInfo;
    }

    public void setSayInfo(String sayInfo) {
        this.sayInfo = sayInfo == null ? null : sayInfo.trim();
    }

    public String getFootResult() {
        return footResult;
    }

    public void setFootResult(String footResult) {
        this.footResult = footResult == null ? null : footResult.trim();
    }

    public Long getHot() {
        return hot;
    }

    public void setHot(Long hot) {
        this.hot = hot;
    }

    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }




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


    private String name;

    private String startTime;

    private String matchName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
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


    private Long support;

    public Long getSupport() {
        return support;
    }

    public void setSupport(Long support) {
        this.support = support;
    }
}
