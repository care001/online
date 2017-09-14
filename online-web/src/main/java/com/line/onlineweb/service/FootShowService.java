package com.line.onlineweb.service;

import com.line.onlineweb.service.dto.FootShowDTO;

import java.util.List;
import java.util.Map;

public interface FootShowService {

    List<FootShowDTO> findAllNextFoot();
    /**
     * 根据条件查询
     * map:
     * startTime
     * endTime
     * userId
     * siteId
     * hot*/
    List<FootShowDTO> findBySeachMap(Map<String, Object> map);
}
