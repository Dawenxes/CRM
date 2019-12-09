package com.edith.dao;

import com.edith.bean.BaseDict;
import com.edith.common.dao.BaseDao;

import java.util.List;

/**
 * ClassName： BaseDictDao <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 13:45 <br>
 * @version v1.0 <br>
 **/
public interface BaseDictDao extends BaseDao<BaseDict> {
    List<BaseDict> findBaseDictByTypeCode(String dict_type_code);
}
