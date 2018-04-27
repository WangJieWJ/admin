package com.admin.auth;

import java.lang.annotation.*;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/23 21:37
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface AdminAuth {

    /**
     * 是否要求超级管理员登录
     */
    boolean requiredAdmin() default true;
    /**
     * 用户权限字符串
     */
    String operateKey() default "";
}
