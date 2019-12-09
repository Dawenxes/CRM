package com.edith.orm.test;

import com.edith.Utils.HibernateUtils;
import com.edith.bean.Customer;
import com.edith.bean.Linkman;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * ClassName： com.edith.orm.test.OneToManyTest <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 15:13 <br>
 * @version v1.0 <br>
 **/
public class OneToManyTest {
    @Test // 保存一个客户和一个联系人
    public void test1()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 操作  保存一个客户和一个联系人
        // 创建一个客户人
        Customer customer = new Customer();
        customer.setCust_name("马总");

        // 创建一个联系人
        Linkman linkman = new Linkman();
        linkman.setLkm_name("小秘");

        // 让客户关联联系人
        customer.getLinkmans().add(linkman);
        // 让联系人关联客户
        linkman.setCustomer(customer);

        // 保存
        session.save(customer);
        session.save(linkman);

        tx.commit();
        session.close();
    }

    @Test  // 级联保存:在保存自己的时候 会把自己关联的数据也保存了
    // 条件: 保存谁 就谁的配置文件上加级联
    // <set name="linkmans"  cascade="save-update">
    public void test2()
    {

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 操作  保存一个客户和3个联系人
        // 创建一个客户人
        Customer customer = new Customer();
        customer.setCust_name("马总");

        // 创建一个联系人
        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("小秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("大秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("中秘");

        // 让客户关联联系人
        customer.getLinkmans().add(linkman1);
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);
        // 让联系人关联客户
        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        linkman3.setCustomer(customer);

        // 保存 (保存一的一方把多的一方的数据也给保存了  掌握)
        session.save(customer);

        // (保存多的一方把一的一方的数据也给保存了  演示下)
			/*session.save(linkman1);
			session.save(linkman2);
			session.save(linkman3);*/

        tx.commit();
        session.close();
    }

    @Test // 级联高级应用
    // 双方都做了级联
    public void test3()
    {
        // 需求:有一个客户 和3个联系人
        // 让联系人1关联客户
        // 让客户关联联系人2和3
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();


        Customer customer = new Customer();
        customer.setCust_name("马总");

        // 创建一个联系人
        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("小秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("大秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("中秘");

        // 联系人1关联客户
        linkman1.setCustomer(customer);

        // 客户关联联系人2和3
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);

        // 级联保存联系人1
        //session.save(linkman1); // 问:发送几条sql语句?  1+1+1+1=4

        //session.save(customer); // 问:发送几条sql语句? 1+1+1=3

        // session.save(linkman2); // 问:发送几条sql语句? 1
        session.save(linkman3); // 问:发送几条sql语句? 1
        tx.commit();
        session.close();

    }

    @Test  // 普通删除
    // 客户下面还有关联的联系人  删不了
    public void test4()
    {
        // 删除马总
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 操作
        Customer customer = session.get(Customer.class,1L);
        session.delete(customer);
        tx.commit();
        session.close();
    }


    @Test  // 级联删除
    // 删除谁  在谁身上设置级联
    // <set name="linkmans" cascade="save-update,delete">
    public void test5()
    {
        // 删除马总
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 删除1的时候,把下面关联的多的数据全都给删除(掌握)
        Customer customer = session.get(Customer.class,1L);
        session.delete(customer);
        tx.commit();
        session.close();
    }

    @Test  // 演示下级联删除
    public void test6()
    {
        // 删除联系人
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        Linkman linkman = session.get(Linkman.class,6L);
        // 根据多的一方删除一的一方的数据(级联删除)
        session.delete(linkman);
        tx.commit();
        session.close();
    }


}
