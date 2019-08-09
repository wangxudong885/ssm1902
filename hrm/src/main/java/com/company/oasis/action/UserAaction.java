package com.company.oasis.action;

import com.company.oasis.common.Result;
import com.company.oasis.dao.pojo.User;
import com.company.oasis.service.iservice.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserAaction {

    @Autowired
    UserService userService;
    @RequestMapping("userExist.do")
    @ResponseBody
    public String userExist(@Param("username") String username){
    String msg =userService.userExist(username);
    return msg;
    }
    @RequestMapping("registry.do")
    @ResponseBody
    public String registry(String username,String pwd1,String pwd2) {

        String msg = Result.ERROR;
        if (pwd1.equals(pwd2)) {
            User user = new User(username, pwd1);
            msg = userService.registry(user);
        }
        return msg;
    }
    @RequestMapping("login.do")
    @ResponseBody
    public String login(User user){
        User result =userService.login(user);
        return result!=null?Result.SUCCESS:Result.ERROR;
    }
}
