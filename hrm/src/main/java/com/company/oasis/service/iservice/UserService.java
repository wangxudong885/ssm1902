package com.company.oasis.service.iservice;

import com.company.oasis.dao.pojo.User;

public interface UserService {
    String userExist(String username);

    String registry(User user);

    User login(User user);
}
