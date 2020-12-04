package com.offcn.shop.service;

import com.offcn.shop.bean.Product;

import java.util.List;

/**
 * Created by Administrator on 2020/11/25 0025.
 */
public interface ProductService {
    public List<Product> fun(int prostate);
    public Product getProductById(int proId);
}
