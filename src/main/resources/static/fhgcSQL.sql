-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.68-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 fhgc 的数据库结构
CREATE DATABASE IF NOT EXISTS `fhgc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fhgc`;

-- 导出  表 fhgc.activity 结构
CREATE TABLE IF NOT EXISTS `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `name` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `description` varchar(255) DEFAULT NULL COMMENT '活动描述',
  `time` varchar(255) DEFAULT NULL COMMENT '活动时间',
  `release_time` varchar(255) DEFAULT NULL COMMENT '活动发布时间',
  `location` varchar(255) DEFAULT NULL COMMENT '活动地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  fhgc.activity 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` (`id`, `image_url`, `name`, `description`, `time`, `release_time`, `location`) VALUES
	(1, 'https://image.xisland.cn/xmall/default/445b2874d1a87cb2154c87f2d67d97d91578308549.jpg', '春节活动', '春节活动', '2020-01-24 00:08:00 至 2020-01-27 00:19:00', '2020-01-08 11:09:25', '凤凰古城万寿宫'),
	(2, 'https://image.xisland.cn/xmall/default/43e7343a68a5224741f26495cf538af0%E6%B2%88%E4%BB%8E%E6%96%87.jfif', '九九重阳节', '九月九日忆山东兄弟', '2020-02-21 00:06:00 至 2020-02-28 00:20:00', '2020-01-08 11:19:16', '凤凰景区沈从文'),
	(3, 'https://image.xisland.cn/xmall/default/3856dc7bb2c83ec0721999f0782d272e%E6%B5%8B%E8%AF%95%E7%94%A8.jpg', '凤凰', '凤凰古城', '2020-01-09 00:00:00 至 2020-02-03 00:00:00', '2020-01-09 15:18:47', '凤凰');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;

-- 导出  表 fhgc.banner 结构
CREATE TABLE IF NOT EXISTS `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `sort_num` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- 正在导出表  fhgc.banner 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` (`id`, `url`, `sort_num`) VALUES
	(1, 'image/homePage/banner0.jpg', 2),
	(2, 'image/homePage/banner1.jpg', 3),
	(3, 'image/homePage/banner2.jpg', 5),
	(4, 'image/homePage/banner3.jpg', 6);
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;

-- 导出  表 fhgc.passwordquestion 结构
CREATE TABLE IF NOT EXISTS `passwordquestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `question1` varchar(255) NOT NULL DEFAULT '0',
  `answer1` varchar(255) NOT NULL DEFAULT '0',
  `question2` varchar(255) NOT NULL DEFAULT '0',
  `answer2` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  fhgc.passwordquestion 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `passwordquestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `passwordquestion` ENABLE KEYS */;

-- 导出  表 fhgc.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(50) NOT NULL,
  `administrators` int(11) NOT NULL DEFAULT '0' COMMENT '是否是管理员',
  `phonenumber` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- 正在导出表  fhgc.user 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `password`, `username`, `administrators`, `phonenumber`) VALUES
	(1, '123456', 'admin', 1, '0'),
	(2, '111111', 'tom', 0, '18025894136'),
	(3, '123456', 'jerry', 0, '18952366285'),
	(8, '888888', 'cxcx', 0, '18841259633'),
	(11, 'www', 'ddd', 0, '18030255623'),
	(12, '123456', '123456', 0, '18585855587'),
	(13, '123456', 'dddd', 0, '13234557819'),
	(14, '888888', '151515', 0, '18030255627');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
