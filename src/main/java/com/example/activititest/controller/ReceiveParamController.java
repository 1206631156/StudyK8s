package com.example.activititest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ReceiveParamController {

    @RequestMapping("/getParam")
    public Map<String,Object> getParam(@RequestParam Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        if(ids != null){
            for(Integer id : ids){
                System.err.println(id);
            }
            map.put("msg","接收成功 + "+ ids +"");
        }else {
            map.put("msg","接收失败");
        }
        return map;
    }
}
