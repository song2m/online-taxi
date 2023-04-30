/*
 Navicat Premium Data Transfer

 Source Server         : 101.200.91.104
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : 101.200.91.104:3306
 Source Schema         : service_driver

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 30/04/2023 02:11:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `address` char(6) DEFAULT NULL COMMENT '车辆所在城市',
  `vehicle_no` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车辆号牌',
  `plate_color` char(1) DEFAULT NULL COMMENT '车牌颜色（1：蓝色，2：黄色，3：黑色，4：白色，5：绿色，9：其他）',
  `seats` int DEFAULT NULL COMMENT '核定载客位',
  `brand` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车辆厂牌',
  `model` varchar(16) DEFAULT NULL COMMENT '车辆型号',
  `vehicle_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车辆类型',
  `owner_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车辆所有人',
  `vehicle_color` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车辆颜色（1：白色，2：黑色）',
  `engine_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发动机号',
  `vin` varchar(64) DEFAULT NULL,
  `certify_date_a` date DEFAULT NULL COMMENT '车辆注册日期',
  `fue_type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '燃料类型(1：汽油，2：柴油，3：天然气，4：液化气，5：电动，9：其他）',
  `engine_displace` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发动机排量（毫升）',
  `trans_agency` varchar(32) DEFAULT NULL COMMENT '车辆运输证发证机构',
  `trans_area` varchar(32) DEFAULT NULL COMMENT '车辆经验区域',
  `trans_date_start` date DEFAULT NULL COMMENT '车辆运输证有效期起',
  `trans_date_end` date DEFAULT NULL COMMENT '车辆运输证有效期止',
  `certify_date_b` date DEFAULT NULL COMMENT '车辆初次登记日期',
  `fix_state` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车辆的检修状态(0：未检修，1：已检修，2：未知）',
  `next_fix_date` date DEFAULT NULL COMMENT '下次年检时间',
  `check_state` char(2) DEFAULT '' COMMENT '年度审验状态（0：未年审，1：年审合格，2：年审不合格）',
  `fee_print_id` varchar(64) DEFAULT NULL COMMENT '发票打印设备序列号',
  `gps_brand` varchar(32) DEFAULT NULL COMMENT '卫星定位装置品牌',
  `gps_model` varchar(32) DEFAULT NULL COMMENT '卫星型号',
  `gps_install_date` date DEFAULT NULL COMMENT '卫星定位设备安装日期',
  `register_date` date DEFAULT NULL COMMENT '报备日期',
  `commercial_type` int DEFAULT NULL COMMENT '服务类型：1：网络预约出租车，2：巡游出租车，3：私人小客车合乘',
  `fare_type` varchar(16) DEFAULT NULL COMMENT '运价编码 关联计价规则',
  `state` tinyint(1) DEFAULT NULL COMMENT '状态：0:有效，1：失效',
  `tid` varchar(16) DEFAULT NULL COMMENT '终端Id',
  `trid` varchar(16) DEFAULT NULL COMMENT '轨迹ID',
  `trname` varchar(32) DEFAULT NULL COMMENT '轨迹名称',
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1584359540577861634 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of car
-- ----------------------------
BEGIN;
INSERT INTO `car` (`id`, `address`, `vehicle_no`, `plate_color`, `seats`, `brand`, `model`, `vehicle_type`, `owner_name`, `vehicle_color`, `engine_id`, `vin`, `certify_date_a`, `fue_type`, `engine_displace`, `trans_agency`, `trans_area`, `trans_date_start`, `trans_date_end`, `certify_date_b`, `fix_state`, `next_fix_date`, `check_state`, `fee_print_id`, `gps_brand`, `gps_model`, `gps_install_date`, `register_date`, `commercial_type`, `fare_type`, `state`, `tid`, `trid`, `trname`, `gmt_create`, `gmt_modified`) VALUES (1584359540577861633, '110000', '京N83555', '1', 5, '大众', '迈腾', 'proident', '燃油车', '1', '18adsadf', 'vinvin', '2020-01-08', '1', '2.4t', '发证机构', '海淀区北太平街', '2020-01-02', '2020-06-05', '2016-02-09', '1', '2025-01-26', '1', '发票设备序列号', '卫星品牌', '卫星型号', '2024-02-06', '2021-08-31', 1, '110000$1', 1, '590636202', '200', NULL, '2022-10-24 23:00:19', '2022-10-24 23:00:19');
COMMIT;

-- ----------------------------
-- Table structure for driver_car_binding_relationship
-- ----------------------------
DROP TABLE IF EXISTS `driver_car_binding_relationship`;
CREATE TABLE `driver_car_binding_relationship` (
  `id` bigint NOT NULL,
  `driver_id` bigint DEFAULT NULL,
  `car_id` bigint DEFAULT NULL,
  `bind_state` int DEFAULT NULL,
  `binding_time` datetime DEFAULT NULL,
  `un_binding_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of driver_car_binding_relationship
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for driver_user
-- ----------------------------
DROP TABLE IF EXISTS `driver_user`;
CREATE TABLE `driver_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `address` char(6) DEFAULT NULL COMMENT '司机注册地行政区划代码',
  `driver_name` varchar(16) DEFAULT NULL COMMENT '司机姓名',
  `driver_phone` varchar(16) DEFAULT NULL,
  `driver_gender` tinyint DEFAULT NULL COMMENT '1:男，2：女',
  `driver_birthday` date DEFAULT NULL,
  `driver_nation` char(2) DEFAULT NULL COMMENT '驾驶员民族',
  `driver_contact_address` varchar(255) DEFAULT NULL,
  `license_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '机动车驾驶证号',
  `get_driver_license_date` date DEFAULT NULL COMMENT '初次领取驾驶证日期',
  `driver_license_on` date DEFAULT NULL COMMENT '驾驶证有效期起',
  `driver_license_off` date DEFAULT NULL COMMENT '驾驶证有效期止',
  `taxi_driver` tinyint DEFAULT NULL COMMENT '是否巡游出租汽车：1：是，0：否',
  `certificate_no` varchar(255) DEFAULT NULL COMMENT '网络预约出租汽车驾驶员资格证号',
  `network_car_issue_organization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网络预约出租汽车驾驶员发证机构',
  `network_car_issue_date` date DEFAULT NULL COMMENT '资格证发证日期',
  `get_network_car_proof_date` date DEFAULT NULL COMMENT '初次领取资格证日期',
  `network_car_proof_on` date DEFAULT NULL COMMENT '资格证有效起始日期',
  `network_car_proof_off` date DEFAULT NULL COMMENT '资格证有效截止日期',
  `register_date` date DEFAULT NULL COMMENT '报备日期',
  `commercial_type` tinyint DEFAULT NULL COMMENT '服务类型：1：网络预约出租汽车，2：巡游出租汽车，3：私人小客车合乘',
  `contract_company` varchar(255) DEFAULT NULL COMMENT '驾驶员合同（协议）签署公司',
  `contract_on` date DEFAULT NULL COMMENT '合同（协议）有效期起',
  `contract_off` date DEFAULT NULL COMMENT '合同有效期止',
  `state` tinyint DEFAULT NULL COMMENT '司机状态：0：有效，1：失效',
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1651881557213847554 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of driver_user
-- ----------------------------
BEGIN;
INSERT INTO `driver_user` (`id`, `address`, `driver_name`, `driver_phone`, `driver_gender`, `driver_birthday`, `driver_nation`, `driver_contact_address`, `license_id`, `get_driver_license_date`, `driver_license_on`, `driver_license_off`, `taxi_driver`, `certificate_no`, `network_car_issue_organization`, `network_car_issue_date`, `get_network_car_proof_date`, `network_car_proof_on`, `network_car_proof_off`, `register_date`, `commercial_type`, `contract_company`, `contract_on`, `contract_off`, `state`, `gmt_create`, `gmt_modified`) VALUES (1648997879743787009, '440309', '张师傅', '14749776118', 0, '1988-04-27', '', '', '', NULL, NULL, NULL, 0, '', '', NULL, NULL, NULL, NULL, NULL, 0, '', NULL, NULL, 1, '2023-04-28 13:56:38', '2023-04-28 13:56:38');
COMMIT;

-- ----------------------------
-- Table structure for driver_user_work_status
-- ----------------------------
DROP TABLE IF EXISTS `driver_user_work_status`;
CREATE TABLE `driver_user_work_status` (
  `id` bigint NOT NULL,
  `driver_id` bigint DEFAULT NULL,
  `work_status` int DEFAULT NULL COMMENT '收车：0；出车：1，暂停：2',
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of driver_user_work_status
-- ----------------------------
BEGIN;
INSERT INTO `driver_user_work_status` (`id`, `driver_id`, `work_status`, `gmt_create`, `gmt_modified`) VALUES (1648997879806701570, 1648997879743787009, 0, '2023-04-20 18:31:46', '2023-04-20 18:31:46');
INSERT INTO `driver_user_work_status` (`id`, `driver_id`, `work_status`, `gmt_create`, `gmt_modified`) VALUES (1651881557251596290, 1651881557213847553, 0, '2023-04-28 17:30:28', '2023-04-28 17:30:28');
COMMIT;

-- ----------------------------
-- View structure for v_driver_city_work_status
-- ----------------------------
DROP VIEW IF EXISTS `v_driver_city_work_status`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_driver_city_work_status` AS select `t1`.`id` AS `driver_id`,`t1`.`address` AS `city_code`,`t2`.`work_status` AS `work_status` from (`driver_user` `t1` left join `driver_user_work_status` `t2` on((`t1`.`id` = `t2`.`driver_id`)));

SET FOREIGN_KEY_CHECKS = 1;
