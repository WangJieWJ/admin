package com.admin.web.rest;

import com.admin.service.AdminSystemConfigService;
import com.admin.web.api.AdminSystemConfigApi;
import com.season.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 19:28
 */
@RestController
@RequestMapping("/adminSystemConfig")
public class AdminSystemConfigController implements AdminSystemConfigApi {

    @Autowired
    private AdminSystemConfigService adminSystemConfigService;

    @Override
    @PostMapping(value = "queryConfigByKey")
    public Result<String> queryConfigByKey(String configKey) {
        return Result.success(adminSystemConfigService.getWeChatConfigByKey(configKey));
    }

    @Override
    @PostMapping(value = "refreshConfig")
    public Result<String> refreshConfig() {
        adminSystemConfigService.refreshWeChatConfig();
        return Result.success("配置信息刷新成功");
    }
}
