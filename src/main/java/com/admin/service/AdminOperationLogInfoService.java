package com.admin.service;

import com.admin.dao.AdminOperationLogInfoDao;
import com.admin.pojo.AdminOperationLogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/15 22:21
 */
@Service
public class AdminOperationLogInfoService {

    @Autowired
    private AdminOperationLogInfoDao adminOperationLogInfoDao;

    @Async
    public AdminOperationLogInfo asyncSave(AdminOperationLogInfo adminOperationLogInfo) {
        return adminOperationLogInfoDao.save(adminOperationLogInfo);
    }
}
