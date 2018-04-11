package com.admin.constant;

/**
 * Title: 常量类
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 17:25
 */
public class AdminConstant {

    private AdminConstant() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 上传服务测试
     */
    //图片上传大小限制
    public static final String TEST_UPLOAD_MEDIA_FILE_MAX_SIZE = "TEST_UPLOAD_MEDIA_FILE_MAX_SIZE";
    //图片上传文件类型限制,多个使用逗号分隔
    public static final String TEST_UPLOAD_MEDIA_FILE_PERMIT_TYPE = "TEST_UPLOAD_MEDIA_FILE_PERMIT_TYPE";
    //图片上传临时文件路径
    public static final String TEST_UPLOAD_MEDIA_FILE_STORE_LOCATION = "TEST_UPLOAD_MEDIA_FILE_STORE_LOCATION";

}
