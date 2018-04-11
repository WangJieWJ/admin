package com.admin.web.rest;

import com.admin.service.FileUploadService;
import com.admin.web.api.FileUploadApi;
import com.season.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Title:文件上传通用服务
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 17:23
 */
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController implements FileUploadApi {

    @Autowired
    private FileUploadService fileUploadService;

    @Override
    @PostMapping(value = "/upload")
    public Result<String> uploadStoreMedia(@RequestParam("file") MultipartFile file) {

        if (file == null) {
            return Result.fail("上传素材不能为空");
        }

        Result<String> result = new Result<>();
        result.setData(fileUploadService.uploadTestMedia(file));
        return Result.success(result);
    }
}
