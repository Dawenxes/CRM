package com.edith.orm.test;

import com.edith.Utils.JPAUtils;
import com.edith.bean.Customer;
import com.edith.bean.Linkman;
import com.edith.bean.Role;
import com.edith.bean.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * ClassName： com.edith.orm.test.JPAQueryTest <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 18:06 <br>
 * @version v1.0 <br>
 **/
public class JPAQueryTest {
    @Test // 普通保存
    public void test1()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 保存一个客户3个联系人
        Customer customer = new Customer();
        customer.setCust_name("马总");

        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("大秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("中秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("小秘");

        // 双向关联(固定)
        customer.getLinkmans().add(linkman1);
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);

        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        linkman3.setCustomer(customer);

        // 保存
        em.persist(customer);
        em.persist(linkman1);
        em.persist(linkman2);
        em.persist(linkman3);

        tx.commit();
        em.close();
    }

    @Test //级联:在操作自己数据的时候 还会把自己关联的数据也操作了
    // 级联保存  保存客户同时把客户下面的联系人都保存了
    // @OneToMany(cascade=CascadeType.PERSIST)
    public void test2()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 保存一个客户3个联系人
        Customer customer = new Customer();
        customer.setCust_name("马总");

        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("大秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("中秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("小秘");

        // 双向关联(固定)
        customer.getLinkmans().add(linkman1);
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);

        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        linkman3.setCustomer(customer);

        // 保存
        em.persist(customer);

        tx.commit();
        em.close();

    }

    @Test //普通删除--报错
    public void test3()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 删除一个客户
        Customer customer = em.find(Customer.class, 1L);
        em.remove(customer);
        tx.commit();
        em.close();
    }

    @Test // 级联删除
    public void test4()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 删除一个客户级联下面关联的联系人
        Customer customer = em.find(Customer.class, 2L);
        em.remove(customer);
        tx.commit();
        em.close();
    }
    @Test // 普通保存
    public void test5()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 2个用户 3个角色
        User user1 = new User();
        user1.setUser_name("jack");
        User user2 = new User();
        user2.setUser_name("rose");

        Role role1 = new Role();
        role1.setRole_name("员工");
        Role role2 = new Role();
        role2.setRole_name("班主任");
        Role role3 = new Role();
        role3.setRole_name("助教");

        // 双向关联
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role1);
        user2.getRoles().add(role3);

        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role3.getUsers().add(user2);

        // 保存
        em.persist(user1);
        em.persist(user2);
        em.persist(role1);
        em.persist(role2);
        em.persist(role3);

        tx.commit();
        em.close();
    }

    @Test // 级联保存
    //@ManyToMany(targetEntity=Role.class,cascade=CascadeType.PERSIST)
    public void test6()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 2个用户 3个角色
        User user1 = new User();
        user1.setUser_name("jack");
        User user2 = new User();
        user2.setUser_name("rose");

        Role role1 = new Role();
        role1.setRole_name("员工");
        Role role2 = new Role();
        role2.setRole_name("班主任");
        Role role3 = new Role();
        role3.setRole_name("助教");

        // 双向关联
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role1);
        user2.getRoles().add(role3);

        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role3.getUsers().add(user2);

        // 保存用户的时候级联保存角色
        em.persist(user1);
        em.persist(user2);

        tx.commit();
        em.close();
    }

    @Test
    // 多对多以后操作的方向性
    // 给一个用户修改角色
    public void test7()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 操作 给jack用户将员工修改成助教
        // 获取jack
        User user = em.find(User.class, 1L);
        // 获取员工
        Role role1 = em.find(Role.class,2L);
        // 获取助教
        Role role3 = em.find(Role.class,3L);
        // 删除员工
        user.getRoles().remove(role1);
        // 添加助教
        user.getRoles().add(role3);
        tx.commit();
        em.close();
    }

    @Test  //普通删除
    public void test8()
    {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = em.find(User.class, 1L);
        em.remove(user);
        tx.commit();
        em.close();
    }
}
