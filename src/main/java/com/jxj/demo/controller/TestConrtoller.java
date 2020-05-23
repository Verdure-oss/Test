package com.jxj.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "test")
public class TestConrtoller {
    @RequestMapping(value = "test")
    @ResponseBody
    public String test() {
        return "访问成功--------0523";
    }
}
