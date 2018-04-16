DROP TABLE IF EXISTS `admin_media_manager_log`;
CREATE TABLE `admin_media_manager_log`(
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `type` INT(2) DEFAULT NULL COMMENT '素材类型:1-上传图片文件获取的URL地址;2-上传素材获取素材Id;3-用户输入的图片素材获取素材Id',
    `platform` INT (2) DEFAULT NULL COMMENT '站点Id',
    `contentType` VARCHAR(20) DEFAULT NULL COMMENT '文件类型',
    `storeLocation` VARCHAR(255) DEFAULT NULL COMMENT '本地存放位置',
    `createTime` DATETIME DEFAULT NULL COMMENT '操作时间',
    `mediaId` VARCHAR(200) DEFAULT NULL COMMENT '对外访问地址',
    `desc` VARCHAR(100) DEFAULT NULL COMMENT '素材描述',
    PRIMARY KEY (`id`),
    KEY `MEDIA_INDEX` (`mediaId`),
    KEY `CREATETIME_INDEX` (`createTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='admin_media_manager_log微信图片素材管理表 记录表';


DROP TABLE IF EXISTS `admin_system_config`;
CREATE TABLE `admin_system_config` (
    `configId` INT(11) NOT NULL AUTO_INCREMENT,
    `configType` INT(6) NOT NULL DEFAULT 0,
    `configKey` VARCHAR(50) NOT NULL,
    `configValue` VARCHAR(500) DEFAULT NULL,
    `configDesc` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`configId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='admin_system_config系统配置信息 记录表';
ALTER TABLE admin_system_config ADD UNIQUE KEY(`configKey`);

INSERT INTO admin_system_config(`configKey`,`configValue`,`configDesc`)
VALUES('TEST_UPLOAD_MEDIA_FILE_MAX_SIZE',1024,'图片素材上传大小限制(单位KB)'),
    ('TEST_UPLOAD_MEDIA_FILE_PERMIT_TYPE','JPEG,JPG,PNG','图片素材上传文件类型限制,多个使用逗号分隔'),
    ('TEST_UPLOAD_MEDIA_FILE_STORE_LOCATION','test','图片素材上传临时文件路径');

DROP TABLE IF EXISTS `admin_operation_logInfo`;
CREATE TABLE `admin_operation_logInfo`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `userId` INT(11) DEFAULT NULL COMMENT '操作人Id',
    `logType` INT(2) DEFAULT NULL COMMENT '日志类别',
    `desc` VARCHAR(500) DEFAULT NULL COMMENT '操作日志描述',
    `url` varchar(255) DEFAULT NULL COMMENT '调用链接',
    `requestCookie` text DEFAULT NULL COMMENT '操作者的Cookie值',
    `operationType` varchar(10) DEFAULT NULL COMMENT '操作类型,POST/GET',
    `operationParam` text DEFAULT NULL COMMENT '操作提交的数据',
    `resultCode` int(4) DEFAULT NULL COMMENT '调用状态码',
    `resultContent` text DEFAULT NULL COMMENT '调用结果',
    `createTime` DATETIME DEFAULT NULL COMMENT '创建时间',
    `consumeTime` INT(11) DEFAULT NULL COMMENT '消耗时间',
    `extend1` varchar(255) DEFAULT NULL COMMENT '扩展字段1',
    PRIMARY KEY (`id`),
    KEY `LOGTYPE_INDEX` (`logType`),
    KEY `CREATETIME_INDEX` (`createTime`),
    KEY `CONSUMETIME_INDEX` (`consumeTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='admin_operation_logInfo系统操作日志 记录表';