/*
 Navicat Premium Data Transfer

 Source Server         : springboot_jxd
 Source Server Type    : MySQL
 Source Server Version : 50719 (5.7.19)
 Source Host           : localhost:3306
 Source Schema         : springboot_jxd

 Target Server Type    : MySQL
 Target Server Version : 50719 (5.7.19)
 File Encoding         : 65001

 Date: 29/09/2023 21:03:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Client
-- ----------------------------
DROP TABLE IF EXISTS `Client`;
CREATE TABLE `Client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Client
-- ----------------------------
BEGIN;
INSERT INTO `Client` (`client_id`, `name`, `age`, `address`, `birth_date`, `company`) VALUES (1, 'Tom Doe', 25, '123 Main St', '1995-02-15', 'Beco Inc');
INSERT INTO `Client` (`client_id`, `name`, `age`, `address`, `birth_date`, `company`) VALUES (2, 'Jane Smith', 28, '456 Elm St', '1995-02-20', 'XYZ Corporation');
INSERT INTO `Client` (`client_id`, `name`, `age`, `address`, `birth_date`, `company`) VALUES (3, 'Bob Johnson', 35, '789 Oak St', '1988-09-10', 'LMN Inc');
COMMIT;

-- ----------------------------
-- Table structure for Request
-- ----------------------------
DROP TABLE IF EXISTS `Request`;
CREATE TABLE `Request` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `request_message` varchar(255) DEFAULT NULL,
  `current_status` enum('In progress','Completed') NOT NULL,
  `assigned_to` varchar(255) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `request_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `Client` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Request
-- ----------------------------
BEGIN;
INSERT INTO `Request` (`request_id`, `client_id`, `request_message`, `current_status`, `assigned_to`, `created_date`) VALUES (1, 1, 'Please review project proposal', 'In progress', 'Alice', '2023-09-29 18:31:24');
INSERT INTO `Request` (`request_id`, `client_id`, `request_message`, `current_status`, `assigned_to`, `created_date`) VALUES (2, 2, 'Update customer information', 'Completed', 'Eva', '2023-09-29 18:31:24');
INSERT INTO `Request` (`request_id`, `client_id`, `request_message`, `current_status`, `assigned_to`, `created_date`) VALUES (3, 1, 'Troubleshoot server issue', 'In progress', 'Bob', '2023-09-29 18:31:24');
INSERT INTO `Request` (`request_id`, `client_id`, `request_message`, `current_status`, `assigned_to`, `created_date`) VALUES (4, 2, 'pls reply to email', 'Completed', 'Alice', '2023-09-29 18:31:24');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
