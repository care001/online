package com.line.onlineweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.line.onlineweb.controller.vo.OnePlanVo;
import com.line.onlineweb.dao.entity.FootSite;
import com.line.onlineweb.dao.entity.UserPlan;
import com.line.onlineweb.dao.mapper.FootSiteMapper;
import com.line.onlineweb.dao.mapper.UserPlanMapper;
import com.line.onlineweb.service.FootShowService;
import com.line.onlineweb.service.dto.FootShowDTO;
import com.line.onlineweb.service.dto.Page;
import com.line.onlineweb.service.param.FootShowParam;
import com.line.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FootShowServiceImpl implements FootShowService{

    @Autowired
    private UserPlanMapper userPlanMapper;
    @Autowired
    private FootSiteMapper footSiteMapper;

    @Override
    public Page<FootShowDTO> findAllNextFoot(Page<FootShowDTO> page, FootShowParam param) {
        param.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
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

    @Override
    public UserPlan findUserPlanById(Long id) {
        return userPlanMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void addOnePlan(OnePlanVo planVo, Long userId) {
        FootSite footSite = buildFootSite(Long.valueOf(planVo.getSiteId()),planVo.getSiteName(),
                planVo.getSiteTime(), planVo.getSiteMatch());
        footSiteMapper.insert(footSite);
        UserPlan userPlan = buildUserPlan(planVo.getFootResult(), Long.valueOf(planVo.getSiteId()), userId,
                planVo.getSayInfo());
        userPlanMapper.insert(userPlan);

    }


    private FootSite buildFootSite(Long id, String name, String time, String siteMatch){
        FootSite footSite = new FootSite();
        footSite.setId(id);
        footSite.setMatchName(siteMatch);
        footSite.setName(name);
        footSite.setStartTime(time);
        return footSite;
    }

    private UserPlan buildUserPlan(String footResult, Long siteId, Long userId, String sayInfo){
        UserPlan userPlan = new UserPlan();
        userPlan.setCreateTime(new Date());
        userPlan.setFootResult(footResult);
        userPlan.setSiteId(siteId);
        userPlan.setUserId(userId);
        userPlan.setSayInfo(sayInfo);
        userPlan.setHot(0L);
        userPlan.setClick(0L);
        return userPlan;
    }

}
