package com.admin.service.objectTypeService;

import com.season.admin.common.ObjectTypeDto;
import com.season.admin.dao.RightDao;
import com.season.admin.service.interfaces.IQueryObjectDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * Title:
 * Description: 对象类型 服务都必须实现该操作
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/17 15:27
 */
public abstract class AbstractObjectTypeService implements IQueryObjectDataService {

    @Autowired
    private RightDao rightDao;

    @Override
    public List<ObjectTypeDto> queryList(Long roleId, Long parentId, Long userId) {
        return buildDefaultObjectTypeDto(roleId);
    }

    @Override
    public List<ObjectTypeDto> queryListByAdmin(Long roleId, Long parentId, Long userId) {
        return buildDefaultObjectTypeDto(roleId);
    }

    /**
     * 构建对象列表
     *
     * @param roleId 角色id
     * @return ObjectTypeDto List
     */
    protected List<ObjectTypeDto> buildDefaultObjectTypeDto(Long roleId) {
        ObjectTypeDto objectTypeDto = new ObjectTypeDto();
        objectTypeDto.setObjectType(getObjectType());
        objectTypeDto.setName(getName());
        objectTypeDto.setLevel(1);
        objectTypeDto.setSort(100);
        objectTypeDto.setParentId("0");
        objectTypeDto.setHasChild(false);
        objectTypeDto.setObjectId("1");
        objectTypeDto.setHasRight(rightDao.hasObjRight(roleId, getObjectType()));
        return Collections.singletonList(objectTypeDto);
    }

    protected abstract String getName();

    protected abstract String getObjectType();
}
