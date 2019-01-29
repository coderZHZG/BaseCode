package com.service;

import com.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhiguo on 2018/12/4.
 */
@Service
public interface UserService {

    int count(Map<String, Object> map);

    List<User> list(Map<String, Object> map);
}
