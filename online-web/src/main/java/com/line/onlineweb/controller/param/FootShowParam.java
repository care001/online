package com.line.onlineweb.controller.param;

import lombok.Data;

@Data
public class FootShowParam {
    private String startTime;
    private String endTime;
    private String  userId;
    private String  siteId;
    private String  hot;
    private Long loginUserId;
}
