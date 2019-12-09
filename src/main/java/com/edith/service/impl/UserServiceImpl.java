package com.edith.service.impl;

import com.edith.Utils.HibernateUtils;
import com.edith.bean.User;
import com.edith.dao.impl.CustomerDaoHibernate5;
import com.edith.dao.impl.UserDaoHibernate5;
import com.edith.service.UserService;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * ClassName： UserServiceImpl <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/6 10:15 <br>
 * @version v1.0 <br>
 **/
public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {
        UserDaoHibernate5 userDao = new UserDaoHibernate5();
        Transaction transaction = userDao.getSessionFactory().getCurrentSession().getTransaction();
        transaction.begin();
        Query query=userDao.getSessionFactory().getCurrentSession().createQuery("from sys_user where user_name=?");
        //userDao.findByUserName(user.getUser_name());
        query.setParameter(0, user.getUser_name());
        User user1 = (User) query.uniqueResult();
        transaction.commit();
        return user1;
    }
}
