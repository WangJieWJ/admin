package com.admin.service;

import com.admin.dao.AdminSystemConfigDao;
import com.season.common.SafeKit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * Create Time:2018/4/11 19:23
 */
@Service
public class AdminSystemConfigService {

    @Autowired
    private AdminSystemConfigDao adminSystemConfigDao;

    private static Map<String, String> weChatConfigMap = null;

    private static final Logger logger = Logger.getLogger(AdminSystemConfigService.class);

    /**
     * 刷新配置信息，重新从数据库中获取
     */
    public void refreshWeChatConfig() {
        List<Map<String, Object>> weChatConfigList = adminSystemConfigDao.findAllWeChatConfig();
        if (weChatConfigList == null || weChatConfigList.isEmpty()) {
            logger.error("未配置系统配置信息");
            return;
        }
        Map<String, String> tempWeChatConfigMap = new HashMap<>();
        for (Map<String, Object> itemMap : weChatConfigList) {
            tempWeChatConfigMap.put(SafeKit.getString(itemMap.get("configKey")), SafeKit.getString(itemMap.get("configValue")));
        }
        weChatConfigMap = tempWeChatConfigMap;
        logger.info("【print by wangjie】成功加载基础配置项");
    }

    /**
     * 通过configKey来获取configValue
     *
     * @param configKey key
     */
    public String getWeChatConfigByKey(String configKey) {
        if (weChatConfigMap == null) {
            refreshWeChatConfig();
        }
        return weChatConfigMap.get(configKey);
    }
}
