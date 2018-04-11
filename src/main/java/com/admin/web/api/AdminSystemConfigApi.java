package com.admin.web.api;

import com.season.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 19:27
 */
@Api(tags = "adminSystemConfig")
public interface AdminSystemConfigApi {

    @ApiOperation(value = "查询配置值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "configKey", value = "配置项", paramType = "query", dataType = "String", required = true)
    })
    Result<String> queryConfigByKey(String configKey);


    @ApiOperation(value = "刷新配置信息")
    Result<String> refreshConfig();
}
