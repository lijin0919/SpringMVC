package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @RequestMapping("/say")
    public String say(){
        return "hello";
    }

}
