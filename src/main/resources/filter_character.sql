/*
Navicat MySQL Data Transfer

Source Server         : dev_platform
Source Server Version : 50723
Source Host           : 192.168.8.21:3306
Source Database       : gp-portal-center

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2021-11-26 14:08:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for filter_character
-- ----------------------------
DROP TABLE IF EXISTS `filter_character`;
CREATE TABLE `filter_character` (
  `id` int(11) NOT NULL,
  `filter_character` varchar(64) DEFAULT NULL COMMENT '过滤字符',
  `remark` text COMMENT '备注',
  `rule_id` int(11) NOT NULL COMMENT '过滤规则关联字段',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `LAST_MODIFY_DATE` datetime DEFAULT NULL COMMENT '最后修改时间',
  `LAST_MODIFY_USER` varchar(50) DEFAULT NULL COMMENT '最后修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过滤字符表';

-- ----------------------------
-- Records of filter_character
-- ----------------------------
INSERT INTO `filter_character` VALUES ('1', '<script>', 'js脚本', '1', null, null, null, null);
INSERT INTO `filter_character` VALUES ('2', '</script>', 'js脚本', '1', '2021-10-24 17:39:27', null, '2021-10-24 17:39:27', null);
INSERT INTO `filter_character` VALUES ('3', '</script>', 'js脚本', '1', '2021-10-24 18:12:48', null, '2021-10-24 18:12:48', null);
INSERT INTO `filter_character` VALUES ('4', '<script(.*?)>', 'js脚本', '1', '2021-10-24 18:13:59', null, '2021-10-24 18:13:59', null);
INSERT INTO `filter_character` VALUES ('5', 'on(click|error|load|firm)', 'js脚本', '1', '2021-10-24 18:14:12', null, '2021-10-24 18:14:12', null);

-- ----------------------------
-- Table structure for filter_rule
-- ----------------------------
DROP TABLE IF EXISTS `filter_rule`;
CREATE TABLE `filter_rule` (
  `id` int(11) NOT NULL,
  `rule_code` varchar(64) DEFAULT NULL COMMENT '过滤规则编码',
  `rule_name` varchar(64) DEFAULT NULL COMMENT '过滤规则名称',
  `remark` text COMMENT '备注',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `LAST_MODIFY_DATE` datetime DEFAULT NULL COMMENT '最后修改时间',
  `LAST_MODIFY_USER` varchar(50) DEFAULT NULL COMMENT '最后修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过滤规则表';

-- ----------------------------
-- Records of filter_rule
-- ----------------------------
INSERT INTO `filter_rule` VALUES ('1', 'announcement', '公告', null, null, null, null, null);

-- ----------------------------
-- Table structure for filter_user_path
-- ----------------------------
DROP TABLE IF EXISTS `filter_user_path`;
CREATE TABLE `filter_user_path` (
  `id` int(11) NOT NULL,
  `use_path` varchar(64) DEFAULT NULL COMMENT '过滤路径',
  `remark` text COMMENT '备注',
  `rule_id` int(11) NOT NULL COMMENT '过滤规则关联字段',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `LAST_MODIFY_DATE` datetime DEFAULT NULL COMMENT '最后修改时间',
  `LAST_MODIFY_USER` varchar(50) DEFAULT NULL COMMENT '最后修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过滤路径表';

-- ----------------------------
-- Records of filter_user_path
-- ----------------------------
INSERT INTO `filter_user_path` VALUES ('1', '/admin/cms/announcement.do', '发送公告', '1', null, null, null, null);
