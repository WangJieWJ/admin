package com.admin.auth;

import com.admin.context.AdminContext;
import com.admin.pojo.AdminOperationLogInfo;
import com.admin.service.AdminOperationLogInfoService;
import com.admin.util.DataUtils;
import com.alibaba.fastjson.JSON;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/10 21:54
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private AdminOperationLogInfoService adminOperationLogInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断当前请求是否允许
        //存放traceId
        MDC.put("traceId", DataUtils.getUniqueTraceId());
        //日志保存
        AdminOperationLogInfo adminOperationLogInfo = new AdminOperationLogInfo();
        adminOperationLogInfo.setRequestCookie(JSON.toJSONString(request.getCookies()));
        adminOperationLogInfo.setOperationType(request.getMethod());
        adminOperationLogInfo.setUrl(request.getServletPath());
        adminOperationLogInfo.setCreateTime(new Date());
        adminOperationLogInfo.setUserId(123456L);
        adminOperationLogInfo.setOperationParam("请求地址中的参数:" + JSON.toJSONString(request.getParameterMap()));
        AdminContext.setOperationLogInfo(adminOperationLogInfo);
        logger.info("【print by wangjie】请求开始;请求地址为:{};请求参数为:{};", request.getServletPath(), request.getQueryString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //请求处理结束，从threadLocal中删除用户信息
        AdminOperationLogInfo adminOperationLogInfo = AdminContext.getOperationLogInfo();
        adminOperationLogInfo.setResultCode(response.getStatus());
        adminOperationLogInfo.setConsumeTime(System.currentTimeMillis() - adminOperationLogInfo.getCreateTime().getTime());
        logger.info("【print by wangjie】请求结束;请求耗时:{}ms;", adminOperationLogInfo.getConsumeTime());
        adminOperationLogInfoService.asyncSave(adminOperationLogInfo);
        AdminContext.removeOperationLogInfo();
    }
}
