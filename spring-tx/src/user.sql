/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : sampledb

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-14 10:34:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', 'aa', '13689653214');
INSERT INTO `user` VALUES ('9', 'AA', '13612366547');
INSERT INTO `user` VALUES ('10', 'BB', '13612366547');
INSERT INTO `user` VALUES ('11', 'CC', '13612366547');
INSERT INTO `user` VALUES ('12', 'DD', '13612366547');
INSERT INTO `user` VALUES ('13', 'EE', '13612366547');
INSERT INTO `user` VALUES ('14', 'FF', '13612366547');
INSERT INTO `user` VALUES ('15', 'Kobe', '13601001111');
