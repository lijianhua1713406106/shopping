package com.offcn.shop.servlet;

import com.offcn.shop.bean.Product;
import com.offcn.shop.service.ProductService;
import com.offcn.shop.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2020/11/25 0025.
 */
@WebServlet( "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Autowired
    private ProductService productService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        ProductService productService=context.getBean("productService",ProductService.class);

        List<Product> list1=productService.fun(1);
        List<Product> list2=productService.fun(2);

        request.setAttribute("hostList",list1);
        request.setAttribute("optList",list2);


        request.getRequestDispatcher("jsp/product_show.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
