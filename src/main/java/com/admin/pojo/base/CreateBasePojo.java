package com.admin.pojo.base;

import java.util.Date;

/**
 * Title: 带创建人、创建时间的pojo基类
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/2/22 10:59
 */
public class CreateBasePojo extends BasePojo {

    private Long createUserId;//创建人
    private Date createTime;//创建时间

    public CreateBasePojo() {
        super();
    }

    public CreateBasePojo(Long id) {
        super(id);
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        super.preInsert();
        Long userId = getCurrUserId();
        if (userId != null) {
            this.createUserId = userId;
        }
        this.createTime = new Date();
    }
}
