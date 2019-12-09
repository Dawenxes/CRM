package com.edith.service;

import com.edith.bean.BaseDict;
import com.edith.bean.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * ClassName： CustomerService <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 22:22 <br>
 * @version v1.0 <br>
 **/
public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    List<BaseDict> findLevelList();

    List<BaseDict> findSourceList();

    List<BaseDict> findIndustryList();

    List<Customer> findByDetachedCriteria(DetachedCriteria detachedCriteria);

    Customer findByCustomId(Long cust_id);

    void update(Customer customer);

    void delete(Long cust_id);
}
