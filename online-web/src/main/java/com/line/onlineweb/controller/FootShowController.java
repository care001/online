package com.line.onlineweb.controller;


import com.line.onlineweb.bean.JsonResult;
import com.line.onlineweb.service.FootShowService;
import com.line.onlineweb.service.dto.FootShowDTO;
import com.line.onlineweb.service.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/foot")
public class FootShowController {

    @Autowired
    private FootShowService footShowService;

    @RequestMapping("/showNow")
    @ResponseBody
    public JsonResult showNow(@RequestParam(value="pageNo",required = false,defaultValue = "1")int pageNo,
                              @RequestParam(value="pageSize",required = false,defaultValue = "10")int pageSize){
        Page<FootShowDTO> footShowDTOPage = new Page<FootShowDTO>();
        footShowDTOPage.setPageNo(pageNo);
        footShowDTOPage.setPageSize(pageSize);
        return JsonResult.wrapper(footShowService.findAllNextFoot(footShowDTOPage));
    }
}
