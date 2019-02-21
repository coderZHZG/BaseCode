package com.controller;

import com.common.Tree;
import com.entity.SysPermission;
import com.service.UserService;
import com.util.ShiroUtils;
import com.base.BaseController;
import com.entity.UserInfo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping({"/","/index"})
    public String login(ModelMap map, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        UserInfo userInfo=getUser();
        map.addAttribute("userInfo",userInfo);
        List<Tree<SysPermission>> listMenuTree=userService.listMenuTree(userInfo.getId());
        map.put("menus",listMenuTree);
        return "/index";
    }

    @RequestMapping(value = "/main")
    public String index(ModelMap map){
        return "main";
    }

    @RequestMapping(value = "/login")
    public String loginIn(ModelMap map, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                UserInfo userInfo = (UserInfo) request.getAttribute("userInfo");
                String account=request.getParameter("account");
                String password=request.getParameter("password");
                UserInfo user=new UserInfo();
                user.setName(account);
                map.addAttribute("user",user);
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        // 此方法不处理登录成功,由shiro进行处理,登陆成功在shiroConfig中配置
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

    @RequestMapping(value = "/logout")
    public String logout(ModelMap map){
        ShiroUtils.logout();
        return "redirect:/login";
    }
}
