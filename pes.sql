/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : pes

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 05/05/2020 11:20:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学院编号',
  `dept_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 205 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学院表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (201, '中医学院');
INSERT INTO `dept` VALUES (202, '药学院');
INSERT INTO `dept` VALUES (203, '医药信息工程学院');
INSERT INTO `dept` VALUES (204, '医药经济管理学院');

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `stu_id` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `height` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身高',
  `weight` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '体重',
  `nose` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '嗅觉',
  `noseDiseases` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鼻窦疾病',
  `tooth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '门齿',
  `stuttering` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '口吃',
  `bloodPressure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '血压',
  `heartRate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '心率',
  `liver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '肝功能',
  `eyeLeft` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '左眼视力',
  `eyeRight` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '右眼视力',
  `eyeDiseases` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '眼疾',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES (4, '2016325208001', 'ttt', '160', '50', 'dasd', 'sdad', 'sda', 'sda', 'da', 'dsad', 'da', 'da', 'da', 'da');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `dept_name` int(11) NOT NULL COMMENT '学院',
  `grade` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `isInput` int(1) NOT NULL COMMENT '1已录入，0未录入',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2016325208001', 'ttt', '男', 201, 'vvv', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '学生学号作为id',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `perms` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '20200101001', '123456', 'admin');
INSERT INTO `user` VALUES (6, '2016325208001', '123456', 'student');

SET FOREIGN_KEY_CHECKS = 1;
