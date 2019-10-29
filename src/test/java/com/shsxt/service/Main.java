package com.shsxt.service;

import com.shsxt.chapter.Role;
import com.shsxt.chapter3.AopConfig;
import com.shsxt.chapter3.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main( String[] args )
    {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService=(RoleService)ctx.getBean(RoleService.class);
        Role role=new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        roleService.printRole(role);
        System.out.println("#############");
        role=null;
        roleService.printRole(role);
    }
}
