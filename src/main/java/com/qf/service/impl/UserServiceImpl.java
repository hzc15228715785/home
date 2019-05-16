package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.IUserDao;
import com.qf.entity.User;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @user hzc
 * @data 2019/5/16 20:03
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public User getpass(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public int update(User user) {
        return userDao.updateById(user);
    }
}
