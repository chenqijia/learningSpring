package com.shsxt.chapter3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class RoleAspect {

    @Pointcut("execution(* com.shsxt.chapter3.RoleServiceImpl.printRole(..))")
    public void print()
    {

    }
    @Before("print()") //代理对象的方法事先调用
    public void before()
    {
        System.out.println("before....");
    }

    @Around("print()")
    public void around(ProceedingJoinPoint jp)
    {
        System.out.println("around before");
        try{
            jp.proceed();
        }catch(Throwable e)
        {
            new RuntimeException("回调有异常");
        }
        System.out.println("around after .....");
    }


    @After("print()") //后置通知
    public void after()
    {
        System.out.println("after....");
    }

    @AfterReturning("print()") //返回通知 无异常
    public void afterReturning()
    {
        System.out.println("afterReturning");
    }

    @AfterThrowing("print()") //异常通知
    public void afterThrowing()
    {
        System.out.println("afterThrowing");
    }

}
