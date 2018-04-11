package com.admin.config;

import com.admin.service.AdminSystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Title: 系统启动加载配置项
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 20:25
 */
@Component
@Order(value = 1)
public class AdminSystemConfigCommandLineRunner implements CommandLineRunner {

    @Autowired
    private AdminSystemConfigService adminSystemConfigService;

    @Override
    public void run(String... args) throws Exception {
        adminSystemConfigService.refreshWeChatConfig();
    }
}
