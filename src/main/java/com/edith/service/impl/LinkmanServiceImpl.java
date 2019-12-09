package com.edith.service.impl;

import com.edith.bean.Customer;
import com.edith.bean.Linkman;
import com.edith.dao.CustomerDao;
import com.edith.dao.LinkmanDao;
import com.edith.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName： LinkmanServiceImpl <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 22:54 <br>
 * @version v1.0 <br>
 **/
@Service("linkmanService")
@Transactional
public class LinkmanServiceImpl implements LinkmanService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkmanDao linkmanDao;

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAll(Customer.class);
    }

    @Override
    public void add(Linkman linkman) {
        linkmanDao.save(linkman);
    }
}
