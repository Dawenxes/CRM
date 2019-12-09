package com.edith.action;

import com.edith.bean.BaseDict;
import com.edith.bean.Customer;
import com.edith.service.BaseDictService;
import com.edith.service.CustomerService;
import com.edith.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName： CustomerAction <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 22:07 <br>
 * @version v1.0 <br>
 **/
@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    @Autowired
    private CustomerService customerService;

    private List<Customer> customerList;

    private Customer customer=new Customer();

    private Customer customerFind;
    private List<BaseDict> levelList;
    private List<BaseDict> sourceList;
    private List<BaseDict> industryList;

    public List<BaseDict> getLevelList() {
        return levelList;
    }

    public List<BaseDict> getSourceList() {
        return sourceList;
    }

    public List<BaseDict> getIndustryList() {
        return industryList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    public Customer getCustomerFind() {
        return customerFind;
    }
    @Override
    public Customer getModel() {
        return customer;
    }

    public String list() {
        customerList=customerService.findAll();
        levelList = customerService.findLevelList();
        sourceList = customerService.findSourceList();
        industryList = customerService.findIndustryList();
        return "tolist";
    }
    public String addUI() {
        levelList = customerService.findLevelList();
        sourceList = customerService.findSourceList();
        industryList = customerService.findIndustryList();
        return "addUI";
    }

    public String save() {
        customerService.save(customer);
        return "toaction";
    }
    public String conditionFind(){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        // 当没有请选择的时候,才添加条件
        if(customer.getCust_level().getDict_id()!=-1)
        {
            detachedCriteria.add(Restrictions.eq("cust_level.dict_id", customer.getCust_level().getDict_id()));
        }
        // 当没有请选择的时候,才添加条件
        if(customer.getCust_source().getDict_id()!=-1)
        {
            detachedCriteria.add(Restrictions.eq("cust_source.dict_id", customer.getCust_source().getDict_id()));
        }
        // 当没有请选择的时候,才添加条件
        if(customer.getCust_industry().getDict_id()!=-1)
        {
            detachedCriteria.add(Restrictions.eq("cust_industry.dict_id", customer.getCust_industry().getDict_id()));
        }
        levelList = customerService.findLevelList();
        sourceList = customerService.findSourceList();
        industryList = customerService.findIndustryList();
        customerList = customerService.findByDetachedCriteria(detachedCriteria);
        return "tolist";
    }
    public String editUI() {
        levelList = customerService.findLevelList();
        sourceList = customerService.findSourceList();
        industryList = customerService.findIndustryList();
        customerFind = customerService.findByCustomId(customer.getCust_id());
        return "editUI";
    }
    public String update() {
        customerService.update(customer);
        return "toaction";
    }
    public String delete() {
        customerService.delete(customer.getCust_id());
        return "toaction";
    }


}
