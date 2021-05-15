/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 15/05/2021 09:28:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `creator_id` int NULL DEFAULT NULL,
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('欢迎使用超市管理系统', '2021-05-14 08:52:36', 10000, 1);

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `code` bigint NULL DEFAULT NULL,
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  `first_purchase_time` datetime NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, 'Apple iPhone 12 (A2404) 128GB 绿色 支持移动联通电信5G 双卡双待手机', 69200245251141, 5999.00, '2021-05-14 10:18:33', 6899.00, 249);
INSERT INTO `commodity` VALUES (2, '小米11 5G 骁龙888 2K AMOLED四曲面柔性屏 1亿像素 55W有线闪充 50W无线闪充 8GB+256GB 蓝色 游戏手机', 69200245251142, 3699.00, '2021-05-14 20:11:42', 4299.00, 100);
INSERT INTO `commodity` VALUES (3, 'MIX FOLD 小米折叠屏手机 5G 2K+折叠屏 骁龙888 一亿像素 哈曼卡顿立体声四扬声器 12GB+512GB 黑色游戏手机', 69200245251143, 8999.00, '2021-05-14 20:12:47', 8999.00, 20);
INSERT INTO `commodity` VALUES (4, '小米11 Pro 5G 骁龙888 2K AMOLED四曲面柔性屏 67W无线闪充 3D玻璃工艺 8GB+256GB 黑色 游戏手机', 69200245251140, 3999.00, '2021-05-14 20:13:13', 3999.00, 100);
INSERT INTO `commodity` VALUES (5, 'Apple iPhone 11 (A2223) 128GB 白色 移动联通电信4G手机 双卡双待', 69200245251144, 3399.00, '2021-05-14 20:13:42', 3399.00, 100);
INSERT INTO `commodity` VALUES (6, 'Apple iPhone 12 mini (A2400) 64GB 紫色 手机 支持移动联通电信5G', 69200245251145, 3599.00, '2021-05-14 20:14:14', 3599.00, 200);

-- ----------------------------
-- Table structure for customer_return
-- ----------------------------
DROP TABLE IF EXISTS `customer_return`;
CREATE TABLE `customer_return`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` bigint NULL DEFAULT NULL,
  `purchase_time` datetime NULL DEFAULT NULL,
  `return_time` datetime NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer_return
-- ----------------------------
INSERT INTO `customer_return` VALUES (NULL, 1, 69200245251141, NULL, '2021-05-14 12:32:53', 1000, NULL);
INSERT INTO `customer_return` VALUES (NULL, 2, 69200245251141, NULL, '2021-05-14 12:33:09', 150, NULL);

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` bigint NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `person` int NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `quantity` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES (4, 69200245251141, 'Apple iPhone 12 (A2404) 128GB 绿色 支持移动联通电信5G 双卡双待手机', 100001, 5999.00, '2021-05-14 10:18:32', 100);
INSERT INTO `purchase` VALUES (5, 69200245251142, '小米11 5G 骁龙888 2K AMOLED四曲面柔性屏 1亿像素 55W有线闪充 50W无线闪充 8GB+256GB 蓝色 游戏手机', 100003, 3699.00, '2021-05-14 20:11:42', 100);
INSERT INTO `purchase` VALUES (6, 69200245251143, 'MIX FOLD 小米折叠屏手机 5G 2K+折叠屏 骁龙888 一亿像素 哈曼卡顿立体声四扬声器 12GB+512GB 黑色游戏手机', 100003, 8999.00, '2021-05-14 20:12:47', 20);
INSERT INTO `purchase` VALUES (7, 69200245251140, '小米11 Pro 5G 骁龙888 2K AMOLED四曲面柔性屏 67W无线闪充 3D玻璃工艺 8GB+256GB 黑色 游戏手机', 100003, 3999.00, '2021-05-14 20:13:13', 100);
INSERT INTO `purchase` VALUES (8, 69200245251144, 'Apple iPhone 11 (A2223) 128GB 白色 移动联通电信4G手机 双卡双待', 100000, 3399.00, '2021-05-14 20:13:42', 100);
INSERT INTO `purchase` VALUES (9, 69200245251145, 'Apple iPhone 12 mini (A2400) 64GB 紫色 手机 支持移动联通电信5G', 100000, 3599.00, '2021-05-14 20:14:14', 200);

-- ----------------------------
-- Table structure for return
-- ----------------------------
DROP TABLE IF EXISTS `return`;
CREATE TABLE `return`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `code` bigint NULL DEFAULT NULL,
  `person` int UNSIGNED NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of return
-- ----------------------------

-- ----------------------------
-- Table structure for sales
-- ----------------------------
DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `code` bigint NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sales
-- ----------------------------
INSERT INTO `sales` VALUES (1, 'Apple iPhone 12 (A2404) 128GB 绿色 支持移动联通电信5G 双卡双待手机', 69200245251141, '2021-05-14 12:33:13', 20, 5999.00, NULL);
INSERT INTO `sales` VALUES (2, 'Apple iPhone 12 (A2404) 128GB 绿色 支持移动联通电信5G 双卡双待手机', 69200245251141, '2021-05-14 20:14:45', 2, 6899.00, NULL);
INSERT INTO `sales` VALUES (3, '小米11 5G 骁龙888 2K AMOLED四曲面柔性屏 1亿像素 55W有线闪充 50W无线闪充 8GB+256GB 蓝色 游戏手机', 69200245251142, '2021-05-14 20:14:49', 1, 4299.00, NULL);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `salary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '张三', '13365584254', '男', 28, '3200');
INSERT INTO `staff` VALUES (2, '李四', '13655885478', '女', 123, '3230');
INSERT INTO `staff` VALUES (3, '王五', '13655885478', '男', 123, '3230');

-- ----------------------------
-- Table structure for suggest
-- ----------------------------
DROP TABLE IF EXISTS `suggest`;
CREATE TABLE `suggest`  (
  `time` datetime NULL DEFAULT NULL,
  `reply` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reply_time` datetime NULL DEFAULT NULL,
  `reply_user` int NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of suggest
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('晨光', 100000);
INSERT INTO `supplier` VALUES ('Apple', 100001);
INSERT INTO `supplier` VALUES ('小米', 100003);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10000, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
