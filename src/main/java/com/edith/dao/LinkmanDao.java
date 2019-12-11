package com.edith.dao;

import com.edith.bean.Linkman;
import com.edith.common.dao.BaseDao;
import com.edith.common.dao.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * ClassName： LinkmanDao <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 23:19 <br>
 * @version v1.0 <br>
 **/
public interface LinkmanDao extends BaseDao<Linkman> {
    List<Linkman> findByDetachedCriteria(DetachedCriteria detachedCriteria);

    Page<Linkman> findByDCWithPage(DetachedCriteria detachedCriteria, int pageNo, int pageSize);
}
