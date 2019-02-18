package com.controller;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String count(ModelMap map){
        return "login";
    }
}
