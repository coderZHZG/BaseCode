package com.base;

import com.util.ShiroUtils;
import com.entity.UserInfo;

/**
 * Created by zhangzhiguo on 2018/12/4.
 */

public class BaseController {
    public UserInfo getUser() {
        return ShiroUtils.getUser();
    }

    public Integer getUserId() {
        return ShiroUtils.getUserId();
    }

    public String getUsername() {
        return getUser().getUsername();
    }

}
