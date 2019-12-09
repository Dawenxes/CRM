package com.edith.dao;

import com.edith.bean.User;
import com.edith.common.dao.BaseDao;

/**
 * ClassName： UserDao <br>
 * Description：  <br>
 * Copyright © 2019 zbn.edith.net Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/6 10:17 <br>
 * @version v1.0 <br>
 **/
public interface UserDao extends BaseDao<User> {
    User findByUserName(String username);
}
