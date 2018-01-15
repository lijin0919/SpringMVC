package com.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class LoginController {


//    @RequestMapping(name = "/userlogin",method = RequestMethod.POST)
    @PostMapping("/userlogin")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password,
                        Model model){

        System.out.println(name);
        System.out.println(password);

        if ("admin".equals(name)&&"123".equals(password)){
            model.addAttribute("user",name);
            return "success";
        }else {
            return "error";
        }


    }

}
