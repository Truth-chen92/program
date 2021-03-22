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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  fhgc.banner 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` (`id`, `url`) VALUES
	(1, 'banner0.jpg'),
	(2, 'banner1.jpg'),
	(3, 'banner2.jpg'),
	(4, 'banner3.jpg');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;

-- 导出  表 fhgc.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `administrators` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  fhgc.user 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `password`, `username`, `administrators`) VALUES
	(1, 123456, 'admin', 1),
	(2, 123456, 'tom', 0),
	(3, 123456, 'jerry', 0),
	(4, 123456, 'miki', 0),
	(5, 123456, 'jse', 0),
	(7, 888888, 'cj', 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
