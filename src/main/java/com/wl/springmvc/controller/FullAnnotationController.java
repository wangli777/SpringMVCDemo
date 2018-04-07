package com.wl.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC全注解方式
 */
@Controller
public class FullAnnotationController {
    @RequestMapping("/fullAnno")
    public ModelAndView method1(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","springMVC全注解方式");
        mv.setViewName("hello1.jsp");
        return mv;
    }
}
