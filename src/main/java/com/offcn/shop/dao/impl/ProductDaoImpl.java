package com.offcn.shop.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shop.bean.Product;
import com.offcn.shop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2020/11/25 0025.
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> fun(int prostate) {

        String sql = "select pro_id proId , pro_name proName , pro_num proNum , " +
                " market_price marketPrice , shop_price shopPrice , pro_color proColor, " +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_state = ?";

             return jdbcTemplate.query(sql, new RowMapper<Product>() {
                @Override
                public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                    Product product = new Product();
                    product.setProId(resultSet.getInt("proId"));
                    product.setProName(resultSet.getString("proName"));
                    product.setProNum(resultSet.getString("proNum"));
                    product.setMarketPrice(resultSet.getDouble("marketPrice"));
                    product.setShopPrice(resultSet.getDouble("shopPrice"));
                    product.setProColor(resultSet.getString("proColor"));
                    product.setProTotalCount(resultSet.getInt("proTotalCount"));
                    product.setProMinImg(resultSet.getString("proMinImg"));
                    product.setProstatee(resultSet.getInt("proState"));
                    return product;
                }
            }, prostate);

    }

    @Override
    public Product getProductById(int proId) {

        String sql="select pro_id proId , pro_name proName , pro_num proNum , " +
                " market_price marketPrice , shop_price shopPrice , pro_color proColor, " +
                " pro_total_count proTotalCount , pro_min_img proMinImg , pro_state proState " +
                " from product " +
                " where pro_id=?";


            return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
                @Override
                public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                    Product product = new Product();
                    product.setProId(resultSet.getInt("proId"));
                    product.setProName(resultSet.getString("proName"));
                    product.setProNum(resultSet.getString("proNum"));
                    product.setMarketPrice(resultSet.getDouble("marketPrice"));
                    product.setShopPrice(resultSet.getDouble("shopPrice"));
                    product.setProColor(resultSet.getString("proColor"));
                    product.setProTotalCount(resultSet.getInt("proTotalCount"));
                    product.setProMinImg(resultSet.getString("proMinImg"));
                    product.setProstatee(resultSet.getInt("proState"));
                    return product;
                }
            }, proId);


    }
}
