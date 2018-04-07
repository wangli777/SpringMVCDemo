package com.wl.springmvc.controller;

import com.wl.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class DataController {
    /**
     * 传统传值方式
     * @return ModelAndView
     */
    @RequestMapping("/data1")
    public ModelAndView data1(HttpServletRequest request){
        request.setAttribute("msg","传统传值方式");
        ModelAndView mv = new ModelAndView("data1");
        return mv;
    }

    /**
     * 通过ModelAndView的方式
     * @return ModelAndView
     */
    @RequestMapping("/data2")
    public ModelAndView data2(){
        ModelAndView mv = new ModelAndView("data1");
        //同request.setAttribute()方式
        mv.addObject("data2","ModeAndView方式");

        //默认的key是数据类型(全小写) string,且相同的数据类型后者会覆盖前者
        mv.addObject("我是String");
        mv.addObject(new Date());//date

        return mv;
    }

    /**
     * 直接返回对象
     * 根据配置文件中的视图解析器响应视图：
     * 前缀+请求url名(data3)+后缀:/WEB-INF/views/data3.jsp
     * @return User
     */
    @RequestMapping("/data3")
    @ModelAttribute("myUser")
    public User data3(){
        User user = new User();
        user.setUserName("WangLi");
        user.setPassword("123");
        return user;

    }

    /**
     * 返回值如果是String类型，则
     * 前缀+返回值(string)+后缀:/WEB-INF/views/string.jsp
     * @return String
     */
    @RequestMapping("/data4")
    public String data4(Model model){
        model.addAttribute("data4","data4...");
        return "data1";

    }

    /**
     * 如果想返回根路径下的其他jsp文件(即取消前后缀)， return:"forward:jsp/hello.jsp"
     * 相当于转发方式
     * @return String
     */
    @RequestMapping("/data5")
    public String data5(Model model){
        model.addAttribute("msg","return:\"forward:hello.jsp\"");
        return "forward:jsp/hello.jsp";

    }

    /**
     * 如果想返回根路径下的其他jsp文件(即取消前后缀)， return:"redirect:jsp/hello.jsp"
     * 相当于重定向方式
     * @return String
     */
    @RequestMapping("/data6")
    public String data6(Model model){
        model.addAttribute("msg2","return:\"redirect:hello.jsp\"");
        return "redirect:jsp/hello.jsp";

    }
}
