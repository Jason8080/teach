/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80016
Source Host           : 127.0.0.1:3306
Source Database       : mybatisdb

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-09-02 17:09:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) DEFAULT '1' COMMENT '用户编号',
  `money` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1', '10.00');
INSERT INTO `account` VALUES ('2', '10', '0.00');
INSERT INTO `account` VALUES ('3', '24', '99.00');
