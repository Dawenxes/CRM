package com.edith.bean;

/**
 * ClassName： Role <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/12/4 15:54 <br>
 * @version v1.0 <br>
 **/
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// 角色 N
@Entity
@Table(name ="sys_role")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id; // 主键
    @Column
    private String role_name; // '角色名称',
    @Column
    private String role_memo; // '备注',

    // 有user的集合
    @ManyToMany(targetEntity=User.class,mappedBy="roles")
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    public Long getRole_id() {
        return role_id;
    }
    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
    public String getRole_name() {
        return role_name;
    }
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    public String getRole_memo() {
        return role_memo;
    }
    public void setRole_memo(String role_memo) {
        this.role_memo = role_memo;
    }


}
