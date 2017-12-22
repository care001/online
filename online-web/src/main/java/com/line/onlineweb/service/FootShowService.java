package com.line.onlineweb.service;

import com.line.onlineweb.controller.vo.OnePlanVo;
import com.line.onlineweb.dao.entity.UserPlan;
import com.line.onlineweb.service.dto.FootShowDTO;
import com.line.onlineweb.service.dto.Page;
import com.line.onlineweb.service.param.FootShowParam;

import java.util.List;
import java.util.Map;

public interface FootShowService {

    Page<FootShowDTO> findAllNextFoot(Page<FootShowDTO> page, FootShowParam param);
    /**
     * 根据条件查询
     * map:
     * startTime
     * endTime
     * userId
     * siteId
     * hot*/
    Page<FootShowDTO> findBySeachMap(FootShowParam param, Page<FootShowDTO> foots);

    UserPlan findUserPlanById(Long id);

    void addOnePlan(OnePlanVo planVo, Long userId);
}
