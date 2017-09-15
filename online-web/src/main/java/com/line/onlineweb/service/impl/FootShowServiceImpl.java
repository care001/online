package com.line.onlineweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.line.onlineweb.dao.mapper.UserPlanMapper;
import com.line.onlineweb.service.FootShowService;
import com.line.onlineweb.service.dto.FootShowDTO;
import com.line.onlineweb.service.dto.Page;
import com.line.onlineweb.service.param.FootShowParam;
import com.line.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FootShowServiceImpl implements FootShowService{

    @Autowired
    private UserPlanMapper userPlanMapper;

    @Override
    public Page<FootShowDTO> findAllNextFoot(Page<FootShowDTO> page) {
        FootShowParam param = new FootShowParam();
        param.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        page.setPageNo(2);
        page = findBySeachMap(param, page);
        return page;
    }

    @Override
    public Page<FootShowDTO> findBySeachMap(FootShowParam param, Page<FootShowDTO> footPage) {
        PageHelper.startPage(footPage.getPageNo(), footPage.getPageSize());
        List<Map<String, Object>> foots = userPlanMapper.findBySeachMap(param);
        BeanUtils<FootShowDTO> beanUtils = new BeanUtils<FootShowDTO>();
        footPage.setResults(beanUtils.ListMap2JavaBean(foots, FootShowDTO.class));
        return footPage;
    }

}
