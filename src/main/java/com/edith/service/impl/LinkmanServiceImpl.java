package com.edith.service.impl;

import com.edith.bean.Customer;
import com.edith.bean.Linkman;
import com.edith.common.dao.Page;
import com.edith.dao.CustomerDao;
import com.edith.dao.LinkmanDao;
import com.edith.service.LinkmanService;
import org.hibernate.criterion.DetachedCriteria;
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

    @Override
    public List<Linkman> findAllLinkman() {
        return linkmanDao.findAll(Linkman.class);
    }

    @Override
    public List<Linkman> findByDetachedCriteria(DetachedCriteria detachedCriteria) {
        return  linkmanDao.findByDetachedCriteria(detachedCriteria);

    }

    @Override
    public Linkman get(Long lkm_id) {
        return linkmanDao.get(Linkman.class,lkm_id);
    }

    @Override
    public void update(Linkman linkman) {
        linkmanDao.update(linkman);
    }

    @Override
    public void delete(Long lkm_id) {
        linkmanDao.delete(Linkman.class,lkm_id);
    }

    @Override
    public Page<Linkman> findByPage(DetachedCriteria detachedCriteria, int pageNo, int pageSize) {
        return linkmanDao.findByDCWithPage(detachedCriteria, pageNo, pageSize);
    }
}
