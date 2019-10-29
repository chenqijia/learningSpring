package com.shsxt.chapter2;

import com.shsxt.chapter.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component("RoleService2")
public class RoleServiceImpl2 implements  RoleService2 {
    @Autowired
    private Role role=null;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public void printRoleInfo() {
            System.out.println("id="+role.getId());
            System.out.println("roleName="+role.getRoleName());
            System.out.println("note="+role.getNote());
    }
}
