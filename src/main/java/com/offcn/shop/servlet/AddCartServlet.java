package com.offcn.shop.servlet;

import com.offcn.shop.bean.Product;
import com.offcn.shop.service.ProductService;
import com.offcn.shop.service.impl.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2020/11/26 0026.
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        ProductService productService = new ProductServiceImpl();
//        Product product = productService.getProductById(id);
//
//        Map<Product,Integer> cart = new HashMap<>();
//        cart.put(product,quantity);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("cart",cart);

        int id = Integer.parseInt(request.getParameter("proId"));
        int quantity  =Integer.parseInt(request.getParameter("quantity"));

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        ProductService productService=context.getBean("productService",ProductService.class);
        HttpSession session = request.getSession();
        Product product = productService.getProductById(id);
        Map<Product,Integer> cart =(Map<Product, Integer>) session.getAttribute("cart");
        if(cart!=null){
            Set<Product> set = cart.keySet();
            boolean flag=false;
            Product pro=null;
            for(Product p:set){
                if(p.getProId()==product.getProId()){
                    flag=true;
                    pro=p;
                    break;
                }
            }
            if(flag){
                int value=cart.get(pro);

                cart.put(pro,value+quantity);
            }else {
                cart.put(product,quantity);
            }

        }else {
            cart=new HashMap<>();
            cart.put(product,quantity);
            session.setAttribute("cart",cart);
        }
        double total=0.0;
        Set<Product> productSet = cart.keySet();
        for (Product pp:productSet){

            double d=pp.getShopPrice();
            total+=d*cart.get(pp);
        }
        session.setAttribute("total",total);


        request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
//        response.sendRedirect("jsp/cart.jsp");
    }
}
