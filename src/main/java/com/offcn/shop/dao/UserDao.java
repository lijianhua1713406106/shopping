package com.offcn.shop.dao;

import com.offcn.shop.bean.User;

/**
 * Created by Administrator on 2020/11/24 0024.
 */
public interface UserDao {
    public int zhuCe(User user);
    public User findUser(String username, String password);
}
