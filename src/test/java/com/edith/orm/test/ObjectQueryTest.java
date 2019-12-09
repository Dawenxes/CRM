package com.edith.orm.test;

import com.edith.Utils.HibernateUtils;
import com.edith.bean.Customer;
import com.edith.bean.Linkman;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * ClassName： com.edith.orm.test.ObjectQueryTest <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 17:06 <br>
 * @version v1.0 <br>
 **/
public class ObjectQueryTest {
    @Test
    public void test1()
    {
        // 1  查询客户下面所有的联系人数量
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1L);
        System.out.println(customer.getLinkmans().size());
        tx.commit();
        session.close();

    }


    @Test
    public void test2()
    {
        //2 查询当前联系人的所属客户名字?
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Linkman linkman = session.get(Linkman.class, 1L);
        System.out.println(linkman.getCustomer().getCust_name());
        tx.commit();
        session.close();
    }
}
