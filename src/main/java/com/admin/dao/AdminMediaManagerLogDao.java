package com.admin.dao;

import com.admin.dao.base.BaseDao;
import com.admin.pojo.AdminMediaManagerLog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 19:44
 */
@Repository
public class AdminMediaManagerLogDao extends BaseDao<AdminMediaManagerLog> {

    /**
     * 获取最新的
     *
     * @param platform 站点ID
     * @param mediaId  素材Id
     */
    public AdminMediaManagerLog findLastMedia(String platform, String mediaId) {
        String sql = "SELECT * FROM admin_media_manager_log WHERE mediaId = :mediaId AND platform = :platform AND storeLocation IS NOT NULL ORDER BY createTime DESC LIMIT 1";
        Map<String, Object> param = new HashMap<>();
        param.put("mediaId", mediaId);
        param.put("platform", platform);

        List<AdminMediaManagerLog> adminMediaManagerLogList = slaverSeasonDao.find(AdminMediaManagerLog.class, param, sql);
        if (adminMediaManagerLogList != null && !adminMediaManagerLogList.isEmpty()) {
            return adminMediaManagerLogList.get(0);
        }
        return null;
    }
}
