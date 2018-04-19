package com.admin.web.api;

import com.season.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Title:
 * Description: 系统管理Api
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/17 15:34
 */
@Api(tags = "authApi")
public interface AdminAuthApi {

    @ApiOperation(value = "新增角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "角色名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "enName", value = "角色英文名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "角色备注", dataType = "String", paramType = "query"),
    })
    Result addRole(String name, String enName, String remark);

    @ApiOperation(value = "1、显示所有角色列表 / 2、通过角色ID来查看角色详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID,可选参数", dataType = "Long", paramType = "query"),
    })
    Result queryAllRole(Long roleId);

    @ApiOperation(value = "删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
    })
    Result deleteRole(Long roleId);

    @ApiOperation(value = "修改角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "角色名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "角色备注", dataType = "String", paramType = "query"),
    })
    Result updateRole(Long roleId, String name, String remark);

    @ApiOperation(value = "查看该角色下的所有用户(角色管理界面使用)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fuzzyMatchStr", value = "模糊匹配字符串", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "当前页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query"),
    })
    Result queryUserByRoleId(String fuzzyMatchStr, Long roleId, Integer pageNo, Integer pageSize);

    @ApiOperation(value = "模糊查询用户(角色管理界面使用,添加用户)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fuzzyMatchStr", value = "模糊匹配字符串", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "当前页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query"),
    })
    Result queryUserFuzzyMatch(String fuzzyMatchStr, Long roleId, Integer pageNo, Integer pageSize);

    @ApiOperation(value = "角色中添加用户(给用户赋予角色)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "userIds", value = "用户ID,多个通过逗号隔开", dataType = "String", paramType = "query"),
    })
    Result addRoleUser(Long roleId, String userIds);

    @ApiOperation(value = "从角色中移除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "userIds", value = "用户ID,多个通过逗号隔开", dataType = "String", paramType = "query"),
    })
    Result removeUser(Long roleId, String userIds);


    @ApiOperation(value = "查看所有的对象类型")
    Result queryRightList();

    @ApiOperation(value = "查询对象类型的所有权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "objectType", value = "对象类型", dataType = "String", paramType = "query"),
    })
    Result queryRight(Long roleId, String objectType);

    @ApiOperation(value = "保存权限,角色授权")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "objectType", value = "对象类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "permissionIds", value = "权限id集合（注意别传成permissionCategoryId了）,多个逗号隔开", dataType = "String", paramType = "query")
    })
    Result saveRight(Long roleId, String objectType, String permissionIds);

    @ApiOperation(value = "查询用户列表(用户管理页面),模糊匹配字符串可不传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fuzzyMatchStr", value = "模糊匹配字符串,用户工号、用户名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "当前页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query"),
    })
    Result queryAllUser(String fuzzyMatchStr, Integer pageNo, Integer pageSize);

    @ApiOperation(value = "查看用户的用户来源标签")
    Result getUserFromTag();

    @ApiOperation(value = "查询当前用户可以查看的菜单")
    Result queryVisibleMenus();

    @ApiOperation(value = "登录成功后调用，获取菜单、权限key、用户个人信息")
    Result selfInformation();

    @ApiOperation(value = "启用用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "Long", paramType = "query"),
    })
    Result enableUser(Long userId);

    @ApiOperation(value = "停用用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "Long", paramType = "query"),
    })
    Result disableUser(Long userId);

    @ApiOperation(value = "用户登录,登录成功后 返回菜单、权限key、用户个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名,用户工号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "passWord", value = "密码", dataType = "String", paramType = "query"),
    })
    Result login(String userName, String passWord);

    @ApiOperation(value = "退出登录")
    Result logout();

}
