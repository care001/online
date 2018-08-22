package com.line.onlineweb.controller;


import com.line.onlineweb.bean.JsonResult;
import com.line.onlineweb.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/online/plan")
public class PlanController{

    @Autowired
    private PlanService planService;

    private static final String OPEN_ID = "care001";

    @RequestMapping("/onePlan")
    public JsonResult onePlan(@RequestParam(value="planId") Long planId){
        return JsonResult.wrapper(planService.findPlan(planId, OPEN_ID));
    }

    @GetMapping("/todayPlan")
    public JsonResult todayPlan(){
        return JsonResult.wrapper(planService.findTodayPlan(OPEN_ID));
    }
}
