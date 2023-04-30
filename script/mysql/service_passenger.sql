/*
 Navicat Premium Data Transfer

 Source Server         : 101.200.91.104
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : 101.200.91.104:3306
 Source Schema         : service_passenger

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 30/04/2023 02:12:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for passenger_user
-- ----------------------------
DROP TABLE IF EXISTS `passenger_user`;
CREATE TABLE `passenger_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `passenger_phone` varchar(16) DEFAULT NULL,
  `passenger_name` varchar(16) DEFAULT NULL,
  `passenger_gender` tinyint(1) DEFAULT NULL COMMENT '0：未知，1：男，2：女',
  `state` tinyint(1) DEFAULT NULL COMMENT '0：有效，1：失效',
  `profile_photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像图片地址的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1584355669008773124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of passenger_user
-- ----------------------------
BEGIN;
INSERT INTO `passenger_user` (`id`, `gmt_create`, `gmt_modified`, `passenger_phone`, `passenger_name`, `passenger_gender`, `state`, `profile_photo`) VALUES (1584355669008773123, '2023-04-21 16:21:15', '2023-04-21 16:21:15', '17630905198', '张三', 0, 1, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
