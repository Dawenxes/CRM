package com.edith.dao.impl;

import com.edith.bean.Linkman;
import com.edith.common.dao.impl.BaseDaoHibernate5;
import com.edith.dao.LinkmanDao;
import org.springframework.stereotype.Repository;

/**
 * ClassName： LinkmanDaoHibernate5 <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 23:20 <br>
 * @version v1.0 <br>
 **/
@Repository("linkmanDao")
public class LinkmanDaoHibernate5 extends BaseDaoHibernate5<Linkman> implements LinkmanDao {
}
