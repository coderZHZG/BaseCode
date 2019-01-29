package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/list")
    public String count(ModelMap map){
        Map<String, Object> maps =new HashMap<>();
        List<User> userList=userService.list(maps);
        int count= userService.count(maps);
        map.addAttribute("count",count);
        map.addAttribute("userList",userList);
        return "index";
    }

}
