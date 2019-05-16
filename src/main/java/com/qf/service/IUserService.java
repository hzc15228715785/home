package com.qf.service;

import com.qf.entity.User;

public interface IUserService {

    User selectUserById(Integer id);

    User getpass(String username);

    int update(User user);
}
