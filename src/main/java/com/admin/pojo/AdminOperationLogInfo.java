package com.admin.pojo;

import com.admin.pojo.base.BasePojo;
import com.season.orm.dao.annotation.TableInfo;

import java.util.Date;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/15 22:10
 */
@TableInfo(tableName = "admin_operation_logInfo")
public class AdminOperationLogInfo extends BasePojo {

    /**
     * 操作人Id
     */
    private Long userId;
    /**
     * 日志类别
     */
    private Integer logType;
    /**
     * 操作日志描述
     */
    private String desc;
    /**
     * 调用链接
     */
    private String url;
    /**
     * 操作者的Cookie值
     */
    private String requestCookie;
    /**
     * 操作类型,POST/GET
     */
    private String operationType;
    /**
     * 操作提交的数据
     */
    private String operationParam;
    /**
     * 调用状态码
     */
    private Integer resultCode;
    /**
     * 调用结果
     */
    private String resultContent;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 消耗时间
     */
    private Long consumeTime;
    /**
     * 扩展字段1
     */
    private String extend1;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestCookie() {
        return requestCookie;
    }

    public void setRequestCookie(String requestCookie) {
        this.requestCookie = requestCookie;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationParam() {
        return operationParam;
    }

    public void setOperationParam(String operationParam) {
        this.operationParam = operationParam;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }
}
