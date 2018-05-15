/*
Navicat MySQL Data Transfer

Source Server         : localhost_mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-14 17:54:07
*/
DROP DATABASE IF EXISTS `admin`;
CREATE DATABASE `admin`;
USE `admin`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_login`
-- ----------------------------
DROP TABLE IF EXISTS `sys_login`;
CREATE TABLE `sys_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_login
-- ----------------------------
INSERT INTO `sys_login` VALUES ('1', '1', '2017-09-12 14:01:18');
INSERT INTO `sys_login` VALUES ('2', '1', '2017-09-12 14:03:22');
INSERT INTO `sys_login` VALUES ('3', '1', '2017-09-12 15:21:37');
INSERT INTO `sys_login` VALUES ('4', '1', '2017-09-12 15:23:01');
INSERT INTO `sys_login` VALUES ('5', '1', '2017-09-12 16:18:42');
INSERT INTO `sys_login` VALUES ('6', '1', '2017-09-12 16:30:12');
INSERT INTO `sys_login` VALUES ('7', '1', '2017-09-12 16:32:36');
INSERT INTO `sys_login` VALUES ('8', '1', '2017-09-12 16:37:04');
INSERT INTO `sys_login` VALUES ('9', '1', '2017-09-12 16:42:10');
INSERT INTO `sys_login` VALUES ('10', '1', '2017-09-12 16:49:19');
INSERT INTO `sys_login` VALUES ('11', '1', '2017-09-12 16:52:35');
INSERT INTO `sys_login` VALUES ('12', '1', '2017-09-12 16:53:39');
INSERT INTO `sys_login` VALUES ('13', '1', '2017-09-12 16:57:32');
INSERT INTO `sys_login` VALUES ('14', '1', '2017-09-12 16:59:54');
INSERT INTO `sys_login` VALUES ('15', '1', '2017-09-12 17:11:51');
INSERT INTO `sys_login` VALUES ('16', '1', '2017-09-12 17:14:30');
INSERT INTO `sys_login` VALUES ('17', '1', '2017-09-12 17:21:53');
INSERT INTO `sys_login` VALUES ('18', '1', '2017-09-12 17:24:29');
INSERT INTO `sys_login` VALUES ('19', '1', '2017-09-12 17:26:26');
INSERT INTO `sys_login` VALUES ('20', '1', '2017-09-12 17:28:06');
INSERT INTO `sys_login` VALUES ('21', '1', '2017-09-12 17:30:28');
INSERT INTO `sys_login` VALUES ('22', '1', '2017-09-12 17:32:43');
INSERT INTO `sys_login` VALUES ('23', '1', '2017-09-12 17:34:18');
INSERT INTO `sys_login` VALUES ('24', '1', '2017-09-12 17:35:28');
INSERT INTO `sys_login` VALUES ('25', '1', '2017-09-12 17:36:40');
INSERT INTO `sys_login` VALUES ('26', '1', '2017-09-12 17:38:40');
INSERT INTO `sys_login` VALUES ('27', '1', '2017-09-12 17:40:51');
INSERT INTO `sys_login` VALUES ('28', '1', '2017-09-12 18:03:00');
INSERT INTO `sys_login` VALUES ('29', '1', '2017-09-12 18:04:27');
INSERT INTO `sys_login` VALUES ('30', '1', '2017-09-12 18:06:45');
INSERT INTO `sys_login` VALUES ('31', '1', '2017-09-12 18:08:10');
INSERT INTO `sys_login` VALUES ('32', '1', '2017-09-12 18:08:52');
INSERT INTO `sys_login` VALUES ('33', '1', '2017-09-13 09:36:28');
INSERT INTO `sys_login` VALUES ('34', '1', '2017-09-13 10:48:35');
INSERT INTO `sys_login` VALUES ('35', '1', '2017-09-13 14:22:42');
INSERT INTO `sys_login` VALUES ('36', '1', '2017-09-13 14:33:55');
INSERT INTO `sys_login` VALUES ('37', '1', '2017-09-13 14:44:09');
INSERT INTO `sys_login` VALUES ('38', '1', '2017-09-13 14:48:59');
INSERT INTO `sys_login` VALUES ('39', '1', '2017-09-13 14:51:34');
INSERT INTO `sys_login` VALUES ('40', '1', '2017-09-13 15:44:01');
INSERT INTO `sys_login` VALUES ('41', '1', '2017-09-13 16:20:27');
INSERT INTO `sys_login` VALUES ('42', '1', '2017-09-13 16:54:21');
INSERT INTO `sys_login` VALUES ('43', '1', '2017-09-13 17:18:29');
INSERT INTO `sys_login` VALUES ('44', '1', '2017-09-13 17:24:04');
INSERT INTO `sys_login` VALUES ('45', '1', '2017-09-13 17:52:36');
INSERT INTO `sys_login` VALUES ('46', '1', '2017-09-13 17:53:24');
INSERT INTO `sys_login` VALUES ('47', '1', '2017-09-13 17:55:38');
INSERT INTO `sys_login` VALUES ('48', '1', '2017-09-13 18:04:03');
INSERT INTO `sys_login` VALUES ('49', '1', '2017-09-13 18:05:19');
INSERT INTO `sys_login` VALUES ('50', '1', '2017-09-14 09:55:05');
INSERT INTO `sys_login` VALUES ('51', '1', '2017-09-14 11:32:29');
INSERT INTO `sys_login` VALUES ('52', '2', '2017-09-14 13:51:45');
INSERT INTO `sys_login` VALUES ('53', '1', '2017-09-14 13:52:20');
INSERT INTO `sys_login` VALUES ('54', '3', '2017-09-14 13:58:08');
INSERT INTO `sys_login` VALUES ('55', '1', '2017-09-14 13:58:21');
INSERT INTO `sys_login` VALUES ('56', '1', '2017-09-14 14:11:56');
INSERT INTO `sys_login` VALUES ('57', '2', '2017-09-14 14:12:54');
INSERT INTO `sys_login` VALUES ('58', '1', '2017-09-14 14:14:41');
INSERT INTO `sys_login` VALUES ('59', '1', '2017-09-14 14:20:34');
INSERT INTO `sys_login` VALUES ('60', '1', '2017-09-14 14:21:57');
INSERT INTO `sys_login` VALUES ('61', '1', '2017-09-14 14:23:02');
INSERT INTO `sys_login` VALUES ('62', '1', '2017-09-14 14:28:06');
INSERT INTO `sys_login` VALUES ('63', '3', '2017-09-14 14:28:45');
INSERT INTO `sys_login` VALUES ('64', '2', '2017-09-14 14:29:51');
INSERT INTO `sys_login` VALUES ('65', '3', '2017-09-14 14:30:14');
INSERT INTO `sys_login` VALUES ('66', '1', '2017-09-14 15:44:24');
INSERT INTO `sys_login` VALUES ('67', '1', '2017-09-14 15:45:34');
INSERT INTO `sys_login` VALUES ('68', '1', '2017-09-14 17:15:09');
INSERT INTO `sys_login` VALUES ('69', '12', '2017-09-14 17:17:40');
INSERT INTO `sys_login` VALUES ('70', '1', '2017-09-14 17:26:48');
INSERT INTO `sys_login` VALUES ('71', '1', '2017-09-14 17:34:04');
INSERT INTO `sys_login` VALUES ('72', '1', '2017-09-14 17:52:57');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_url` varchar(50) DEFAULT '#',
  `menu_type` enum('2','1') DEFAULT '2' COMMENT '1 -- 系统菜单，2 -- 业务菜单',
  `menu_icon` varchar(50) DEFAULT '#',
  `sort_num` int(11) DEFAULT '1',
  `user_id` int(11) DEFAULT '1' COMMENT '创建这个菜单的用户id',
  `is_del` int(11) DEFAULT '0' COMMENT '1-- 删除状态，0 -- 正常',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', '#', '1', 'fa fa-gears', '1', '1', '0', '2017-09-08 16:15:24', '2017-09-07 14:52:41');
INSERT INTO `sys_menu` VALUES ('2', '1', '菜单管理', 'menu/list', '1', '#', '1', '1', '0', '2017-09-12 11:28:09', '2017-09-07 14:52:41');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'role/list', '1', null, '2', '1', '0', '2017-09-07 17:58:52', '2017-09-07 14:52:41');
INSERT INTO `sys_menu` VALUES ('4', '1', '用户管理', 'user/list', '1', '', '3', '1', '0', '2017-09-12 09:44:48', '2017-09-07 14:52:41');
INSERT INTO `sys_menu` VALUES ('5', '0', '业务菜单', '#', '2', 'fa fa-tasks', '2', '1', '0', '2017-09-07 14:53:33', '2017-09-07 14:52:41');
INSERT INTO `sys_menu` VALUES ('6', '5', '随便添加的子菜单', 'page/t4', '2', '', '1', '1', '0', '2017-09-14 15:45:28', '2017-09-07 14:52:41');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_desc` varchar(255) DEFAULT NULL,
  `rights` varchar(255) DEFAULT '0' COMMENT '最大权限的值',
  `add_qx` varchar(255) DEFAULT '0',
  `del_qx` varchar(255) DEFAULT '0',
  `edit_qx` varchar(255) DEFAULT '0',
  `query_qx` varchar(255) DEFAULT '0',
  `user_id` varchar(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '管理员权限', '1267650600228229401496703205375', '1', '1', '126', '126', '1', '2017-09-12 15:38:56');
