package com.teeboco.demo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TimeCheckAspect {

    @Around("execution(* com.teeboco.demo.service.UserService.*(..))")
    public Object logTimeCheck(ProceedingJoinPoint pip) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal =  pip.proceed(); // 타겟 메서드 호출
        System.out.println("logTimeCheck : " + (System.currentTimeMillis() - begin) + " ms");
        System.out.println("Object name : " + pip.getClass());
        return retVal;
    }


}
