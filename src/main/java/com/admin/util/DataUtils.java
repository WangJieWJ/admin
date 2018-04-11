package com.admin.util;

import com.season.common.DateKit;

import java.util.Date;

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

}