INSERT INTO `sys_role` VALUES ('2', 'tyro', '随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的', '94', '2', '1', '4', '126', '1', '2017-09-12 15:44:06');
INSERT INTO `sys_role` VALUES ('3', 'test', '是测试角色这个是测试角色这个是测试角色这个是测试角色这个是测试角色', '382', '382', '382', '382', '126', '1', '2017-09-12 15:39:28');
INSERT INTO `sys_role` VALUES ('4', '查看', '可以查看所有的东西', '126', '0', '0', '0', '126', '1', '2017-09-14 17:17:17');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `pic_path` varchar(200) DEFAULT '/images/logo.png',
  `status` enum('unlock','lock') DEFAULT 'unlock',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'http://www.lrshuai.top/upload/user/20170612/05976238.png', 'unlock', '2017-08-18 13:57:32');
INSERT INTO `sys_user` VALUES ('2', 'tyro', 'tyro', '481c63e8b904bb8399f1fc1dfdb77cb40842eb6f', '/upload/show/user/82197046.png', 'unlock', '2017-09-12 14:03:39');
INSERT INTO `sys_user` VALUES ('3', 'asdf', 'asdf', '3da541559918a808c2402bba5012f6c60b27661c', '/upload/show/user/85610497.png', 'unlock', '2017-09-13 14:49:10');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', '2017-08-18 14:45:43');
INSERT INTO `sys_user_role` VALUES ('2', '2', '3', '2017-09-08 17:12:58');
INSERT INTO `sys_user_role` VALUES ('13', '3', '3', '2017-09-14 14:30:02');
