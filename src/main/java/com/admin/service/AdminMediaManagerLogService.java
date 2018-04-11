package com.admin.service;

import com.admin.dao.AdminMediaManagerLogDao;
import com.admin.pojo.AdminMediaManagerLog;
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
 * Create Time:2018/4/11 19:47
 */
@Service
public class AdminMediaManagerLogService {

    @Autowired
    private AdminMediaManagerLogDao adminMediaManagerLogDao;


    /**
     * 保存媒体素材日志
     *
     * @param adminMediaManagerLog 待保存的媒体素材
     */
    @Async
    public AdminMediaManagerLog syncSave(AdminMediaManagerLog adminMediaManagerLog) {
        return adminMediaManagerLogDao.save(adminMediaManagerLog);
    }

    /**
     * 查询最新的媒体素材
     *
     * @param platform 站点Id
     * @param mediaId  媒体素材mediaId
     */
    public AdminMediaManagerLog findLastMedia(String platform, String mediaId) {
        return adminMediaManagerLogDao.findLastMedia(platform, mediaId);
    }

}
