package com.admin.pojo.base;

import com.admin.context.AdminContext;
import com.admin.pojo.AppUser;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Title: pojo基类
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/2/22 10:49
 */
public abstract class BasePojo implements IPojo {

    private Long id;//主键ID

    public BasePojo() {

    }

    public BasePojo(Long id) {
        this.id = id;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        if (id != null) {
            throw new IllegalArgumentException("id is not null");
        }
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }
    }

    /**
     * 获取当前登录用户的id
     *
     * @return
     */
    @JSONField(deserialize = false, serialize = false)
    public Long getCurrUserId() {
        //获取登录用户id
        AppUser appUser = AdminContext.getLoginUser();
        if (appUser != null) {
            return appUser.getId();
        }
        return null;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
