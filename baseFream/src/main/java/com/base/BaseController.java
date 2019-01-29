package com.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangzhiguo on 2018/12/4.
 */


@Controller
@RequestMapping(value = "/baseController")
public class BaseController {

    @RequestMapping(value = "/index")
    public String index(ModelMap map){

        return "index";
    }
}
