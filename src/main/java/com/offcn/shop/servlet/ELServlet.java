package com.offcn.shop.servlet;

import com.offcn.shop.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/11/25 0025.
 */
@WebServlet( "/ELServlet")
public class ELServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","张三丰");

        request.getRequestDispatcher("/jsp/ELjsp.jsp").forward(request,response);

        User user = new User();
        user.setName("李四");
        user.setSex("男");
        user.setAge(20);

        List<User> list = new ArrayList<>();
        list.add(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
