package com.offcn.shop.servlet;

import com.offcn.shop.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2020/11/26 0026.
 */
@WebServlet( "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("proId"));

        HttpSession session = request.getSession();
        Map<Product,Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        if(cart!=null){
            Product product= null;
            Set<Product> set = cart.keySet();
            for (Product pro:set){
                if(pro.getProId()==id){
                    product=pro;
                    break;
                }
            }
            cart.remove(product);
        }


        double total=0.0;
        Set<Product> productSet = cart.keySet();
        for (Product pp:productSet){

            double d=pp.getShopPrice();
            total+=d*cart.get(pp);
        }
        session.setAttribute("total",total);

//        request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
        response.sendRedirect("jsp/cart.jsp");

    }
}
