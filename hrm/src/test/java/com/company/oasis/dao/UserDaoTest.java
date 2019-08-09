package com.company.oasis.dao;

import com.company.oasis.dao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    UserDao userDao;
    @Test
    public void userExist() {
        System.err.println(userDao.userExist("xier"));
        System.err.println(userDao.userExist("yueer"));
    }

    @Test
    public void login() {
        User user =new User("xier","123");
        User result =userDao.login(user);
        System.err.println(result);
        User user1 =new User("xierer","123");
        User result1 =userDao.login(user1);
        System.err.println(result1);
    }
}