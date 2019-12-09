package com.edith.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName： BaseDict <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 10:17 <br>
 * @version v1.0 <br>
 **/
@Data
@Entity
@Table(name="base_dict")
public class BaseDict {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dict_id;// '数据字典id(主键)',
    @Column
    private String dict_type_code;// '数据字典类别代码',
    @Column
    private String dict_type_name;//'数据字典类别名称',
    @Column
    private String dict_item_name;// '数据字典项目名称',
    @Column
    private String dict_item_code;// '数据字典项目(可为空)',
    @Column
    private Integer dict_sort;// '排序字段',
    @Column
    private String dict_enable;// '1:使用 0:停用',
    @Column
    private String dict_memo;// '备注',
}
