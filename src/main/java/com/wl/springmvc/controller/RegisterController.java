package com.wl.springmvc.controller;

import com.wl.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 注册小案例
 */
@Controller
public class RegisterController {
    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request){
        //获取注册表单数据
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //将数据封装成User对象
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        System.out.println("注册用户姓名："+user.getUserName()+"--密码："+user.getPassword());
        //下面这句相当于request.getRequestDispatcher("jsp/success.jsp").forward(request,response)
        //返回登录成功页面
        ModelAndView mv = new ModelAndView("forward:jsp/success.jsp");
        //将userName添加到返回域中
        mv.addObject("userName",user.getUserName());
        return mv;
    }
}
