package com.wl.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 传统方式，实现Controller接口,重写其handleRequest方法
 */
public class HelloWorldController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest Request, HttpServletResponse Response) throws Exception {
        System.out.println("HelloWorldController");
        ModelAndView mv = new ModelAndView();
        mv.addObject("key","Hello World HelloWorldController");
        mv.setViewName("hello.jsp");
        return mv;
    }
}
