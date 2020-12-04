package com.offcn.shop.servlet;

import com.offcn.shop.bean.User;
import com.offcn.shop.service.UserService;
import com.offcn.shop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2020/11/25 0025.
 */
@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Autowired
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
       String username= request.getParameter("username");
       String password=request.getParameter("password");


//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        UserService userService = context.getBean("userService",UserService.class);


           User user=userService.findUser(username,password);


        if(user!=null){
            System.out.println("登录成功");
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/ProductServlet");
        }else {
            System.out.println("登录失败");
            response.sendRedirect("jsp/login.jsp?message=loginerror");


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
