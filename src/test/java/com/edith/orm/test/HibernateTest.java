package com.edith.orm.test;

import com.edith.Utils.HibernateUtils;
import com.edith.bean.Customer;
import com.edith.dao.CustomerDao;
import com.edith.dao.impl.CustomerDaoHibernate5;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

/**
 * ClassName： Hibernate <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 10:05 <br>
 * @version v1.0 <br>
 **/
public class HibernateTest {
    @Test
    public void SessionTest() {
        Session session = HibernateUtils.openSession();
        CustomerDaoHibernate5 customerDao = new CustomerDaoHibernate5();
        Transaction transaction = customerDao.getSessionFactory().getCurrentSession().beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("zzzz");

        Serializable s1=customerDao.save(customer);
        transaction.commit();

        Customer customer1 = session.get(Customer.class, s1);
        //transaction.commit();
    }
}
