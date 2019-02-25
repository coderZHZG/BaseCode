package com.service;

import com.common.Tree;
import com.entity.SysPermission;
import com.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhiguo on 2018/12/4.
 */
@Service
public interface UserService {

    public Page<UserInfo> findAll(Pageable pageable);

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

    public UserInfo findByUserCode(String userCode);

    List<Tree<SysPermission>> listMenuTree(Integer id);
}
