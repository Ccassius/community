package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
 
/**
 * @author xh
 * @create 2021-12-19 22:31
 */
@Component
@Aspect
public class AlphaAspect {

    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        //System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        //System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterRetuning() {
        //System.out.println("afterRetuning");
    }

    // 抛出异常才织入
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        //System.out.println("afterThrowing");
    }

    // 前后都织入
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //System.out.println("around before");
        Object obj = joinPoint.proceed();
        //System.out.println("around after");
        return obj;
    }

}

