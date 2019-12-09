package com.edith.service;

import com.edith.bean.Customer;
import com.edith.bean.Linkman;

import java.util.List;

/**
 * ClassName： LinkmanService <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 22:53 <br>
 * @version v1.0 <br>
 **/
public interface LinkmanService {
    public List<Customer> findAllCustomer();

    void add(Linkman linkman);
}
