package com.offcn.shop.service.impl;

import com.offcn.shop.bean.User;
import com.offcn.shop.dao.UserDao;
import com.offcn.shop.dao.impl.UserDaoImpl;
import com.offcn.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/11/24 0024.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean zhuCe(User user) {
        int result=userDao.zhuCe(user);
        if(result==1){
            return true;
        }
        return false;
    }

    @Override
        public User findUser(String username, String password) {
        try {
            return userDao.findUser(username,password);
        }catch (Exception e){
            return null;
        }
    }
}
