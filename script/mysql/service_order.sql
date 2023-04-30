/*
 Navicat Premium Data Transfer

 Source Server         : 101.200.91.104
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : 101.200.91.104:3306
 Source Schema         : service_order

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 30/04/2023 02:12:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `passenger_id` bigint DEFAULT NULL COMMENT '乘客ID',
  `passenger_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '乘客手机号',
  `driver_id` bigint DEFAULT NULL COMMENT '司机ID',
  `driver_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '司机手机号',
  `car_id` bigint DEFAULT NULL COMMENT '车辆Id',
  `address` char(6) DEFAULT NULL COMMENT '发起地行政区划代码',
  `order_time` datetime DEFAULT NULL COMMENT '订单发起时间',
  `depart_time` datetime DEFAULT NULL COMMENT '预计用车时间',
  `departure` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '预计出发地点详细地址',
  `dep_longitude` varchar(16) DEFAULT NULL COMMENT '预计出发地点经度',
  `dep_latitude` varchar(16) DEFAULT NULL COMMENT '预计出发地点纬度',
  `destination` varchar(128) DEFAULT NULL COMMENT '预计目的地',
  `dest_longitude` varchar(16) DEFAULT NULL COMMENT '预计目的地经度',
  `dest_latitude` varchar(16) DEFAULT NULL COMMENT '预计目的地纬度',
  `encrypt` int DEFAULT NULL COMMENT '坐标加密标识\r\n1:GCJ-02测绘局标准\r\n2:WGS84 GPS标准\r\n3:BD-09 百度标准\r\n4:CGCS2000 北斗标准\r\n0:其他',
  `fare_version` int DEFAULT NULL,
  `receive_order_car_longitude` varchar(16) DEFAULT NULL COMMENT '接单时车辆经度',
  `receive_order_car_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '接单时车辆纬度',
  `receive_order_time` datetime DEFAULT NULL COMMENT '接单时间，派单成功时间',
  `license_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '机动车驾驶证号',
  `vehicle_no` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车辆号牌',
  `to_pick_up_passenger_time` datetime DEFAULT NULL COMMENT '司机去接乘客出发时间',
  `to_pick_up_passenger_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '去接乘客时，司机的经度',
  `to_pick_up_passenger_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '去接乘客时，司机的纬度',
  `to_pick_up_passenger_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '去接乘客时，司机的地点',
  `driver_arrived_departure_time` datetime DEFAULT NULL COMMENT '司机到达上车点时间',
  `pick_up_passenger_time` datetime DEFAULT NULL COMMENT '接到乘客，乘客上车时间',
  `pick_up_passenger_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '接到乘客，乘客上车经度',
  `pick_up_passenger_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '接到乘客，乘客上车纬度',
  `passenger_getoff_time` datetime DEFAULT NULL COMMENT '乘客下车时间',
  `passenger_getoff_longitude` varchar(16) DEFAULT NULL COMMENT '乘客下车经度',
  `passenger_getoff_latitude` varchar(16) DEFAULT NULL COMMENT '乘客下车纬度',
  `cancel_time` datetime DEFAULT NULL COMMENT '订单撤销时间',
  `cancel_operator` int DEFAULT NULL COMMENT '撤销发起者：1:乘客\r\n2:驾驶员\r\n3:平台公司',
  `cancel_type_code` int DEFAULT NULL COMMENT '撤销类型代码\r\n1:乘客提前撤销\r\n2:驾驶员提前撤销\r\n3:平台公司撤销\r\n4;乘客违约撤销\r\n5:驾驶员违约撤销',
  `drive_mile` bigint DEFAULT NULL COMMENT '载客里程（米）',
  `drive_time` bigint DEFAULT NULL COMMENT '载客时间(分)',
  `order_status` int DEFAULT NULL COMMENT '订单状态1：订单开始 2：司机接单 3：去接乘客 4：司机到达乘客起点 5：乘客上车，司机开始行程 6：到达目的地，行程结束，未支付 7：发起收款 8: 支付完成 9.订单取消''',
  `price` double(10,2) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1651955622490423299 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_info
-- ----------------------------
BEGIN;
INSERT INTO `order_info` (`id`, `passenger_id`, `passenger_phone`, `driver_id`, `driver_phone`, `car_id`, `address`, `order_time`, `depart_time`, `departure`, `dep_longitude`, `dep_latitude`, `destination`, `dest_longitude`, `dest_latitude`, `encrypt`, `fare_version`, `receive_order_car_longitude`, `receive_order_car_latitude`, `receive_order_time`, `license_id`, `vehicle_no`, `to_pick_up_passenger_time`, `to_pick_up_passenger_longitude`, `to_pick_up_passenger_latitude`, `to_pick_up_passenger_address`, `driver_arrived_departure_time`, `pick_up_passenger_time`, `pick_up_passenger_longitude`, `pick_up_passenger_latitude`, `passenger_getoff_time`, `passenger_getoff_longitude`, `passenger_getoff_latitude`, `cancel_time`, `cancel_operator`, `cancel_type_code`, `drive_mile`, `drive_time`, `order_status`, `price`, `gmt_create`, `gmt_modified`) VALUES (1651890210331541506, 1584355669008773123, '17630905198', NULL, NULL, NULL, '440000', '2023-04-28 18:04:51', '2023-04-28 18:00:00', '广东省深圳市龙华区民治地铁', '114.04085', '22.617545', '广东省深圳市福田区上步工业区', '114.084177', '22.54764', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2023-04-28 18:04:51', '2023-04-28 18:04:51');
INSERT INTO `order_info` (`id`, `passenger_id`, `passenger_phone`, `driver_id`, `driver_phone`, `car_id`, `address`, `order_time`, `depart_time`, `departure`, `dep_longitude`, `dep_latitude`, `destination`, `dest_longitude`, `dest_latitude`, `encrypt`, `fare_version`, `receive_order_car_longitude`, `receive_order_car_latitude`, `receive_order_time`, `license_id`, `vehicle_no`, `to_pick_up_passenger_time`, `to_pick_up_passenger_longitude`, `to_pick_up_passenger_latitude`, `to_pick_up_passenger_address`, `driver_arrived_departure_time`, `pick_up_passenger_time`, `pick_up_passenger_longitude`, `pick_up_passenger_latitude`, `passenger_getoff_time`, `passenger_getoff_longitude`, `passenger_getoff_latitude`, `cancel_time`, `cancel_operator`, `cancel_type_code`, `drive_mile`, `drive_time`, `order_status`, `price`, `gmt_create`, `gmt_modified`) VALUES (1651954701979107329, 1584355669008773123, '17630905198', NULL, NULL, NULL, '440309', '2023-04-28 22:21:07', '2023-04-28 10:17:34', '广东省深圳市龙华区民治街道宜水居公寓塘水围一区', '114.037582', '22.623599', '广东省深圳市福田区红荔路3007号(华强北地铁站C口步行300米)', '114.084177', '22.54764', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2023-04-28 22:21:07', '2023-04-28 22:21:07');
INSERT INTO `order_info` (`id`, `passenger_id`, `passenger_phone`, `driver_id`, `driver_phone`, `car_id`, `address`, `order_time`, `depart_time`, `departure`, `dep_longitude`, `dep_latitude`, `destination`, `dest_longitude`, `dest_latitude`, `encrypt`, `fare_version`, `receive_order_car_longitude`, `receive_order_car_latitude`, `receive_order_time`, `license_id`, `vehicle_no`, `to_pick_up_passenger_time`, `to_pick_up_passenger_longitude`, `to_pick_up_passenger_latitude`, `to_pick_up_passenger_address`, `driver_arrived_departure_time`, `pick_up_passenger_time`, `pick_up_passenger_longitude`, `pick_up_passenger_latitude`, `passenger_getoff_time`, `passenger_getoff_longitude`, `passenger_getoff_latitude`, `cancel_time`, `cancel_operator`, `cancel_type_code`, `drive_mile`, `drive_time`, `order_status`, `price`, `gmt_create`, `gmt_modified`) VALUES (1651954759361380353, 1584355669008773123, '17630905198', NULL, NULL, NULL, '440309', '2023-04-28 22:21:21', '2023-04-28 10:17:34', '广东省深圳市龙华区民治街道宜水居公寓塘水围一区', '114.037582', '22.623599', '广东省深圳市福田区红荔路3007号(华强北地铁站C口步行300米)', '114.084177', '22.54764', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2023-04-28 22:21:21', '2023-04-28 22:21:21');
INSERT INTO `order_info` (`id`, `passenger_id`, `passenger_phone`, `driver_id`, `driver_phone`, `car_id`, `address`, `order_time`, `depart_time`, `departure`, `dep_longitude`, `dep_latitude`, `destination`, `dest_longitude`, `dest_latitude`, `encrypt`, `fare_version`, `receive_order_car_longitude`, `receive_order_car_latitude`, `receive_order_time`, `license_id`, `vehicle_no`, `to_pick_up_passenger_time`, `to_pick_up_passenger_longitude`, `to_pick_up_passenger_latitude`, `to_pick_up_passenger_address`, `driver_arrived_departure_time`, `pick_up_passenger_time`, `pick_up_passenger_longitude`, `pick_up_passenger_latitude`, `passenger_getoff_time`, `passenger_getoff_longitude`, `passenger_getoff_latitude`, `cancel_time`, `cancel_operator`, `cancel_type_code`, `drive_mile`, `drive_time`, `order_status`, `price`, `gmt_create`, `gmt_modified`) VALUES (1651954873719078913, 1584355669008773123, '17630905198', NULL, NULL, NULL, '440309', '2023-04-28 22:21:48', '2023-04-28 10:17:34', '广东省深圳市龙华区民治街道宜水居公寓塘水围一区', '114.037582', '22.623599', '广东省深圳市福田区红荔路3007号(华强北地铁站C口步行300米)', '114.084177', '22.54764', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2023-04-28 22:21:48', '2023-04-28 22:21:48');
INSERT INTO `order_info` (`id`, `passenger_id`, `passenger_phone`, `driver_id`, `driver_phone`, `car_id`, `address`, `order_time`, `depart_time`, `departure`, `dep_longitude`, `dep_latitude`, `destination`, `dest_longitude`, `dest_latitude`, `encrypt`, `fare_version`, `receive_order_car_longitude`, `receive_order_car_latitude`, `receive_order_time`, `license_id`, `vehicle_no`, `to_pick_up_passenger_time`, `to_pick_up_passenger_longitude`, `to_pick_up_passenger_latitude`, `to_pick_up_passenger_address`, `driver_arrived_departure_time`, `pick_up_passenger_time`, `pick_up_passenger_longitude`, `pick_up_passenger_latitude`, `passenger_getoff_time`, `passenger_getoff_longitude`, `passenger_getoff_latitude`, `cancel_time`, `cancel_operator`, `cancel_type_code`, `drive_mile`, `drive_time`, `order_status`, `price`, `gmt_create`, `gmt_modified`) VALUES (1651955284123336706, 1584355669008773123, '17630905198', NULL, NULL, NULL, '440309', '2023-04-28 22:23:26', '2023-04-28 10:17:34', '广东省深圳市龙华区民治街道宜水居公寓塘水围一区', '114.037582', '22.623599', '广东省深圳市福田区红荔路3007号(华强北地铁站C口步行300米)', '114.084177', '22.54764', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2023-04-28 22:23:26', '2023-04-28 22:23:26');
INSERT INTO `order_info` (`id`, `passenger_id`, `passenger_phone`, `driver_id`, `driver_phone`, `car_id`, `address`, `order_time`, `depart_time`, `departure`, `dep_longitude`, `dep_latitude`, `destination`, `dest_longitude`, `dest_latitude`, `encrypt`, `fare_version`, `receive_order_car_longitude`, `receive_order_car_latitude`, `receive_order_time`, `license_id`, `vehicle_no`, `to_pick_up_passenger_time`, `to_pick_up_passenger_longitude`, `to_pick_up_passenger_latitude`, `to_pick_up_passenger_address`, `driver_arrived_departure_time`, `pick_up_passenger_time`, `pick_up_passenger_longitude`, `pick_up_passenger_latitude`, `passenger_getoff_time`, `passenger_getoff_longitude`, `passenger_getoff_latitude`, `cancel_time`, `cancel_operator`, `cancel_type_code`, `drive_mile`, `drive_time`, `order_status`, `price`, `gmt_create`, `gmt_modified`) VALUES (1651955622490423298, 1584355669008773123, '17630905198', NULL, NULL, NULL, '440309', '2023-04-28 22:24:47', '2023-04-28 10:24:37', '广东省深圳市龙华区民治街道宜水居公寓塘水围一区', '114.037587', '22.623513', '广东省深圳市福田区红荔路3007号(华强北地铁站C口步行300米)', '114.084177', '22.54764', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2023-04-28 22:24:47', '2023-04-28 22:24:47');
COMMIT;

-- ----------------------------
-- Table structure for price_rule
-- ----------------------------
DROP TABLE IF EXISTS `price_rule`;
CREATE TABLE `price_rule` (
  `id` bigint NOT NULL,
  `city_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '城市代码',
  `start_fare` double(4,2) DEFAULT NULL COMMENT '起步价',
  `start_mile` int DEFAULT NULL COMMENT '起步里程\n',
  `unit_price_per_mile` double(4,2) DEFAULT NULL COMMENT '单位距离价格（千米）\n',
  `fare_version` int NOT NULL COMMENT '版本，默认1，修改往上增。\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of price_rule
-- ----------------------------
BEGIN;
INSERT INTO `price_rule` (`id`, `city_code`, `start_fare`, `start_mile`, `unit_price_per_mile`, `fare_version`) VALUES (1651839457030070273, '440309', 10.00, 5, 5.00, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
