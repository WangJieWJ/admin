package com.admin.pojo.base;

import java.util.Date;

/**
 * Title:带创建人、创建时间、最后修改人、最后修改时间的pojo基类
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/2/22 11:05
 */
public class UpdateBasePojo extends CreateBasePojo {

    public UpdateBasePojo() {
        super();
    }

    public UpdateBasePojo(Long id) {
        super(id);
    }

    private Long lastUpdateUserId;//最后更新人
    private Date lastUpdateTime;//最后更新时间

    public Long getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Long lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        super.preInsert();
        Long userId = getCurrUserId();
        if (userId != null) {
            this.lastUpdateUserId = userId;
        }
        this.lastUpdateTime = new Date();
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        super.preUpdate();
        Long userId = getCurrUserId();
        if (userId != null) {
            this.lastUpdateUserId = userId;
        }
        this.lastUpdateTime = new Date();
    }
}
