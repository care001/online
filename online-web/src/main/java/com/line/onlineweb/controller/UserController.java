package com.line.onlineweb.controller;

import com.line.bean.UrlMapBean;
import com.line.onlineweb.bean.JsonResult;
import com.line.onlineweb.controller.base.BaseController;
import com.line.onlineweb.controller.vo.OnePlanVo;
import com.line.onlineweb.dao.entity.LineUser;
import com.line.onlineweb.service.FootShowService;

import com.line.utils.JavaSpider;
import com.line.utils.OrderNoUtil;
import com.line.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController {

    @Autowired
    private FootShowService footShowService;

    @Value("${plan.url}")
    private String url;

    @RequestMapping("/addOnePlan")
    public JsonResult addOnePlan(@RequestBody @Validated OnePlanVo planVo, HttpServletRequest request){
        LineUser lineUser = getUser(request);
        if(StringUtils.isEmpty(planVo.getSiteId())||!StringUtils.isInteger(planVo.getSiteId())){
            planVo.setSiteId(OrderNoUtil.generateNo("1"));
        }
        if(StringUtils.isEmpty(planVo.getSiteMatch())){
            planVo.setSiteMatch("未知");
        }
        footShowService.addOnePlan(planVo, lineUser.getId());
        return JsonResult.wrapper(true);
    }

    @RequestMapping("/showHtmlPlan")
    public JsonResult showHtmlPlan(){
        List<UrlMapBean> beans = JavaSpider.resolveUrl(url);
        return JsonResult.wrapper(beans);
    }

}
