package com.util;

import com.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

/**
 * Shiro工具类
 */
public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前登陆用户
     * @return
     */
    public static UserInfo getUser() {
        Object object = getSubjct().getPrincipal();
        return (UserInfo)object;
    }

    /**
     * 获取当前用户id
     * @return
     */
    public static Integer getUserId() {
        return getUser().getId();
    }

    /**
     * 登出
     */
    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
}
