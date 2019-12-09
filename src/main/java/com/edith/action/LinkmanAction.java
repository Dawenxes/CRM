package com.edith.action;

import com.edith.bean.Customer;
import com.edith.bean.Linkman;
import com.edith.service.LinkmanService;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

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
public class LinkmanAction implements ModelDriven<Linkman> {
    @Autowired
    private LinkmanService linkmanService;

    private Linkman linkman = new Linkman();
    private List<Customer> allCustomer;
    public List<Customer> getAllCustomer() {
        return allCustomer;
    }


    @Override
    public Linkman getModel() {
        return linkman;
    }

    public String addUI() {
        allCustomer=linkmanService.findAllCustomer();
        return "addUI";
    }
    public String add() {
        linkmanService.add(linkman);
        return "tolist";
    }



}
