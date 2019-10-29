package com.shsxt.service;

import com.shsxt.chapter.ApplicationConfig;
import com.shsxt.chapter.PojoConfig;
import com.shsxt.chapter.Role;
import com.shsxt.chapter.RoleService;
import com.shsxt.chapter2.RoleService2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class AnnotationMain {
    @Autowired
    private RoleService2 roleService2;

    public static void main(String [] args)
    {

    }
}
