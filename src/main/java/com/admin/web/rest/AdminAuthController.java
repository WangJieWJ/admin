package com.admin.web.rest;

import com.admin.auth.AdminAuth;
import com.admin.web.api.AdminAuthApi;
import com.season.admin.auth.IAuthService;
import com.season.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: admin
 * Author: 王杰
 * Create Time:2018/4/17 15:33
 */
@RestController
@RequestMapping(value = "auth")
public class AdminAuthController implements AdminAuthApi {

    //所有权限判断，调用该接口
    @Autowired
    private IAuthService authService;

    @Override
    @PostMapping(value = "addRole")
    @AdminAuth(requiredAdmin = true)
    public Result addRole(String name, String enName, String remark) {
        return null;
    }

    @Override
    @PostMapping(value = "queryAllRole")
    public Result queryAllRole(Long roleId) {
        return null;
    }

    @Override
    @PostMapping(value = "deleteRole")
    public Result deleteRole(Long roleId) {
        return null;
    }

    @Override
    @PostMapping(value = "updateRole")
    public Result updateRole(Long roleId, String name, String remark) {
        return null;
    }

    @Override
    @PostMapping(value = "queryUserByRoleId")
    public Result queryUserByRoleId(String fuzzyMatchStr, Long roleId, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    @PostMapping(value = "queryUserFuzzyMatch")
    public Result queryUserFuzzyMatch(String fuzzyMatchStr, Long roleId, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    @PostMapping(value = "addRoleUser")
    public Result addRoleUser(Long roleId, String userIds) {
        return null;
    }

    @Override
    @PostMapping(value = "removeUser")
    public Result removeUser(Long roleId, String userIds) {
        return null;
    }

    @Override
    @PostMapping(value = "queryRightList")
    public Result queryRightList() {
        return null;
    }

    @Override
    @PostMapping(value = "queryRight")
    public Result queryRight(Long roleId, String objectType) {
        return null;
    }

    @Override
    @PostMapping(value = "saveRight")
    public Result saveRight(Long roleId, String objectType, String permissionIds) {
        return null;
    }

    @Override
    @PostMapping(value = "queryAllUser")
    public Result queryAllUser(String fuzzyMatchStr, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    @PostMapping(value = "queryVisibleMenus")
    public Result queryVisibleMenus() {
        return null;
    }

    @Override
    @PostMapping(value = "enableUser")
    public Result enableUser(Long userId) {
        return null;
    }

    @Override
    @PostMapping(value = "disableUser")
    public Result disableUser(Long userId) {
        return null;
    }

    @Override
    @PostMapping(value = "login")
    public Result login(String userName, String passWord) {
        return null;
    }

    @Override
    @PostMapping(value = "logout")
    public Result logout() {
        return null;
    }
}
