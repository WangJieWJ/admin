package com.admin.service;

import com.admin.constant.AdminConstant;
import com.admin.pojo.AdminMediaManagerLog;
import com.admin.util.DataUtils;
import com.alibaba.fastjson.JSONObject;
import com.season.common.ArrayKit;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Title: 文件上传服务测试
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 17:30
 */
@Service
public class FileUploadService {

    @Autowired
    private AdminSystemConfigService adminSystemConfigService;
    @Autowired
    private AdminMediaManagerLogService adminMediaManagerLogService;

    @Value("${file.uploadPath}")
    private String fileUploadPath;

    private static final Logger logger = Logger.getLogger(FileUploadService.class);

    public String uploadTestMedia(MultipartFile file) {
        //从配置文件中获取  文件大小、文件类型、存放位置(文件夹的名称)、

        long fileMaxSize = Long.parseLong(adminSystemConfigService.getWeChatConfigByKey(AdminConstant.TEST_UPLOAD_MEDIA_FILE_MAX_SIZE)) << 10;
        String filePermitType = adminSystemConfigService.getWeChatConfigByKey(AdminConstant.TEST_UPLOAD_MEDIA_FILE_PERMIT_TYPE);
        String fileStoreLocation = adminSystemConfigService.getWeChatConfigByKey(AdminConstant.TEST_UPLOAD_MEDIA_FILE_STORE_LOCATION);

        return uploadMedia(file, fileMaxSize, filePermitType, fileStoreLocation);
    }


    /**
     * 上传图片素材到腾讯服务器
     *
     * @param file              待上传文件
     * @param fileMaxSize       文件大小限制
     * @param filePermitType    文件允许类型
     * @param fileStoreLocation 文件存储位置
     */
    private String uploadMedia(MultipartFile file, long fileMaxSize, String filePermitType, String fileStoreLocation) {

        JSONObject resultJson = new JSONObject();
        try {
            String errorMsg = checkFile(file, fileMaxSize, filePermitType);
            if (StringUtils.isNotBlank(errorMsg)) {
                resultJson.put("errorMsg", errorMsg);
                return resultJson.toJSONString();
            }
            String fileUploadPathDir = fileUploadPath + fileStoreLocation + DataUtils.getFormatFilePath();
            if (!createDir(fileUploadPathDir)) {
                logger.error("【print by wangjie】临时文件创建失败,fileUploadPathDir:" + fileUploadPathDir);
                resultJson.put("errorMsg", "临时文件创建失败,fileUploadPathDir:" + fileUploadPathDir);
                return resultJson.toJSONString();
            }
            File tempFile = new File(fileUploadPathDir + file.getOriginalFilename());
            file.transferTo(tempFile);
            FileSystemResource resource = new FileSystemResource(tempFile);
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            param.add("buffer", resource);
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(param);

            AdminMediaManagerLog adminMediaManagerLog = new AdminMediaManagerLog();
            adminMediaManagerLog.setType(AdminMediaManagerLog.TYPE1);
            adminMediaManagerLog.setPlatform(AdminMediaManagerLog.PLATFORM1);
            adminMediaManagerLog.setContentType("");
            adminMediaManagerLog.setStoreLocation(tempFile.getAbsolutePath());
            adminMediaManagerLog.setCreateTime(new Date());
            adminMediaManagerLog.setDesc("测试文件上传");
            adminMediaManagerLog.setMediaId("");
            adminMediaManagerLogService.syncSave(adminMediaManagerLog);

            return tempFile.getAbsolutePath();
        } catch (Exception e) {
            logger.error("【print by wangjie】上传文件失败", e);
            resultJson.put("errorMsg", "文件上传失败,请稍后重试");
            return resultJson.toJSONString();
        }
    }


    /**
     * 创建文件夹
     *
     * @param fileUploadPath 文件夹的路径
     * @return true 存在或者创建成功
     */
    private static boolean createDir(String fileUploadPath) {
        File fileUploadPathDir = new File(fileUploadPath);
        return fileUploadPathDir.exists() || fileUploadPathDir.mkdirs();
    }

    /**
     * @param file           待校验的文件
     * @param fileMaxSize    文件最大(单位为KB)
     * @param filePermitType 文件允许类型
     */
    private static String checkFile(MultipartFile file, long fileMaxSize, String filePermitType) {
        if (file == null || file.isEmpty() || fileMaxSize <= 0 || StringUtils.isBlank(filePermitType)) {
            return "上传文件为空或者未配置文件限制大小、允许上传文件类型";
        }
        long fileSize = file.getSize();
        String fileType = file.getContentType().substring(file.getContentType().indexOf("/") + 1);
        if (fileSize > fileMaxSize) {
            String errorMsg = "文件大小超出限制,文件大小:" + fileSize + ";文件限制大小:" + fileMaxSize;
            logger.error("【print by wangjie】" + errorMsg);
            return errorMsg;
        }
        List<String> filePermitList = ArrayKit.split(filePermitType.toLowerCase());
        if (!filePermitList.contains(fileType)) {
            String errorMsg = "文件类型不允许,文件类型:" + fileType + ";允许的文件类型:" + filePermitType;
            logger.info("【print by wangjie】" + errorMsg);
            return errorMsg;
        }
        return "";
    }
}
