package com.edith.action;

import com.edith.bean.Customer;
import com.edith.bean.Linkman;
import com.edith.common.dao.Page;
import com.edith.service.LinkmanService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * ClassName： LInkManAction <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/9 22:48 <br>
 * @version v1.0 <br>
 **/
@Controller("linkmanAction")
@Scope("prototype")
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman>{
    private final static int pageSize=3;
    @Autowired
    private LinkmanService linkmanService;
    // 单个联系人
    private Linkman linkmanFind;
    private Page<Linkman> page;



    private int pageNo=1;
    private Linkman linkman = new Linkman();
    private List<Customer> allCustomer;
    private List<Linkman> allLinkman;
    public List<Customer> getAllCustomer() {
        return allCustomer;
    }
    public List<Linkman> getAllLinkman() {
        return allLinkman;
    }
    public Linkman getLinkmanFind() {
        return linkmanFind;
    }
    @Override
    public Linkman getModel() {
        return linkman;
    }
    public String addUI() {
        allCustomer=linkmanService.findAllCustomer();
        return "addUI";
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String add() {
        linkmanService.add(linkman);
        return "tolist";
    }
    public String list() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Linkman.class);
        if(!("".equals(linkman.getLkm_name()))&&linkman.getLkm_name()!=null) {
            detachedCriteria.add(Restrictions.like("lkm_name", "%" + linkman.getLkm_name() + "%"));
        }
        // 当没有请选择的时候,才添加条件
        if(linkman.getCustomer()!=null&&linkman.getCustomer().getCust_id()!=-1) {
            detachedCriteria.add(Restrictions.eq("customer.cust_id",linkman.getCustomer().getCust_id()));
        }
        allCustomer = linkmanService.findAllCustomer();


        page = linkmanService.findByPage(detachedCriteria,pageNo,pageSize);
        return SUCCESS;
    }

    public String editUI() {
        allCustomer=linkmanService.findAllCustomer();
        linkmanFind = linkmanService.get(linkman.getLkm_id());
        return "editUI";
    }
    public String update() {
        linkmanService.update(linkman);
        return "tolist";
    }
    public String delete() {
        linkmanService.delete(linkman.getLkm_id());
        return "tolist";
    }

    public Page<Linkman> getPage() {
        return page;
    }
}
