package com.edith.service.impl;

import com.edith.Utils.HibernateUtils;
import com.edith.bean.BaseDict;
import com.edith.bean.Customer;
import com.edith.dao.BaseDictDao;
import com.edith.dao.CustomerDao;
import com.edith.dao.impl.CustomerDaoHibernate5;
import com.edith.service.CustomerService;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName： CustomerServiceImpl <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 22:23 <br>
 * @version v1.0 <br>
 **/
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private static final String LEVEL_ID = "006";
    private static final String SOURCE_ID = "002";
    private static final String INDUSTRY_ID = "001";
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private BaseDictDao baseDictDao;
    @Override
    public List<Customer> findAll() {
        List<Customer> customers=customerDao.findAll(Customer.class);
        return customers;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public List<BaseDict> findLevelList() {
        return baseDictDao.findBaseDictByTypeCode(LEVEL_ID);

    }

    @Override
    public List<BaseDict> findSourceList() {
        return baseDictDao.findBaseDictByTypeCode(SOURCE_ID);
    }

    @Override
    public List<BaseDict> findIndustryList() {
        return baseDictDao.findBaseDictByTypeCode(INDUSTRY_ID);
    }

    @Override
    public List<Customer> findByDetachedCriteria(DetachedCriteria detachedCriteria) {
        return customerDao.findByDetachedCriteria(detachedCriteria);
    }

    @Override
    public Customer findByCustomId(Long cust_id) {
        return customerDao.get(Customer.class, cust_id);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(Long cust_id) {
        customerDao.delete(Customer.class, cust_id);
    }


}
