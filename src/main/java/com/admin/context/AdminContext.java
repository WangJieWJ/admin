package com.admin.context;

import com.admin.pojo.AppUser;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/10 21:56
 */
public class AdminContext {

    private AdminContext() {
        throw new IllegalStateException("Utility class");
    }

    private static final ThreadLocal<AppUser> threadLocal = new ThreadLocal<>();

    public static void setAppUserThreadLocal(AppUser appuser) {
        threadLocal.set(appuser);
    }

    public static void removeAppUserThreadLocal() {
        threadLocal.remove();
    }

    public static AppUser getLoginUser() {
        return threadLocal.get();
    }

    //保存开始时间
    private static final ThreadLocal<Long> operationStartTimeThreadLocal = new ThreadLocal<>();

    public static void setOperationStartTime(Long startTime) {
        operationStartTimeThreadLocal.set(startTime);
    }

    public static void removeOperationStartTime() {
        operationStartTimeThreadLocal.remove();
    }

    public static Long getConsumeTime() {
        return (System.currentTimeMillis() - operationStartTimeThreadLocal.get());
    }
}
