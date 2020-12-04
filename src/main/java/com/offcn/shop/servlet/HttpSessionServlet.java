package com.offcn.shop.servlet;

import com.offcn.shop.bean.User;
import com.offcn.shop.service.UserService;
import com.offcn.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2020/11/26 0026.
 */
@WebServlet("/HttpSessionServlet")
public class HttpSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession session = request.getSession();
        String id=session.getId();
        System.out.println();
        session.setAttribute("sessionname","张三丰");
        request.setAttribute("requestname","赵敏");

        request.getRequestDispatcher("/jsp/session.jsp").forward(request,response);*/

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        User user = userService.findUser(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        request.getRequestDispatcher("/jsp/product_show.jsp").forward(request,response);
    }
}
