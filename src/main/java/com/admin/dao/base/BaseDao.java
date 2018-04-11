package com.admin.dao.base;

import com.admin.pojo.base.BasePojo;
import com.admin.pojo.base.CreateBasePojo;
import com.admin.pojo.base.UpdateBasePojo;
import com.season.common.ArrayKit;
import com.season.common.ClassKit;
import com.season.core.Page;
import com.season.orm.dao.ISeasonDao;
import com.season.orm.dao.dialect.AbstractDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/2/22 10:41
 */
public class BaseDao<T> implements IDao<T> {

    /**
     * 主库
     */
    @Autowired
    @Qualifier("master")
    public ISeasonDao masterSeasonDao;

    /**
     * 主库
     */
    @Autowired
    @Qualifier("slaver")
    public ISeasonDao slaverSeasonDao;

    private Class<T> entityClass;

    @Autowired
    public BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    @Override
    public T save(T t, ISeasonDao... seasonDao) {
        if (t == null) {
            return null;
        }
        if (t instanceof UpdateBasePojo) {
            ((UpdateBasePojo) t).preInsert();
        } else if (t instanceof CreateBasePojo) {
            ((CreateBasePojo) t).preInsert();
        }
        if (seasonDao != null && seasonDao.length > 0) {
            t = seasonDao[0].save(t);
        } else {
            t = masterSeasonDao.save(t);
        }
        return t;
    }

    @Override
    public int update(T t, ISeasonDao seasonDao, String... columns) {
        if (t == null) {
            return 0;
        }
        if (t instanceof UpdateBasePojo) {
            ((UpdateBasePojo) t).preUpdate();
            if (columns != null && columns.length != 0) {
                columns = ArrayKit.merge(columns, new String[]{"lastUpdateTime", "lastUpdateUserId"});
            }
        }
        if (seasonDao == null) {
            return masterSeasonDao.update(t, columns);
        }
        return seasonDao.update(t, columns);
    }

    @Override
    public int delete(T t, ISeasonDao... seasonDao) {
        if (t == null) {
            return 0;
        }
        if (seasonDao != null && seasonDao.length > 0) {
            return seasonDao[0].delete(t);
        } else {
            return masterSeasonDao.delete(t);
        }
    }

    @Override
    public int deleteById(Long id, ISeasonDao... seasonDao) {
        if (id == null) {
            return 0;
        }
        T t = ClassKit.newInstance(entityClass);
        if (t instanceof BasePojo) {
            ((BasePojo) t).setId(id);
            return delete(t, seasonDao);
        }
        return 0;
    }


    @Override
    public Page<T> findPage(int pageNo, int pageSize, String sql, Map<String, Object> param, ISeasonDao... seasonDao) {
        if (seasonDao != null && seasonDao.length > 0) {
            return seasonDao[0].findPage(entityClass, pageNo, pageSize, param, sql);
        } else {
            return slaverSeasonDao.findPage(entityClass, pageNo, pageSize, param, sql);
        }
    }

    @Override
    public List<T> findByColumn(String whereColumn, Object columnValue, ISeasonDao... seasonDao) {
        if (seasonDao != null && seasonDao.length > 0) {
            return seasonDao[0].findByColumns(entityClass, new String[]{whereColumn}, columnValue);
        }
        return slaverSeasonDao.findByColumns(entityClass, new String[]{whereColumn}, columnValue);
    }

    @Override
    public T findById(Long id, ISeasonDao... seasonDao) {
        if (id == null || id < 0) {
            return null;
        }
        String[] pks = AbstractDialect.getTable(entityClass).getPrimaryKey();
        List<T> resultList;
        if (seasonDao != null && seasonDao.length > 0) {
            resultList = seasonDao[0].findByColumns(entityClass, new String[]{"*"}, pks, id);
        } else {
            resultList = slaverSeasonDao.findByColumns(entityClass, new String[]{"*"}, pks, id);
        }
        return !resultList.isEmpty() ? resultList.get(0) : null;
    }

    @Override
    public List<T> findAll(ISeasonDao... seasonDao) {
        if (seasonDao != null && seasonDao.length > 0) {
            return seasonDao[0].findByColumns(entityClass, null);
        }
        return slaverSeasonDao.findByColumns(entityClass, null);
    }
}
