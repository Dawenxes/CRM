package com.edith.bean;

import javax.persistence.*;

/**
 * ClassName： Linkman <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 14:53 <br>
 * @version v1.0 <br>
 **/
@Entity
@Table(name ="cst_linkman")
public class Linkman
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lkm_id;// '联系人编号(主键)',
    @Column
    private String lkm_name;// '联系人姓名',
    @Column
    private String lkm_gender;// '联系人性别',
    @Column
    private String lkm_phone;// '联系人办公电话',
    @Column
    private String lkm_mobile;// '联系人手机',
    @Column
    private String lkm_email;// '联系人邮箱',
    @Column
    private String lkm_position;// '联系人职位',
    @Column
    private String lkm_memo;// '联系人备注',
    // 有一个客户的对象
    @ManyToOne(targetEntity=Customer.class)
    @JoinColumn(name="lkm_cust_id",referencedColumnName="cust_id")
    private Customer customer;

        public Customer getCustomer() {
            return customer;
        }
        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
        public Long getLkm_id() {
            return lkm_id;
        }
        public void setLkm_id(Long lkm_id) {
            this.lkm_id = lkm_id;
        }
        public String getLkm_name() {
            return lkm_name;
        }
        public void setLkm_name(String lkm_name) {
            this.lkm_name = lkm_name;
        }
        public String getLkm_gender() {
            return lkm_gender;
        }
        public void setLkm_gender(String lkm_gender) {
            this.lkm_gender = lkm_gender;
        }
        public String getLkm_phone() {
            return lkm_phone;
        }
        public void setLkm_phone(String lkm_phone) {
            this.lkm_phone = lkm_phone;
        }
        public String getLkm_mobile() {
            return lkm_mobile;
        }
        public void setLkm_mobile(String lkm_mobile) {
            this.lkm_mobile = lkm_mobile;
        }
        public String getLkm_email() {
            return lkm_email;
        }
        public void setLkm_email(String lkm_email) {
            this.lkm_email = lkm_email;
        }
        public String getLkm_position() {
            return lkm_position;
        }
        public void setLkm_position(String lkm_position) {
            this.lkm_position = lkm_position;
        }
        public String getLkm_memo() {
            return lkm_memo;
        }
        public void setLkm_memo(String lkm_memo) {
            this.lkm_memo = lkm_memo;
        }


    }

