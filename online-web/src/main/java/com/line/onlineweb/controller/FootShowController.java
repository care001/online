package com.line.onlineweb.controller;


import com.line.onlineweb.service.FootShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/foot")
public class FootShowController {

    @Autowired
    private FootShowService footShowService;
}
