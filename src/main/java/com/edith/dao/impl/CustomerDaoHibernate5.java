package com.edith.dao.impl;

import com.edith.bean.BaseDict;
import com.edith.bean.Customer;
import com.edith.common.dao.impl.BaseDaoHibernate5;
import com.edith.dao.CustomerDao;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName： CustomerDaoHibernate5 <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 10:40 <br>
 * @version v1.0 <br>
 **/
@Repository("customerDao")
public class CustomerDaoHibernate5 extends BaseDaoHibernate5<Customer> implements CustomerDao {
    public List<Customer> findByDetachedCriteria(DetachedCriteria detachedCriteria) {
        return findByCriteria(detachedCriteria);
    }


}
