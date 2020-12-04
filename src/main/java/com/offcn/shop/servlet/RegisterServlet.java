package com.offcn.shop.servlet;

import com.offcn.shop.bean.User;
import com.offcn.shop.service.UserService;
import com.offcn.shop.service.impl.UserServiceImpl;
import com.offcn.shop.util.StrToDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2020/11/24 0024.
 */
@WebServlet( "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.设置编码
        request.setCharacterEncoding("utf-8");
//        2.接受数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        Date birthday= StrToDate.getDate(request.getParameter("birthday"));
//        3.将接收到数据封装到javabean 便于传递给Service层
        User user  = new User();
        user.setUsername(username);
        user.setName(username);
        user.setPassword(password);
        user.setEmial(email);
        user.setSex(sex);
        user.setBirthday(birthday);

        UserService userService=new UserServiceImpl();
        boolean result=userService.zhuCe(user);
        if(result){
            System.out.println("注册成功");
            response.sendRedirect("jsp/login.jsp");
        }else {
            System.out.println("注册失败");
            response.sendRedirect("jsp/register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
