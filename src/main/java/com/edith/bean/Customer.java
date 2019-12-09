package com.edith.bean;

import javax.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * ClassName： Customer <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/3 17:15 <br>
 * @version v1.0 <br>
 **/
@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;// '客户编号(主键)',
    @Column(name = "cust_name", length = 20, nullable = false, unique = true)
    private String cust_name;// '客户名称(公司名称)',

    @Column
    private String cust_address;// '客户联系地址',
    @Column
    private String cust_phone;// '客户联系电话',


    @Column
    private String cust_mobile;// '客户联系电话',

    @OneToMany(targetEntity = Linkman.class, mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Linkman> linkmans= new HashSet<>();


    // name:外键字段名
    // referencedColumnName: 指向的主键字段名
    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name="cust_level",referencedColumnName="dict_id")
    private BaseDict cust_level;// '客户级别',
    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name="cust_industry",referencedColumnName="dict_id")
    private BaseDict cust_industry;// '客户所属行业',
    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name="cust_source",referencedColumnName="dict_id")
    private BaseDict cust_source;// '客户信息来源',

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }


    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {

        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public Set<Linkman> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(Set<Linkman> linkmans) {
        this.linkmans = linkmans;
    }

    public BaseDict getCust_level() {
        return cust_level;
    }

    public void setCust_level(BaseDict cust_level) {
        this.cust_level = cust_level;
    }

    public BaseDict getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(BaseDict cust_industry) {
        this.cust_industry = cust_industry;
    }

    public BaseDict getCust_source() {
        return cust_source;
    }

    public void setCust_source(BaseDict cust_source) {
        this.cust_source = cust_source;
    }
}
