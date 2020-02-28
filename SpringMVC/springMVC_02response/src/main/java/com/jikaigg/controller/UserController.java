package com.jikaigg.controller;

import com.jikaigg.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 返回字符串
     * @param model
     * @return
     */
    @RequestMapping("testString")
    public String testString(Model model){
        System.out.println("testString执行了...");
        //模拟从数据库中查询User数据
        User user = new User();
        user.setName("yaojikai");
        user.setPassword("123456");
        user.setAge(18);
        model.addAttribute("user",user);

        return "success";
    }

    /**
     * 无返回值
     * @return
     */
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了...");
        // 编写请求转发跳转程序
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        // 重定向跳转程序
        // response.sendRedirect(request.getContextPath()+"testString");

        //直接响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("么济恺爱石梦宇");
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(Model model){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("testModelAndView执行了...");
        //模拟从数据库中查询User数据
        User user = new User();
        user.setName("yaojikai");
        user.setPassword("123456");
        user.setAge(18);
        // 把user对象存储到modelAndView中，也会把user对象存入到request域中
        modelAndView.addObject("user",user);
        //指定跳转到哪个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 使用关键字的方式进行转发和重定向
     * @param model
     * @return
     */
    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(Model model){
        System.out.println("testForwardOrRedirect执行了...");
        // 转发
        //return "forward:/WEB-INF/pages/success.jsp";
        // 重定向
        return "redirect:/index.jsp";
    }
}
