package com.admin.exception;

import com.season.core.error.ErrorVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Title: 自定义异常返回信息
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/23 22:10
 */
@ControllerAdvice
public class AdminAuthExceptionTranslator {

    @ExceptionHandler(AdminAuthException.class)
    public ResponseEntity<ErrorVM> processAdminException(AdminAuthException ex) {
        ex.printStackTrace();
        ResponseEntity.BodyBuilder builder;
        ErrorVM errorVM;
        HttpStatus httpStatus = ex.getHttpStatus();
        builder = ResponseEntity.status(httpStatus);
        errorVM = new ErrorVM("error." + httpStatus.value(), ex.getMessage());
        return builder.body(errorVM);
    }
}
