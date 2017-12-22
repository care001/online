package com.line.onlineweb.controller.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class OnePlanVo {

    private String siteId;
    @NotEmpty(message = "场次NAME不能为空")
    private String siteName;
    private String siteTime;
    private String siteMatch;
    @NotEmpty(message = "说明不能为空")
    private String sayInfo;
    @NotEmpty(message = "结果不能为空")
    private String footResult;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteTime() {
        return siteTime;
    }

    public void setSiteTime(String siteTime) {
        this.siteTime = siteTime;
    }

    public String getSiteMatch() {
        return siteMatch;
    }

    public void setSiteMatch(String siteMatch) {
        this.siteMatch = siteMatch;
    }

    public String getSayInfo() {
        return sayInfo;
    }

    public void setSayInfo(String sayInfo) {
        this.sayInfo = sayInfo;
    }

    public String getFootResult() {
        return footResult;
    }

    public void setFootResult(String footResult) {
        this.footResult = footResult;
    }
}
