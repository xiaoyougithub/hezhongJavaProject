/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : dqq

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-07-13 14:54:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `publicmessage`
-- ----------------------------
DROP TABLE IF EXISTS `publicmessage`;
CREATE TABLE `publicmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of publicmessage
-- ----------------------------
INSERT INTO `publicMessage` VALUES ('1', '黄茂俊', '1949-10-01', '祝贺新中国成立，毛主席万岁！');
INSERT INTO `publicMessage` VALUES ('2', '黄茂俊', '2019-7-13 14:10:26', 'hello');
INSERT INTO `publicMessage` VALUES ('3', '黄茂俊', '2019-7-13 14:12:0', 'hello');
INSERT INTO `publicMessage` VALUES ('4', '黄茂俊', '2019-7-13 14:12:17', '大家下午好呀');
INSERT INTO `publicMessage` VALUES ('5', '黄雨晴', '2019-7-13 14:12:55', '好你个头哇');
INSERT INTO `publicMessage` VALUES ('6', '黄茂俊', '2019-7-13 14:13:6', '你个小鬼');
INSERT INTO `publicMessage` VALUES ('7', '黄茂俊', '2019-7-13 14:14:31', '你个猪头');
INSERT INTO `publicMessage` VALUES ('8', '黄茂俊', '2019-7-13 14:37:1', '@黄雨晴，你个猪头');
INSERT INTO `publicMessage` VALUES ('9', '黄茂俊', '2019-7-13 14:47:37', '好样的～');
INSERT INTO `publicMessage` VALUES ('10', '黄茂俊', '2019-7-13 14:48:26', '怼她！');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '黄茂俊', '123456', 'null');
INSERT INTO `user` VALUES ('11', '张涛', '123456', '3220837933@qq.com');
INSERT INTO `user` VALUES ('15', '傅烨斌', '38385438', '7474741');
INSERT INTO `user` VALUES ('16', '黄雨晴', '123456', '123456');
INSERT INTO `user` VALUES ('17', '黄雨虹', '123456', '');
INSERT INTO `user` VALUES ('18', '黄茂强', '123456', '');
INSERT INTO `user` VALUES ('19', '黄施', '123456', '');
INSERT INTO `user` VALUES ('20', '黄婷', '123456', '');
