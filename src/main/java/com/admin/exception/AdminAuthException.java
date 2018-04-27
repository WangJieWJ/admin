package com.admin.exception;

import org.springframework.http.HttpStatus;

/**
 * Title: 自定义异常
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/23 21:49
 */
public class AdminAuthException extends RuntimeException {

    private HttpStatus httpStatus;

    public AdminAuthException() {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public AdminAuthException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public AdminAuthException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
