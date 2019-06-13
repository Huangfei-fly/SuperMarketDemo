/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50725
Source Host           : 39.108.172.6:3306
Source Database       : SuperMarketDemo

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-06-08 03:01:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `shop_ID` varchar(15) DEFAULT NULL,
  `cashier_ID` varchar(15) DEFAULT NULL,
  `com_ID` varchar(15) DEFAULT NULL,
  `sell_Num` int(11) DEFAULT NULL,
  KEY `shop` (`shop_ID`),
  KEY `com` (`com_ID`),
  KEY `cashier` (`cashier_ID`),
  CONSTRAINT `cashier` FOREIGN KEY (`cashier_ID`) REFERENCES `cashier` (`cashier_ID`),
  CONSTRAINT `com` FOREIGN KEY (`com_ID`) REFERENCES `commodity` (`com_ID`),
  CONSTRAINT `shop` FOREIGN KEY (`shop_ID`) REFERENCES `shop` (`shop_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('001', 'cashier1', '001', '50');
INSERT INTO `bill` VALUES ('001', 'cashier1', '002', '30');
INSERT INTO `bill` VALUES ('001', 'cashier1', '003', '60');
INSERT INTO `bill` VALUES ('001', 'cashier1', '004', '400');
INSERT INTO `bill` VALUES ('001', 'cashier1', '005', '600');
INSERT INTO `bill` VALUES ('001', 'cashier1', '006', '60');
INSERT INTO `bill` VALUES ('001', 'cashier1', '007', '233');
INSERT INTO `bill` VALUES ('001', 'cashier1', '004', '19');
INSERT INTO `bill` VALUES ('001', 'cashier1', '007', '66');
INSERT INTO `bill` VALUES ('001', 'cashier1', '007', '66');
INSERT INTO `bill` VALUES ('001', 'cashier1', '006', '333');

-- ----------------------------
-- Table structure for `cashier`
-- ----------------------------
DROP TABLE IF EXISTS `cashier`;
CREATE TABLE `cashier` (
  `cashier_ID` varchar(15) NOT NULL,
  `cashier_Name` varchar(255) DEFAULT NULL,
  `gender` int(1) DEFAULT '1',
  `birthday` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `shop_ID` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cashier_ID`),
  KEY `cashier_Id` (`cashier_ID`),
  KEY `shop3` (`shop_ID`),
  CONSTRAINT `shop3` FOREIGN KEY (`shop_ID`) REFERENCES `shop` (`shop_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cashier
-- ----------------------------
INSERT INTO `cashier` VALUES ('cashier1', '罗', '1', '1999-01-01', '1100', '001');
INSERT INTO `cashier` VALUES ('cashier2', '高', '1', '1999-01-02', '1101', '001');
INSERT INTO `cashier` VALUES ('cashier3', '王', '0', '1999-03-05', '1102', '002');

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `com_ID` varchar(15) NOT NULL,
  `com_Name` varchar(255) DEFAULT NULL,
  `sell_Price` float DEFAULT NULL,
  `purchase_Price` float DEFAULT NULL,
  `stock_Num` int(11) DEFAULT NULL,
  `warning_Num` int(11) DEFAULT NULL,
  `warehouse_ID` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`com_ID`),
  KEY `ware1` (`warehouse_ID`),
  CONSTRAINT `ware1` FOREIGN KEY (`warehouse_ID`) REFERENCES `warehouse` (`warehouse_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('001', '牙膏', '12', '3.2', '600', '50', '001');
INSERT INTO `commodity` VALUES ('002', '牙刷', '10', '2', '501', '50', '001');
INSERT INTO `commodity` VALUES ('003', '脸盆', '7', '3', '500', '50', '001');
INSERT INTO `commodity` VALUES ('004', '薯片', '8', '2.6', '1000', '100', '001');
INSERT INTO `commodity` VALUES ('005', '辣条', '4.5', '1.3', '2000', '200', '001');
INSERT INTO `commodity` VALUES ('006', '拖把', '45', '16', '500', '50', '001');
INSERT INTO `commodity` VALUES ('007', '插排', '30', '10', '500', '50', '001');
INSERT INTO `commodity` VALUES ('008', '曲奇', '50', '10', '500', '50', '001');
INSERT INTO `commodity` VALUES ('009', '牙膏', '12', '3.2', '500', '50', '002');
INSERT INTO `commodity` VALUES ('010', '牙刷', '10', '2', '500', '50', '002');
INSERT INTO `commodity` VALUES ('011', '脸盆', '7', '3', '500', '50', '002');
INSERT INTO `commodity` VALUES ('012', '薯片', '8', '2.6', '1000', '100', '002');
INSERT INTO `commodity` VALUES ('013', '辣条', '4.5', '1.3', '2000', '200', '002');
INSERT INTO `commodity` VALUES ('014', '拖把', '45', '16', '500', '50', '002');
INSERT INTO `commodity` VALUES ('015', '插排', '30', '10', '500', '50', '002');
INSERT INTO `commodity` VALUES ('016', '曲奇', '50', '10', '500', '50', '002');
INSERT INTO `commodity` VALUES ('017', '牙膏', '12', '3.2', '500', '50', '003');
INSERT INTO `commodity` VALUES ('018', '牙刷', '10', '2', '500', '50', '003');
INSERT INTO `commodity` VALUES ('019', '脸盆', '7', '3', '500', '50', '003');
INSERT INTO `commodity` VALUES ('020', '薯片', '8', '2.6', '1000', '100', '003');
INSERT INTO `commodity` VALUES ('021', '辣条', '4.5', '1.3', '2000', '200', '003');
INSERT INTO `commodity` VALUES ('022', '拖把', '45', '16', '500', '50', '003');
INSERT INTO `commodity` VALUES ('023', '插排', '30', '10', '500', '50', '003');
INSERT INTO `commodity` VALUES ('024', '曲奇', '50', '10', '500', '50', '003');

-- ----------------------------
-- Table structure for `executor`
-- ----------------------------
DROP TABLE IF EXISTS `executor`;
CREATE TABLE `executor` (
  `executor_ID` varchar(15) NOT NULL,
  `executor_Name` varchar(255) DEFAULT NULL,
  `gender` int(1) DEFAULT '1',
  `phone` varchar(11) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`executor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of executor
-- ----------------------------
INSERT INTO `executor` VALUES ('executor1', '罗1', '1', '1501111', '1974-10-1');
INSERT INTO `executor` VALUES ('executor2', '罗2', '0', '1504444', '1960-10-1');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_ID` varchar(15) NOT NULL,
  `manager_Name` varchar(255) DEFAULT NULL,
  `brithday` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `gender` int(1) DEFAULT '1',
  PRIMARY KEY (`manager_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('manager', '罗', '1998-02-01', '10086', '1');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `com_ID` varchar(15) DEFAULT NULL,
  `warehouse_ID` varchar(15) DEFAULT NULL,
  `purchase_Num` int(11) DEFAULT NULL,
  KEY `com11` (`com_ID`),
  KEY `ware11` (`warehouse_ID`),
  CONSTRAINT `com11` FOREIGN KEY (`com_ID`) REFERENCES `commodity` (`com_ID`),
  CONSTRAINT `ware11` FOREIGN KEY (`warehouse_ID`) REFERENCES `warehouse` (`warehouse_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('001', '001', '500');
INSERT INTO `purchase` VALUES ('002', '001', '500');
INSERT INTO `purchase` VALUES ('002', '001', '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_ID` varchar(1) NOT NULL,
  `role_Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员');
INSERT INTO `role` VALUES ('2', '经理');
INSERT INTO `role` VALUES ('3', '收银员');
INSERT INTO `role` VALUES ('4', '业务员');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_ID` varchar(15) NOT NULL,
  `shop_Name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `manager_ID` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`shop_ID`),
  KEY `manager` (`manager_ID`),
  CONSTRAINT `manager` FOREIGN KEY (`manager_ID`) REFERENCES `manager` (`manager_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('001', '弟中弟1号', '北京', '10086', 'manager');
INSERT INTO `shop` VALUES ('002', '弟中弟2号', '上海', '10000', 'manager');
INSERT INTO `shop` VALUES ('003', '弟中弟3号', '杭州', '10010', 'manager');

-- ----------------------------
-- Table structure for `supply`
-- ----------------------------
DROP TABLE IF EXISTS `supply`;
CREATE TABLE `supply` (
  `shop_ID` varchar(15) DEFAULT NULL,
  `warehouse_ID` varchar(15) DEFAULT NULL,
  `com_ID` varchar(15) DEFAULT NULL,
  `supply_Num` int(11) DEFAULT NULL,
  KEY `shop1` (`shop_ID`),
  KEY `ware` (`warehouse_ID`),
  KEY `com1` (`com_ID`),
  CONSTRAINT `com1` FOREIGN KEY (`com_ID`) REFERENCES `commodity` (`com_ID`),
  CONSTRAINT `shop1` FOREIGN KEY (`shop_ID`) REFERENCES `shop` (`shop_ID`),
  CONSTRAINT `ware` FOREIGN KEY (`warehouse_ID`) REFERENCES `warehouse` (`warehouse_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supply
-- ----------------------------
INSERT INTO `supply` VALUES ('001', '001', '001', '20');
INSERT INTO `supply` VALUES ('001', '001', '002', '500');
INSERT INTO `supply` VALUES ('001', '001', '003', '60');
INSERT INTO `supply` VALUES ('001', '001', '003', '50');
INSERT INTO `supply` VALUES ('001', '001', '005', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '003', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '002', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '002', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');
INSERT INTO `supply` VALUES ('001', '001', '001', '600');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_ID` varchar(15) NOT NULL,
  `user_Password` varchar(255) DEFAULT NULL,
  `role_ID` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`user_ID`),
  KEY `role` (`role_ID`),
  CONSTRAINT `role` FOREIGN KEY (`role_ID`) REFERENCES `role` (`role_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123456', '1');
INSERT INTO `user` VALUES ('cashier1', '123456', '3');
INSERT INTO `user` VALUES ('cashier2', '123456', '3');
INSERT INTO `user` VALUES ('cashier3', '123456', '3');
INSERT INTO `user` VALUES ('executor1', '123456', '4');
INSERT INTO `user` VALUES ('manager', '123456', '2');

-- ----------------------------
-- Table structure for `warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `warehouse_ID` varchar(15) NOT NULL,
  `warehouse_Name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `executor_ID` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`warehouse_ID`),
  KEY `exe` (`executor_ID`),
  CONSTRAINT `exe` FOREIGN KEY (`executor_ID`) REFERENCES `executor` (`executor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('001', '中央仓库1', '北京', '150', 'executor1');
INSERT INTO `warehouse` VALUES ('002', '中央仓库2', '上海', '160', 'executor1');
INSERT INTO `warehouse` VALUES ('003', '中央仓库3', '苏州', '170', 'executor1');
