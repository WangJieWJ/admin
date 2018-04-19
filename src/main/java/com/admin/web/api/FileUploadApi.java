package com.admin.web.api;

import com.season.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Title: 文件上传通用服务
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 17:22
 */
@Api(tags = "upload",description = "文件上传公共类")
public interface FileUploadApi {

    @ApiOperation(value = "文件上传服务测试")
    Result<String> uploadStoreMedia(@RequestParam("file") MultipartFile file);
}
