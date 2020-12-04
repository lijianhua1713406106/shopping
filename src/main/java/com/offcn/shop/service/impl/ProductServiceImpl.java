package com.offcn.shop.service.impl;

import com.offcn.shop.bean.Product;
import com.offcn.shop.dao.ProductDao;
import com.offcn.shop.dao.impl.ProductDaoImpl;
import com.offcn.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/11/25 0025.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> fun(int prostate) {
        return productDao.fun(prostate);


    }

    @Override
    public Product getProductById(int proId) {
        return productDao.getProductById(proId);
    }
}
