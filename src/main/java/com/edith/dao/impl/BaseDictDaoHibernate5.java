package com.edith.dao.impl;

import com.edith.bean.BaseDict;
import com.edith.common.dao.impl.BaseDaoHibernate5;
import com.edith.dao.BaseDictDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName： BaseDictDaoHibernate5 <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 13:45 <br>
 * @version v1.0 <br>
 **/
@Repository("baseDictDao")
public class BaseDictDaoHibernate5 extends BaseDaoHibernate5<BaseDict> implements BaseDictDao {
    @Override
    public List<BaseDict> findBaseDictByTypeCode(String dict_type_code) {
        return find("FROM BaseDict bd WHERE bd.dict_type_code= ?0",dict_type_code);
    }
}
