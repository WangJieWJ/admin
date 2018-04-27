/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2017-09-28 20:31:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sa_sys_group
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_group`;
CREATE TABLE `sa_sys_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '组织名称',
  `desc` varchar(100) DEFAULT NULL COMMENT '描述',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父ID',
  `sort` int(11) NOT NULL DEFAULT '100' COMMENT '顺序值,越小越靠前',
  `level` int(2) NOT NULL COMMENT '树当前处于第几级',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `group_parentId_index` (`parentId`),
  KEY `group_sort_index` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统默认组织表';

-- ----------------------------
-- Records of sa_sys_group
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_group_user
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_group_user`;
CREATE TABLE `sa_sys_group_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupId` int(11) NOT NULL COMMENT '组织id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `groupId_userId_index` (`groupId`,`userId`),
  KEY `user_groupId_index` (`groupId`),
  KEY `user_userId_index` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织的用户';

-- ----------------------------
-- Records of sa_sys_group_user
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_menu`;
CREATE TABLE `sa_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `url` varchar(255) DEFAULT NULL COMMENT '资源url',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `parentId` int(11) DEFAULT NULL COMMENT '父ID',
  `sort` int(11) NOT NULL DEFAULT '100' COMMENT '顺序值,越小越靠前',
  `level` int(2) NOT NULL COMMENT '树当前处于第几级',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `menu_parentId_index` (`parentId`),
  KEY `menu_sort_index` (`sort`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of sa_sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_object_role
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_object_role`;
CREATE TABLE `sa_sys_object_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `objectType` varchar(20) NOT NULL COMMENT '对象类型',
  `objectId` varchar(50) NOT NULL COMMENT '对象ID',
  `initObjectId` varchar(50) NOT NULL COMMENT '初始化对象ID，最子节点的id',
  `visible` int(1) NOT NULL COMMENT '是否可见（1：可见；2：不可见）',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `roleId_objectType_objectId_initObjectId_index` (`roleId`,`objectType`,`objectId`,`initObjectId`),
  KEY `o_r_roleId_index` (`roleId`),
  KEY `o_r_objectId_index` (`objectId`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='角色和对象关系表';

-- ----------------------------
-- Records of sa_sys_object_role
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_object_type
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_object_type`;
CREATE TABLE `sa_sys_object_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `objectType` varchar(50) NOT NULL COMMENT '英文名称，全局唯一',
  `pojoClassName` varchar(100) DEFAULT NULL COMMENT '对应的实体类',
  `queryServiceBeanName` varchar(100) DEFAULT NULL COMMENT '获取该类型数据的beanName',
  `parentId` int(11) DEFAULT NULL COMMENT '父ID',
  `sort` int(11) NOT NULL DEFAULT '100' COMMENT '顺序值,越小越靠前',
  `level` int(2) NOT NULL COMMENT '树当前处于第几级',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `appName` varchar(100) DEFAULT NULL COMMENT '微服务应用名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `objectType_index` (`objectType`) USING BTREE,
  KEY `type_parentId_index` (`parentId`),
  KEY `type_sort_index` (`sort`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='用于权限授权的对象类型';

-- ----------------------------
-- Records of sa_sys_object_type
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_permission_category
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_permission_category`;
CREATE TABLE `sa_sys_permission_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `enName` varchar(20) NOT NULL COMMENT '英文唯一标识,同分类下唯一',
  `objectType` varchar(20) NOT NULL COMMENT '权限分类所属的对象类型',
  `parentId` int(11) DEFAULT NULL COMMENT '父ID',
  `sort` int(11) NOT NULL DEFAULT '100' COMMENT '顺序值,越小越靠前',
  `level` int(2) NOT NULL COMMENT '树当前处于第几级',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `enName_parentId_index` (`enName`,`parentId`) USING BTREE,
  KEY `cat_parentId_index` (`parentId`),
  KEY `cat_sort_index` (`sort`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COMMENT='原子权限分类';

-- ----------------------------
-- Records of sa_sys_permission_category
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_permission`;
CREATE TABLE `sa_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `enName` varchar(20) NOT NULL COMMENT '英文名称，同分类下唯一',
  `desc` varchar(100) DEFAULT NULL COMMENT '描述',
  `index` int(11) NOT NULL COMMENT '权限的权限位，0开始',
  `categoryId` int(11) NOT NULL COMMENT '权限所属的分类ID',
  `objectType` varchar(20) NOT NULL COMMENT '权限所属的对象类型',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `per_enName_categoryId_index` (`enName`,`categoryId`),
  UNIQUE KEY `per_index_index` (`index`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8 COMMENT='原子权限定义';

-- ----------------------------
-- Records of sa_sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_right
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_right`;
CREATE TABLE `sa_sys_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL COMMENT '【人】角色ID',
  `objectType` varchar(20) NOT NULL COMMENT '对象类型',
  `objectId` varchar(50) NOT NULL COMMENT '【对象】对象ID',
  `rightValue` varchar(3000) DEFAULT NULL COMMENT '【操作】对应的原子权限',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_object_index` (`roleId`,`objectType`,`objectId`),
  KEY `right_roleId_index` (`roleId`),
  KEY `right_objectId_index` (`objectId`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='权限记录';

-- ----------------------------
-- Records of sa_sys_right
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_role`;
CREATE TABLE `sa_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `enName` varchar(50) NOT NULL COMMENT '英文名称，全局唯一',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `groupId` int(11) DEFAULT NULL COMMENT '所属组织id，groupId为0或null则是系统级角色',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_enName_index` (`enName`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sa_sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_role_user`;
CREATE TABLE `sa_sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `roleId_userId_index` (`roleId`,`userId`),
  KEY `r_u_userId_index` (`userId`),
  KEY `r_u_roleId_index` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='角色的用户';

-- ----------------------------
-- Records of sa_sys_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for sa_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sa_sys_user`;
CREATE TABLE `sa_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT '盐',
  `theme` varchar(50) DEFAULT NULL COMMENT '用户主题',
  `trueName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `enName` varchar(50) DEFAULT NULL COMMENT '英文名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `remark` varchar(250) DEFAULT NULL COMMENT '备注',
  `gender` int(1) DEFAULT NULL COMMENT '性别,1男2女',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  `pic` varchar(400) DEFAULT NULL COMMENT '头像地址',
  `status` int(1) DEFAULT '1' COMMENT '状态,1为正常 2为已停用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_userName_index` (`userName`),
  KEY `user_status_index` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统默认用户';

-- ----------------------------
-- Records of sa_sys_user
-- ----------------------------
