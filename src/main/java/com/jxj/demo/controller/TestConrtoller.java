package com.jxj.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "test")
public class TestConrtoller {
    @RequestMapping(value = "test")
    @ResponseBody
    public String test() {
        return "访问成功-------0523";
    }

    @RequestMapping(value = "test1")
    @ResponseBody
    public String test1(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        return name + ":" + pwd;
    }
}
