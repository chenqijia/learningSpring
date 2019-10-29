package com.shsxt.service;

import com.shsxt.chapter.ComplexAssembly;
import com.shsxt.chapter.Role;
import com.shsxt.chapter.UserRoleAssembly;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest {
    @Test
    public void test1() throws Exception
    {
        /**
         * 1.加载Spring配置文件
         * 2.取出Bean容器中的实例
         * 3.调用bean方法
         */

        //加载Spring配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        //取出bean容器中的实例
        UserRoleAssembly complexAssembly=(UserRoleAssembly)context.getBean("userRoleAssembly");
        //调用bean方法
        System.out.println(complexAssembly);
    }
}
