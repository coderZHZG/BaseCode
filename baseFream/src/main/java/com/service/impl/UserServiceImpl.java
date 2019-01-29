package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhiguo on 2018/12/4.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        return userDao.list(map);
    }
}
