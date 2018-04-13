package com.admin.service;

import com.season.quartz.IQuartzAuthService;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: vipwechat
 * Author: 王杰
 * Create Time:2018/2/22 17:44
 */
@Service
public class QuartzAuthService implements IQuartzAuthService{
    @Override
    public String getCurrUser() {
        return "admin";
    }

    @Override
    public boolean hasRight() {
        return true;
    }
}
