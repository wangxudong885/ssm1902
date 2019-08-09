package com.company.oasis.service.impl;

import com.company.oasis.common.Result;
import com.company.oasis.dao.UserDao;
import com.company.oasis.dao.pojo.User;
import com.company.oasis.service.iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public String userExist(String username) {
        int result =userDao.userExist(username);
        return result>0? Result.SUCCESS:Result.ERROR;
    }

    @Override
    public String registry(User user) {
        int result=userDao.insertSelective(user);
        return result>0? Result.SUCCESS:Result.ERROR;
    }

    @Override
    public User login(User user) {

        return userDao.login(user);
    }
}
