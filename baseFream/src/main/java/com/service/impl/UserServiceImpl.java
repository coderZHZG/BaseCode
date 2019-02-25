package com.service.impl;

import com.common.Tree;
import com.dao.UserDao;
import com.entity.SysPermission;
import com.entity.SysRole;
import com.entity.UserInfo;
import com.service.UserService;
import com.util.BuildTree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
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
    public Page<UserInfo> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        UserInfo userInfo=userDao.findByUsername(username);
        System.out.println("UserInfoServiceImpl.findByUsername()");
       // listMenuTree(userInfo.getId());
        return userInfo;
    }

    @Override
    public UserInfo findByUserCode(String uId) {
        return userDao.findByUserCode(uId);
    }

    @Override
    public List<Tree<SysPermission>> listMenuTree(Integer userId) {
        List<Tree<SysPermission>> trees = new ArrayList<Tree<SysPermission>>();
        UserInfo userInfo =userDao.findById(userId);
        List<SysRole> roleList=userInfo.getRoleList();
        //1.首先把多个角色相同的权限项去除
        //2.把去除重复的放入到一个List集合中
        Map<Integer,SysPermission> sysPermissionMap=new HashMap<Integer,SysPermission>();
        for(SysRole sysRole : roleList){
            List<SysPermission> permissionList=sysRole.getPermissions();
            for(SysPermission sysPermission:permissionList){
                if(!StringUtils.equals("button",sysPermission.getResourceType()) &&!sysPermissionMap.containsKey(sysPermission.getId())){
                    sysPermissionMap.put(sysPermission.getId(),sysPermission);

                    Integer id=sysPermission.getId();
                    Integer pId=sysPermission.getParentId();
                    String name=sysPermission.getName();
                    Tree<SysPermission> sysPermissionTree=new Tree<SysPermission>();
                    sysPermissionTree.setId(id.toString());
                    sysPermissionTree.setText(name);
                    sysPermissionTree.setParentId(pId.toString());
                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("url", sysPermission.getUrl());
                    sysPermissionTree.setAttributes(attributes);
                    trees.add(sysPermissionTree);
                }
            }
        }
        //3.根据父级关系创建树形结构
       // List<SysPermission> listSysPermission=
        List<Tree<SysPermission>> list =BuildTree.buildList(trees,"0");
        return list;
    }

}
