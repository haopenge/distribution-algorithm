/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 25/02/2021 15:12:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
                        `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '标记',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
