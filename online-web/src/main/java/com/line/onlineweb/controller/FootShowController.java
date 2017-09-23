package com.line.onlineweb.controller;


import com.line.onlineweb.bean.JsonResult;
import com.line.onlineweb.controller.base.BaseController;
import com.line.onlineweb.service.FootShowService;
import com.line.onlineweb.service.dto.FootShowDTO;
import com.line.onlineweb.service.dto.Page;
import com.line.onlineweb.service.param.FootShowParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/foot")
public class FootShowController extends BaseController{

    @Autowired
    private FootShowService footShowService;

    @RequestMapping("/showNow")
    @ResponseBody
    public JsonResult showNow(@RequestParam(value="pageNo",required = false,defaultValue = "1")int pageNo,
                              @RequestParam(value="pageSize",required = false,defaultValue = "10")int pageSize,
                              HttpServletRequest request){
        Page<FootShowDTO> footShowDTOPage = new Page<FootShowDTO>();
        footShowDTOPage.setPageNo(pageNo);
        footShowDTOPage.setPageSize(pageSize);
        FootShowParam param = new FootShowParam();
        param.setLoginUserId(getUserId(request));
        return JsonResult.wrapper(footShowService.findAllNextFoot(footShowDTOPage,  param));
    }
}
