package com.admin.pojo;

import com.admin.pojo.base.BasePojo;
import com.season.orm.dao.annotation.TableInfo;
import com.season.orm.dao.annotation.Transient;

import java.util.Date;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/11 19:40
 */
@TableInfo(tableName = "admin_media_manager_log")
public class AdminMediaManagerLog extends BasePojo{
    /**
     * 素材类型:1-上传图片文件获取的URL地址;2-上传素材获取素材Id;3-用户输入的图片素材获取素材Id
     */
    private Integer type;
    @Transient
    public static final Integer TYPE1 = 1;
    @Transient
    public static final Integer TYPE2 = 2;
    @Transient
    public static final Integer TYPE3 = 3;

    /**
     * 站点Id
     */
    private Integer platform;
    @Transient
    public static final Integer PLATFORM1 = 1;

    private String contentType;

    /**
     * 本地存放位置
     */
    private String storeLocation;
    /**
     * 操作时间
     */
    private Date createTime;
    /**
     * 素材的腾讯访问地址或者素材Id
     */
    private String mediaId;
    /**
     * 素材描述
     */
    private String desc;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
