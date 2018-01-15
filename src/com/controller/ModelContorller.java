package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class ModelContorller {

    @PostMapping("/modellogin")
    public ModelAndView longin(@RequestParam("username")String name,
                         @RequestParam("password")String pwd,
                         ModelAndView model){

        System.out.println(name);
        System.out.println(pwd);
        model.addObject("user",name);
        model.setViewName("error");
        return model;
    }


}
