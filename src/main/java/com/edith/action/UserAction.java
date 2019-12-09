package com.edith.action;

import com.edith.bean.User;
import com.edith.service.UserService;
import com.edith.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ClassName： UserAction <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/6 10:05 <br>
 * @version v1.0 <br>
 **/
public class UserAction  extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    public String login() {
        UserService userService = new UserServiceImpl();
        userService.login(user);
        return "login";
    }
}
