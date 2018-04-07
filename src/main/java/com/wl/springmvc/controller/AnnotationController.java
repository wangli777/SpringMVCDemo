package com.wl.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * springMVC注解方式
 */
@Controller
public class AnnotationController {
    @RequestMapping("/anno")
    public ModelAndView method(HttpServletRequest Request, HttpServletResponse Response) throws Exception {
        System.out.println("AnnotationController");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","Hello World AnnotationController");
        mv.setViewName("hello.jsp");
        return mv;
    }
}
