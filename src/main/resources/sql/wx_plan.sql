/*
Navicat MySQL Data Transfer

Source Server         : fieldmeta
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : wx_plan

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-02-25 18:00:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for habit_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `habit_tags_relation`;
CREATE TABLE `habit_tags_relation` (
  `ht_id` varchar(100) NOT NULL COMMENT 'id',
  `CREATED_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(100) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `habit_id` varchar(100) DEFAULT NULL COMMENT '事件ID',
  `tags_id` varchar(100) DEFAULT NULL COMMENT '标签ID',
  PRIMARY KEY (`ht_id`),
  KEY `habit_id` (`habit_id`),
  KEY `tags_id` (`tags_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='habit_tags_relation';

-- ----------------------------
-- Records of habit_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for pdman_db_version
-- ----------------------------
DROP TABLE IF EXISTS `pdman_db_version`;
CREATE TABLE `pdman_db_version` (
  `DB_VERSION` varchar(256) DEFAULT NULL,
  `VERSION_DESC` varchar(1024) DEFAULT NULL,
  `CREATED_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdman_db_version
-- ----------------------------
INSERT INTO `pdman_db_version` VALUES ('v1.0', '初始化数据库', '2019-01-03 15:15:23');

-- ----------------------------
-- Table structure for plan_habit
-- ----------------------------
DROP TABLE IF EXISTS `plan_habit`;
CREATE TABLE `plan_habit` (
  `habit_id` varchar(100) NOT NULL COMMENT '习惯ID 习惯ID',
  `CREATED_USER` varchar(100) DEFAULT NULL COMMENT '创建人 创建人',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `habit_desc` varchar(100) DEFAULT NULL COMMENT '习惯描述 习惯描述',
  `habit_Importance` varchar(100) DEFAULT NULL COMMENT '重要程度 重要程度',
  `habit_term` varchar(100) DEFAULT NULL COMMENT '期限 期限',
  `habit_name` varchar(100) DEFAULT NULL COMMENT '习惯名称 习惯名称',
  `habit_staus` varchar(100) DEFAULT '0' COMMENT '状态 状态',
  PRIMARY KEY (`habit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件表';

-- ----------------------------
-- Records of plan_habit
-- ----------------------------
INSERT INTO `plan_habit` VALUES ('0e2e2dbc-8a20-430e-adf6-c3aaa823857c', null, '2019-01-04 14:34:35', '2019-01-04 14:34:35', null, null, null, '计划三', '0');
INSERT INTO `plan_habit` VALUES ('1', null, null, null, null, null, null, null, null);
INSERT INTO `plan_habit` VALUES ('13a09046-c0d7-43cc-93df-b5ae9e5be4f7', null, '2019-01-04 14:21:19', '2019-01-04 14:21:19', null, null, null, '计划二', '0');
INSERT INTO `plan_habit` VALUES ('1df6de36-c180-40c9-b03c-bf854a801e8f', null, '2019-01-04 14:20:21', '2019-01-04 14:20:21', null, null, null, '计划一', '0');
INSERT INTO `plan_habit` VALUES ('2', null, '2019-01-03 15:40:20', null, null, null, null, null, null);
INSERT INTO `plan_habit` VALUES ('208bcce7-5f70-429a-8c4a-93ea0b738d54', null, '2019-01-04 14:21:18', '2019-01-04 14:21:18', null, null, null, '计划二', '0');
INSERT INTO `plan_habit` VALUES ('3', null, '2019-01-03 15:45:18', '2019-01-03 15:45:18', null, null, null, null, '0');
INSERT INTO `plan_habit` VALUES ('325a4df4-d555-477a-b898-c531c4476bde', null, '2019-01-04 14:33:00', '2019-01-04 14:33:00', null, null, null, '计划三', '0');
INSERT INTO `plan_habit` VALUES ('3ee5611e-512a-4100-b26d-3bf5660e9335', null, '2019-01-04 14:39:12', '2019-01-04 14:39:12', null, null, null, '计划4', '0');
INSERT INTO `plan_habit` VALUES ('5a9a12cc-935c-4b62-aa7b-cc925e62b1b5', null, '2019-01-04 14:34:20', '2019-01-04 14:34:20', null, null, null, '计划三', '0');
INSERT INTO `plan_habit` VALUES ('5dc7a922-9d28-4451-9bf7-3e2c47e9fda2', null, '2019-01-07 14:35:40', '2019-01-07 14:35:40', null, null, null, 'TGTG', '0');
INSERT INTO `plan_habit` VALUES ('7671dec4-3a07-4d11-89f9-797163a501c9', null, '2019-01-04 14:20:21', '2019-01-04 14:20:21', null, null, null, '计划一', '0');
INSERT INTO `plan_habit` VALUES ('8265ec87-17e2-4c30-b631-9b3765d16dff', null, '2019-01-07 14:19:49', '2019-01-07 14:19:49', 'xx,xx', '1,1', '1,1', 'A计划,A计划', '0');
INSERT INTO `plan_habit` VALUES ('9ab72d14-1e04-455b-8830-e248d1005a28', null, '2019-01-04 14:40:35', '2019-01-04 14:40:35', null, null, null, '计划五', '0');
INSERT INTO `plan_habit` VALUES ('9babe2e6-334b-413a-ab76-1c3709fd96e6', null, '2019-01-04 14:31:57', '2019-01-04 14:31:57', null, null, null, '计划三', '0');
INSERT INTO `plan_habit` VALUES ('9bd73ccd-3a8c-4d46-9316-ba0ff4cefc17', null, '2019-01-07 14:28:33', '2019-01-07 14:28:33', null, null, null, 'QWE', '0');
INSERT INTO `plan_habit` VALUES ('bed19207-f188-49e4-aa4c-4e4a1f85cd2c', null, '2019-01-07 14:23:47', '2019-01-07 14:23:47', 'dqdw,dqdw', '1,1', '1,1', 'ddd,ddd', '0');
INSERT INTO `plan_habit` VALUES ('d5fd4c36-be21-4bc0-81c4-27be3734911c', null, '2019-01-04 14:39:12', '2019-01-04 14:39:12', null, null, null, '计划4', '0');
INSERT INTO `plan_habit` VALUES ('e25313e3-ca90-4e99-b0dd-1bbf61c2e85f', null, '2019-01-07 14:27:12', '2019-01-07 14:27:12', null, null, null, 'CCCC,CCCC', '0');

-- ----------------------------
-- Table structure for plan_node
-- ----------------------------
DROP TABLE IF EXISTS `plan_node`;
CREATE TABLE `plan_node` (
  `node_id` varchar(100) NOT NULL COMMENT '节点ID 节点ID',
  `CREATED_USER` varchar(100) DEFAULT NULL COMMENT '创建人 创建人',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATED_BY` varchar(100) DEFAULT NULL COMMENT '更新人 更新人',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `habit_id` varchar(100) DEFAULT NULL COMMENT '事件ID 事件ID',
  `node_name` varchar(100) DEFAULT NULL COMMENT '节点名称 节点名称',
  `parent_id` varchar(100) DEFAULT NULL COMMENT '父节点ID 父节点ID',
  `node_status` varchar(100) DEFAULT NULL COMMENT '状态 状态',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan_node
-- ----------------------------
INSERT INTO `plan_node` VALUES ('1', null, null, null, null, null, '首次执行', null, null);
INSERT INTO `plan_node` VALUES ('8e1f68a1-d04a-4c1a-93f4-96d6f2aeae3b', null, '2019-01-04 16:33:44', null, '2019-01-04 16:33:44', '7671dec4-3a07-4d11-89f9-797163a501c9', '下一步', null, null);
INSERT INTO `plan_node` VALUES ('a61baef9-593d-4b54-84bd-8e11cdc658fc', null, '2019-01-04 16:00:38', null, '2019-01-04 16:00:38', '7671dec4-3a07-4d11-89f9-797163a501c9', '初步', null, null);
INSERT INTO `plan_node` VALUES ('e0c377ab-5710-4e31-9bab-f4b5c24bf894', null, '2019-01-07 14:14:30', null, '2019-01-07 14:14:30', '77081be5-741d-464d-a123-3c9b119ee1f2', '1节点', null, null);

-- ----------------------------
-- Table structure for plan_remind
-- ----------------------------
DROP TABLE IF EXISTS `plan_remind`;
CREATE TABLE `plan_remind` (
  `remind_id` varchar(100) NOT NULL COMMENT '提醒ID',
  `CREATED_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATED_BY` varchar(100) DEFAULT NULL COMMENT '更新人',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `remind_status` varchar(100) DEFAULT NULL COMMENT '提醒状态',
  `remind_time` datetime DEFAULT NULL COMMENT '提醒时间',
  `remind_num` int(11) DEFAULT NULL COMMENT '提醒次数',
  `node_id` varchar(100) DEFAULT NULL COMMENT '节点ID',
  `habit_id` varchar(100) DEFAULT NULL COMMENT '事件ID',
  `remind_message` varchar(100) DEFAULT NULL COMMENT '提醒信息',
  PRIMARY KEY (`remind_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件提醒表';

-- ----------------------------
-- Records of plan_remind
-- ----------------------------
INSERT INTO `plan_remind` VALUES ('25743d25-5c20-41ed-b65e-4b2040e51649', null, '2019-01-07 15:06:42', null, '2019-01-07 15:06:42', null, null, '3', 'a61baef9-593d-4b54-84bd-8e11cdc658fc', '7671dec4-3a07-4d11-89f9-797163a501c9', null);
INSERT INTO `plan_remind` VALUES ('7553d984-e888-4714-8343-5f822c70aa3b', null, '2019-01-14 20:54:18', null, '2019-01-14 20:54:18', null, '2019-01-14 20:55:00', null, null, '1', null);
INSERT INTO `plan_remind` VALUES ('ace063af-8879-444f-b238-d4752018580a', null, '2019-01-14 20:51:07', null, '2019-01-14 20:51:07', null, '2019-01-14 20:51:00', null, null, '1', null);

-- ----------------------------
-- Table structure for plan_tags
-- ----------------------------
DROP TABLE IF EXISTS `plan_tags`;
CREATE TABLE `plan_tags` (
  `tags_id` varchar(100) NOT NULL COMMENT '标签ID',
  `CREATED_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATED_BY` varchar(100) DEFAULT NULL COMMENT '更新人',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tags_content` varchar(100) DEFAULT NULL COMMENT '标签内容',
  `tags_color` varchar(100) DEFAULT NULL COMMENT '标签颜色css',
  `tags_status` varchar(100) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`tags_id`),
  KEY `tags_id` (`tags_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of plan_tags
-- ----------------------------

-- ----------------------------
-- Table structure for plan_user
-- ----------------------------
DROP TABLE IF EXISTS `plan_user`;
CREATE TABLE `plan_user` (
  `user_id` varchar(100) NOT NULL COMMENT 'ID ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '昵称 昵称',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `login_id` varchar(100) DEFAULT NULL COMMENT '登录ID 登录ID',
  `pwd` varchar(100) DEFAULT NULL COMMENT '登录密码 登录密码',
  `wallet` varchar(100) DEFAULT NULL COMMENT '钱包 钱包',
  `signature` varchar(100) DEFAULT NULL COMMENT '个人签名 个人签名',
  `level` int(11) DEFAULT NULL COMMENT '等级 等级',
  `open_id` varchar(100) DEFAULT NULL COMMENT 'open_id open_id',
  `wx_id` varchar(100) DEFAULT NULL COMMENT 'wx_id wx_id',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of plan_user
-- ----------------------------
INSERT INTO `plan_user` VALUES ('1', null, '2019-01-03 15:56:38', '2019-01-03 15:56:38', null, null, null, null, null, null, null);
INSERT INTO `plan_user` VALUES ('31381797-0c9e-48f2-8b23-0d9c46c0eb89', 'wqy21', '2019-01-04 14:17:57', '2019-01-04 14:17:57', null, null, null, null, null, null, null);
INSERT INTO `plan_user` VALUES ('96a17816-2ecc-419b-afe1-d6e52ca035d9', '疾风', '2019-01-08 15:47:00', '2019-01-08 15:47:00', 'wind', 'koko', null, '且随疾风前行身后亦须留心', null, null, null);
INSERT INTO `plan_user` VALUES ('cca63138-1296-46d1-9b40-d80577f12fe0', 'wqy', '2019-01-03 17:34:59', '2019-01-03 17:34:59', null, null, null, null, null, null, null);
INSERT INTO `plan_user` VALUES ('d2915347-24ec-4ff4-b2a7-395892063e38', 'wind,wind', '2019-01-04 17:46:42', '2019-01-04 17:46:42', 'wind,wind', 'wind,wind', null, 'wind ,wind ', null, null, null);
