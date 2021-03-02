package com.example.activititest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActivitiIndexController {

    @RequestMapping("/")
    public String index(){
        return "processModel";
    }

    @RequestMapping("/meun")
    public String meun(){
        return "meun";
    }
}
