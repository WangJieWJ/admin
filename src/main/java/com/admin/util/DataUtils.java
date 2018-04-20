package com.admin.util;

import com.season.common.DateKit;

import java.util.Date;
import java.util.Random;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 19:35
 */
public class DataUtils {

    private DataUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getFormatFilePath() {
        return "/" + DateKit.getDateStr(new Date()).replaceAll("-", "/") + "/";
    }


    /**
     * 获取请求唯一的TraceId
     */
    public static String getUniqueTraceId() {
        return System.currentTimeMillis() + getRandomStr(6);
    }

    /**
     * 获取随机字符串
     *
     * @param size 随机串的大小
     */
    private static String getRandomStr(int size) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
