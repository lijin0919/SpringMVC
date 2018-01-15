package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@SessionAttributes("user")
public class HelloController {

    @Autowired
    private HelloDao helloDao;
    @RequestMapping("/hello")
    public String hello(){
        System.out.println(helloDao.getUser().getUserName());
//       throw new HelloException();
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String pwd,
                        ModelMap modelMap){
        System.out.println(name);
        System.out.println(pwd);
        if ("admin".equals(name)&&"123".equals(pwd)){
            modelMap.addAttribute("user",name);
            return "success";
        }else {
            return "error";
        }

    }



    @PostMapping("/login1")
    public ModelAndView login1(@RequestParam("username") String name,
                               @RequestParam("password") String pwd,
                               ModelAndView modelAndView){
        System.out.println(name);
        System.out.println(pwd);
        if ("admin".equals(name)&&"123".equals(pwd)){
            modelAndView.addObject("user",name);
            modelAndView.setViewName("success");
            return modelAndView;
        }else {
            modelAndView.setViewName("error");
            return modelAndView;
        }

    }


    @RequestMapping("/springUpload")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "home";
    }
}
