package com.admin.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/23 21:40
 */
@Aspect
@Component
@Order(value = 100)
public class AdminAuthAspect {

    //拦截任何注解了@AdminAuth的方法和类
    @Pointcut("@within(com.admin.auth.AdminAuth) || @annotation(com.admin.auth.AdminAuth)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doAround(final ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        final Method targetMethod = methodSignature.getMethod();
        AdminAuth admin = targetMethod.getAnnotation(AdminAuth.class);
        if (admin == null) {
            Class<?> aClass = point.getTarget().getClass();
            admin = aClass.getAnnotation(AdminAuth.class);
        }
        boolean requiredAdmin = admin.requiredAdmin();
        String operateKey = admin.operateKey();
        //首先校验  requiredAdmin 是否为

        Object[] args = point.getArgs();
        return point.proceed(args);
    }

}
