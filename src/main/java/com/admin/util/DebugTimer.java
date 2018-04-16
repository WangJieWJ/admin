package com.admin.util;

import java.util.Date;

/**
 * Title:
 * Description: 一个简单的 秒表 类，精度为毫秒。
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: vipWeChat
 * Author: 王杰
 * Create Time:2018/4/11 13:41
 */
public class DebugTimer {

    private long startTime;
    private long endTime;
    private Date startDateTime;

    public Date start() {
        startDateTime = new Date();
        this.startTime = startDateTime.getTime();
        return startDateTime;
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getTime() {
        return endTime - startTime;
    }
}
