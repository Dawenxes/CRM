package com.edith.dao;

import com.edith.bean.BaseDict;
import com.edith.bean.Customer;
import com.edith.common.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * ClassName： CustomerDao <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 10:39 <br>
 * @version v1.0 <br>
 **/
public interface CustomerDao extends BaseDao<Customer> {

    List<Customer> findByDetachedCriteria(DetachedCriteria detachedCriteria);
}
