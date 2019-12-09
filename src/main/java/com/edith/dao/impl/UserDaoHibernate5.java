package com.edith.dao.impl;

import com.edith.bean.Customer;
import com.edith.bean.User;
import com.edith.common.dao.impl.BaseDaoHibernate5;
import com.edith.dao.CustomerDao;
import com.edith.dao.UserDao;

import java.util.Queue;

/**
 * ClassName： UserDaoHibernate5 <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/6 10:18 <br>
 * @version v1.0 <br>
 **/
public class UserDaoHibernate5 extends BaseDaoHibernate5<User> implements UserDao {

    @Override
    public User findByUserName(String username) {

        return null;
    }
}
