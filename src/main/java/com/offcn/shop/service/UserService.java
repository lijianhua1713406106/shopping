package com.offcn.shop.service;

import com.offcn.shop.bean.User;

/**
 * Created by Administrator on 2020/11/24 0024.
 */
public interface UserService {
    public boolean zhuCe(User user);
    public User findUser(String username, String password);
}
