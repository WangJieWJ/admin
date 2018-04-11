package com.admin.dao;

import com.admin.dao.base.BaseDao;
import com.admin.pojo.AdminSystemConfig;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 17:57
 */
@Repository
public class AdminSystemConfigDao extends BaseDao<AdminSystemConfig> {

    /**
     * 查询所有的系统配置信息
     */
    public List<Map<String, Object>> findAllWeChatConfig() {
        String sql = "SELECT configKey,configValue FROM admin_system_config";
        return slaverSeasonDao.query(sql);
    }
}
