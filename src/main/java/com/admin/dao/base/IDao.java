package com.admin.dao.base;

import com.season.core.Page;
import com.season.orm.dao.ISeasonDao;

import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/2/22 10:38
 */
public interface IDao<T> {

    /**
     * 保存pojo
     *
     * @param t 实例
     * @return 保存后的对象, 带主键
     */
    T save(T t, ISeasonDao... seasonDao);

    /**
     * 更新pojo
     *
     * @param t             实例
     * @param updateColumns 要更新的列,如果不指定,更新所有列
     * @return 更新数量
     */
    int update(T t, ISeasonDao seasonDao, String... updateColumns);

    /**
     * 删除pojo
     *
     * @param t 实例,主键必须有值,否则抛出运行异常
     * @return 删除数量
     */
    int delete(T t, ISeasonDao... seasonDao);

    /**
     * 根据主键删除pojo
     *
     * @param id 主键id
     * @return 删除的数量
     */
    int deleteById(Long id, ISeasonDao... seasonDao);

    /**
     * 分页查询查询
     *
     * @param pageNo   当前第几页
     * @param pageSize 每页大小
     * @param sql      sql语句
     * @param param    参数对象
     * @return
     */
    Page<T> findPage(int pageNo, int pageSize, String sql, Map<String, Object> param, ISeasonDao... seasonDao);

    /**
     * 根据某列进行查询
     *
     * @param whereColumn 哪一列,必须是数据库列名而非pojo的字段名
     * @param columnValue 值
     * @return 结果集
     */
    List<T> findByColumn(String whereColumn, Object columnValue, ISeasonDao... seasonDao);

    /**
     * 根据主键查询对象，多主键必须都传
     *
     * @param id 主键
     * @return pojo
     */
    T findById(Long id, ISeasonDao... seasonDao);

    /**
     * 查询pojo的所有数据
     *
     * @return 结果集
     */
    List<T> findAll(ISeasonDao... seasonDao);
}
