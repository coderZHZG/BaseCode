package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.base.JqueryGrid;
import com.entity.UserInfo;
import com.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhiguo on 2018/12/4.
 */

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService  userService;

    @RequestMapping(value = "/page")
    @RequiresPermissions("user:manage")//权限管理;
    public String page(ModelMap map){
        System.out.println("123");
        return "sys/sysUser";
    }

    @RequestMapping(value = "/list")
    @RequiresPermissions("user:view")//权限管理;
    public void list(ModelMap map, HttpSession session, HttpServletRequest request,
                     HttpServletResponse response) throws Exception{
        String page=request.getParameter("page");
        String rows=request.getParameter("rows");
        Integer pageInt=0;
        Integer rowsInt=0;
        if(!StringUtils.isEmpty(page)&&!StringUtils.isEmpty(rows)){
            pageInt=Integer.valueOf(page)-1;
            rowsInt=Integer.valueOf(rows);
        }
        Sort sort = new Sort(Sort.Direction.ASC, "id");//指定排序字段
        Page<UserInfo> userList=userService.findAll(new PageRequest(pageInt, rowsInt, sort));
        JqueryGrid jq=new JqueryGrid();
        jq.setRows(userList.getContent());
        jq.setPage(Integer.valueOf(page));
        jq.setTotal(userList.getTotalPages());
        jq.setRecords(userList.getTotalElements());

        String result=JSON.toJSONString(jq);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(result);
    }
}
