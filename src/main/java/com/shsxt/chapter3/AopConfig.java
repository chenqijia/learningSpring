package com.shsxt.chapter3;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@EnableAspectJAutoProxy
@ComponentScan("com.shsxt.chapter3")
public class AopConfig {
    @Bean
    public RoleAspect getRoleAspect()
    {
        return new RoleAspect();
    }
}
