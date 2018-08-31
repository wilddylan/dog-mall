# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.18)
# Database: dog_mall
# Generation Time: 2018-08-30 04:56:34 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_admin_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_admin_user`;

CREATE TABLE `t_admin_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码md5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_admin_user` WRITE;
/*!40000 ALTER TABLE `t_admin_user` DISABLE KEYS */;

INSERT INTO `t_admin_user` (`id`, `username`, `password`)
VALUES
	(1,'admin','admin');

/*!40000 ALTER TABLE `t_admin_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` varchar(64) NOT NULL DEFAULT '' COMMENT '订单id',
  `order_state` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `piece` int(11) NOT NULL DEFAULT '1' COMMENT '数量',
  `price` float NOT NULL DEFAULT '0' COMMENT '当前价格',
  `invite` int(11) NOT NULL DEFAULT '0' COMMENT '邀请好友人数',
  `invite_info` text NOT NULL COMMENT '邀请好友列表',
  `product_id` int(64) NOT NULL COMMENT '商品id ',
  `express_info` text NOT NULL COMMENT '快递信息',
  `express_state` int(11) NOT NULL DEFAULT '0' COMMENT '快递状态',
  `specials` text NOT NULL COMMENT '购买规格',
  `origin_price` float NOT NULL DEFAULT '0' COMMENT '最初价格',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `open_id` varchar(255) NOT NULL DEFAULT '' COMMENT '用户openid',
  `share_id` varchar(64) DEFAULT NULL COMMENT '通过谁分享',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;

INSERT INTO `t_order` (`id`, `order_id`, `order_state`, `piece`, `price`, `invite`, `invite_info`, `product_id`, `express_info`, `express_state`, `specials`, `origin_price`, `update_time`, `create_time`, `open_id`, `share_id`)
VALUES
	(1,'201808291043554',2,3,200,2,'[{\"@type\":\"mall.dog.entity.user.UserInfo\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKZ2fnNqAUVhFBxY15KcCHOk93zsefiaqMqrfwC2dO3iamlJzcR6ibyTpoGFia0WhAuWSDtqdazia2tiaEw/132\",\"city\":\"Hohhot\",\"country\":\"China\",\"gender\":\"1\",\"language\":\"zh_CN\",\"nickName\":\"dylan\",\"openId\":\"o-Phr5ZqGJBGx9lPKbPZAN9HJjHY\",\"province\":\"Inner Mongolia\",\"unionId\":\"\"},{\"@type\":\"mall.dog.entity.user.UserInfo\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKZ2fnNqAUVhFBxY15KcCHOk93zsefiaqMqrfwC2dO3iamlJzcR6ibyTpoGFia0WhAuWSDtqdazia2tiaEw/132\",\"city\":\"Hohhot\",\"country\":\"China\",\"gender\":\"1\",\"language\":\"zh_CN\",\"nickName\":\"dylan\",\"openId\":\"o-Phr5ZqGJBGx9lPKbPZAN9HJjHY\",\"province\":\"Inner Mongolia\",\"unionId\":\"\"}]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"赛罕区内蒙古自治区呼和浩特市内蒙古师范大学赛罕校区[010022]\",\"contact\":\"薛雨仑\",\"current\":\"\",\"expect\":\"\",\"expressNumber\":\"\",\"name\":\"\",\"phone\":\"13088488288\",\"postCode\":\"010022\"}',1,'[\"口味：咸口、甜口、偏干、偏湿、\",\"重量：咸口、\"]',200,'2018-08-29 21:34:32','2018-08-29 10:43:55','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(2,'201808291320284',0,4,400,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"赛罕区内蒙古自治区呼和浩特市内蒙古师范大学赛罕校区[010022]\",\"contact\":\"薛雨仑\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"13088488288\",\"postCode\":\"010022\"}',0,'[\"口味：咸口、偏干、偏湿、\",\"重量：偏湿、\"]',400,'2018-08-29 13:20:28','2018-08-29 13:20:28','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(3,'201808291330244',1,6,600,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"赛罕区内蒙古自治区呼和浩特市内蒙古师范大学赛罕校区[010022]\",\"contact\":\"薛雨仑\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"13088488288\",\"postCode\":\"010022\"}',0,'[\"口味：偏干、偏湿、\",\"重量：咸口、\"]',600,'2018-08-29 21:28:23','2018-08-29 13:30:24','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY','201808291043554'),
	(4,'201808291332444',1,1,100,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"海淀区北京市北京市安宁庄东路18[100089]\",\"contact\":\"薛雨仑\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"13301051937\",\"postCode\":\"100089\"}',0,'[\"口味：偏干、偏湿、\",\"重量：偏湿、\"]',100,'2018-08-29 21:34:32','2018-08-29 13:32:44','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY','201808291043554'),
	(5,'201808291346074',0,1,100,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"海珠区广东省广州市新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：偏湿、\",\"重量：偏干、\"]',100,'2018-08-29 21:22:39','2018-08-29 13:46:07','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY','201808291043554'),
	(6,'201808291346454',0,2,200,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"海珠区广东省广州市新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：甜口、偏干、\",\"重量：偏干、\"]',200,'2018-08-29 13:46:45','2018-08-29 13:46:45','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(7,'201808291348344',0,2,200,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"海珠区广东省广州市新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：偏湿、\",\"重量：甜口、\"]',200,'2018-08-29 13:48:34','2018-08-29 13:48:34','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(8,'201808291352294',0,1,100,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"海珠区广东省广州市新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：咸口、甜口、偏干、偏湿、\",\"重量：偏干、\"]',100,'2018-08-29 13:52:29','2018-08-29 13:52:29','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(9,'201808291352474',0,1,100,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"海珠区广东省广州市新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：咸口、甜口、偏干、偏湿、\",\"重量：偏干、\"]',100,'2018-08-29 13:52:47','2018-08-29 13:52:47','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(10,'201808291353094',0,5,500,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"海珠区广东省广州市新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：咸口、\",\"重量：甜口、\"]',500,'2018-08-29 13:53:09','2018-08-29 13:53:09','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(11,'201808301032204',0,10,1000,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"广东省广州市海珠区新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"expressNumber\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：甜口、偏干、\",\"重量：甜口、\"]',1000,'2018-08-30 10:32:20','2018-08-30 10:32:20','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL),
	(12,'201808301123024',0,5,1200,0,'[]',4,'{\"@type\":\"mall.dog.entity.order.Express\",\"address\":\"广东省广州市海珠区新港中路397号[510000]\",\"contact\":\"张三\",\"current\":\"\",\"expect\":\"\",\"expressNumber\":\"\",\"name\":\"\",\"phone\":\"020-81167888\",\"postCode\":\"510000\"}',0,'[\"口味：偏干、\",\"重量：咸口、\"]',1200,'2018-08-30 11:23:02','2018-08-30 11:23:02','o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL);

/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `left` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `images` text NOT NULL COMMENT '图片集',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `description` text NOT NULL COMMENT '描述',
  `express` text NOT NULL COMMENT '快递简叙',
  `sendTime` text NOT NULL COMMENT '发货时间',
  `specials_extra` text NOT NULL COMMENT '规格提示',
  `specials` text NOT NULL COMMENT '规格',
  `infos` text NOT NULL COMMENT '补充信息',
  `questions` text NOT NULL COMMENT '常见问题',
  `detail` text NOT NULL COMMENT '详细信息',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `invite_price` float NOT NULL COMMENT '邀请好友减免多少钱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;

INSERT INTO `t_product` (`id`, `left`, `images`, `name`, `description`, `express`, `sendTime`, `specials_extra`, `specials`, `infos`, `questions`, `detail`, `is_delete`, `create_time`, `update_time`, `invite_price`)
VALUES
	(4,999,'[{\"@type\":\"mall.dog.entity.common.Image\",\"height\":5F,\"key\":\"0\",\"url\":\"http://r.devdylan.cn/1516547518539.jpg\",\"width\":5F},{\"@type\":\"mall.dog.entity.common.Image\",\"height\":5F,\"key\":\"1\",\"url\":\"http://r.devdylan.cn/1516547565896.jpg\",\"width\":5F},{\"@type\":\"mall.dog.entity.common.Image\",\"height\":5F,\"key\":\"2\",\"url\":\"http://r.devdylan.cn/1516550608446.jpg\",\"width\":5F},{\"@type\":\"mall.dog.entity.common.Image\",\"height\":5F,\"key\":\"3\",\"url\":\"http://r.devdylan.cn/1516550639532.jpg\",\"width\":5F}]','成吉思汗军粮','来自内蒙古大草原的天然无污染牛肉干','中华速递、中通、圆通、EMS','8月15号全国统一发货','快点选择规格吧!','[{\"@type\":\"mall.dog.entity.common.Special\",\"extra\":\"多种口味选择，自动组合发货\",\"key\":\"口味\",\"price\":200F,\"type\":\"multip\",\"value\":[{\"name\":\"咸口\",\"price\":0F,\"select\":false},{\"name\":\"甜口\",\"price\":0F,\"select\":false},{\"name\":\"偏干\",\"price\":0F,\"select\":false},{\"name\":\"偏湿\",\"price\":0F,\"select\":false}]},{\"@type\":\"mall.dog.entity.common.Special\",\"extra\":\"8斤重，今日8折\",\"key\":\"重量\",\"price\":100F,\"type\":\"single\",\"value\":[{\"name\":\"咸口\",\"price\":40F,\"select\":false},{\"name\":\"甜口\",\"price\":50F,\"select\":false},{\"name\":\"偏干\",\"price\":60F,\"select\":false},{\"name\":\"偏湿\",\"price\":80F,\"select\":false}]}]','[{\"@type\":\"mall.dog.entity.common.KeyValue\",\"key\":\"重量\",\"value\":\"5两、1斤、、2斤、5斤\"},{\"@type\":\"mall.dog.entity.common.KeyValue\",\"key\":\"包装\",\"value\":\"统一真空包装\"},{\"@type\":\"mall.dog.entity.common.KeyValue\",\"key\":\"储藏\",\"value\":\"冷藏，开封后请尽快食用\"},{\"@type\":\"mall.dog.entity.common.KeyValue\",\"key\":\"用量\",\"value\":\"老人、小孩请控制食量，过多对肠胃不好\"}]','[{\"@type\":\"mall.dog.entity.common.Question\",\"anwser\":\"单笔订单金额满108免邮费，不满108元按照正常标准收取邮费。\",\"key\":\"0\",\"question\":\"购买运费如何收取?\"},{\"@type\":\"mall.dog.entity.common.Question\",\"anwser\":\"默认使用顺丰速递，部分城市使用圆通、中通、EMS等快递，有加急需求的宝宝们请联系客服（全球可达）。\",\"key\":\"1\",\"question\":\"使用什么快递发货?\"},{\"@type\":\"mall.dog.entity.common.Question\",\"anwser\":\"订单生成后会弹出客服微信，请添加客服然后进行下单。\",\"key\":\"2\",\"question\":\"如何付款?\"}]','eyJAdHlwZSI6Im1hbGwuZG9nLmVudGl0eS5wcm9kdWN0LlByb2R1Y3REZXRhaWwiLCJpbWFnZXMiOlt7ImhlaWdodCI6NUYsImtleSI6IjAiLCJ1cmwiOiJodHRwOi8vci5kZXZkeWxhbi5jbi8xNTE2NTQ3NTE4NTM5LmpwZyIsIndpZHRoIjo1Rn0seyJoZWlnaHQiOjVGLCJrZXkiOiIxIiwidXJsIjoiaHR0cDovL3IuZGV2ZHlsYW4uY24vMTUxNjU0NzU2NTg5Ni5qcGciLCJ3aWR0aCI6NUZ9LHsiaGVpZ2h0Ijo1Riwia2V5IjoiMiIsInVybCI6Imh0dHA6Ly9yLmRldmR5bGFuLmNuLzE1MTY1NTA2MDg0NDYuanBnIiwid2lkdGgiOjVGfSx7ImhlaWdodCI6NUYsImtleSI6IjMiLCJ1cmwiOiJodHRwOi8vci5kZXZkeWxhbi5jbi8xNTE2NTUwNjM5NTMyLmpwZyIsIndpZHRoIjo1Rn1dLCJyaWNoIjoiPGgxIGlkPVwiaDEtZWRpdG9yLW1kXCI+PGEgbmFtZT1cIkVkaXRvci5tZFwiIGNsYXNzPVwicmVmZXJlbmNlLWxpbmtcIj48L2E+PHNwYW4gY2xhc3M9XCJoZWFkZXItbGluayBvY3RpY29uIG9jdGljb24tbGlua1wiPjwvc3Bhbj5FZGl0b3IubWQ8L2gxPjxwPjxpbWcgc3JjPVwiaHR0cHM6Ly9wYW5kYW8uZ2l0aHViLmlvL2VkaXRvci5tZC9pbWFnZXMvbG9nb3MvZWRpdG9ybWQtbG9nby0xODB4MTgwLnBuZ1wiIGFsdD1cIlwiPlxuPHA+PGltZyBzcmM9XCJodHRwczovL2ltZy5zaGllbGRzLmlvL2dpdGh1Yi9zdGFycy9wYW5kYW8vZWRpdG9yLm1kLnN2Z1wiIGFsdD1cIlwiPiA8aW1nIHNyYz1cImh0dHBzOi8vaW1nLnNoaWVsZHMuaW8vZ2l0aHViL2ZvcmtzL3BhbmRhby9lZGl0b3IubWQuc3ZnXCIgYWx0PVwiXCI+IDxpbWcgc3JjPVwiaHR0cHM6Ly9pbWcuc2hpZWxkcy5pby9naXRodWIvdGFnL3BhbmRhby9lZGl0b3IubWQuc3ZnXCIgYWx0PVwiXCI+IDxpbWcgc3JjPVwiaHR0cHM6Ly9pbWcuc2hpZWxkcy5pby9naXRodWIvcmVsZWFzZS9wYW5kYW8vZWRpdG9yLm1kLnN2Z1wiIGFsdD1cIlwiPiA8aW1nIHNyYz1cImh0dHBzOi8vaW1nLnNoaWVsZHMuaW8vZ2l0aHViL2lzc3Vlcy9wYW5kYW8vZWRpdG9yLm1kLnN2Z1wiIGFsdD1cIlwiPiA8aW1nIHNyYz1cImh0dHBzOi8vaW1nLnNoaWVsZHMuaW8vYm93ZXIvdi9lZGl0b3IubWQuc3ZnXCIgYWx0PVwiXCI+XG48cD48c3Ryb25nPuebruW9lSAoVGFibGUgb2YgQ29udGVudHMpPC9zdHJvbmc+PC9wPlxuPGRpdiBjbGFzcz1cImVkaXRvcm1kLXRvYy1tZW51XCI+PGRpdiBjbGFzcz1cIm1hcmtkb3duLXRvYyBlZGl0b3JtZC1tYXJrZG93bi10b2NcIj5bVE9DTV08L2Rpdj48L2Rpdj48YnIvPjxkaXYgY2xhc3M9XCJtYXJrZG93bi10b2MgZWRpdG9ybWQtbWFya2Rvd24tdG9jXCI+W1RPQ108L2Rpdj48aDEgaWQ9XCJoMS1oZWFkaW5nLTFcIj48YSBuYW1lPVwiSGVhZGluZyAxXCIgY2xhc3M9XCJyZWZlcmVuY2UtbGlua1wiPjwvYT48c3BhbiBjbGFzcz1cImhlYWRlci1saW5rIG9jdGljb24gb2N0aWNvbi1saW5rXCI+PC9zcGFuPkhlYWRpbmcgMTwvaDE+PGgyIGlkPVwiaDItaGVhZGluZy0yXCI+PGEgbmFtZT1cIkhlYWRpbmcgMlwiIGNsYXNzPVwicmVmZXJlbmNlLWxpbmtcIj48L2E+PHNwYW4gY2xhc3M9XCJoZWFkZXItbGluayBvY3RpY29uIG9jdGljb24tbGlua1wiPjwvc3Bhbj5IZWFkaW5nIDI8L2gyPjxoMyBpZD1cImgzLWhlYWRpbmctM1wiPjxhIG5hbWU9XCJIZWFkaW5nIDNcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+SGVhZGluZyAzPC9oMz48aDQgaWQ9XCJoNC1oZWFkaW5nLTRcIj48YSBuYW1lPVwiSGVhZGluZyA0XCIgY2xhc3M9XCJyZWZlcmVuY2UtbGlua1wiPjwvYT48c3BhbiBjbGFzcz1cImhlYWRlci1saW5rIG9jdGljb24gb2N0aWNvbi1saW5rXCI+PC9zcGFuPkhlYWRpbmcgNDwvaDQ+PGg1IGlkPVwiaDUtaGVhZGluZy01XCI+PGEgbmFtZT1cIkhlYWRpbmcgNVwiIGNsYXNzPVwicmVmZXJlbmNlLWxpbmtcIj48L2E+PHNwYW4gY2xhc3M9XCJoZWFkZXItbGluayBvY3RpY29uIG9jdGljb24tbGlua1wiPjwvc3Bhbj5IZWFkaW5nIDU8L2g1PjxoNiBpZD1cImg2LWhlYWRpbmctNlwiPjxhIG5hbWU9XCJIZWFkaW5nIDZcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+SGVhZGluZyA2PC9oNj48aDEgaWQ9XCJoMS1oZWFkaW5nLTEtbGluay1oZWFkaW5nLWxpbmtcIj48YSBuYW1lPVwiSGVhZGluZyAxIGxpbmsgICBIZWFkaW5nIGxpbmtcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+SGVhZGluZyAxIGxpbmsgPGEgaHJlZj1cImh0dHBzOi8vZ2l0aHViLmNvbS9wYW5kYW8vZWRpdG9yLm1kXCIgdGl0bGU9XCJIZWFkaW5nIGxpbmtcIj5IZWFkaW5nIGxpbms8L2E+PC9oMT48aDIgaWQ9XCJoMi1oZWFkaW5nLTItbGluay1oZWFkaW5nLWxpbmtcIj48YSBuYW1lPVwiSGVhZGluZyAyIGxpbmsgICBIZWFkaW5nIGxpbmtcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+SGVhZGluZyAyIGxpbmsgPGEgaHJlZj1cImh0dHBzOi8vZ2l0aHViLmNvbS9wYW5kYW8vZWRpdG9yLm1kXCIgdGl0bGU9XCJIZWFkaW5nIGxpbmtcIj5IZWFkaW5nIGxpbms8L2E+PC9oMj48aDMgaWQ9XCJoMy1oZWFkaW5nLTMtbGluay1oZWFkaW5nLWxpbmtcIj48YSBuYW1lPVwiSGVhZGluZyAzIGxpbmsgICBIZWFkaW5nIGxpbmtcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+SGVhZGluZyAzIGxpbmsgPGEgaHJlZj1cImh0dHBzOi8vZ2l0aHViLmNvbS9wYW5kYW8vZWRpdG9yLm1kXCIgdGl0bGU9XCJIZWFkaW5nIGxpbmtcIj5IZWFkaW5nIGxpbms8L2E+PC9oMz48aDQgaWQ9XCJoNC1oZWFkaW5nLTQtbGluay1oZWFkaW5nLWxpbmstaGVhZGluZy1saW5rLWhlYWRpbmctbGlua1wiPjxhIG5hbWU9XCJIZWFkaW5nIDQgbGluayAgIEhlYWRpbmcgbGluayAgSGVhZGluZyBsaW5rICAgSGVhZGluZyBsaW5rXCIgY2xhc3M9XCJyZWZlcmVuY2UtbGlua1wiPjwvYT48c3BhbiBjbGFzcz1cImhlYWRlci1saW5rIG9jdGljb24gb2N0aWNvbi1saW5rXCI+PC9zcGFuPkhlYWRpbmcgNCBsaW5rIDxhIGhyZWY9XCJodHRwczovL2dpdGh1Yi5jb20vcGFuZGFvL2VkaXRvci5tZFwiIHRpdGxlPVwiSGVhZGluZyBsaW5rXCI+SGVhZGluZyBsaW5rPC9hPiBIZWFkaW5nIGxpbmsgPGEgaHJlZj1cImh0dHBzOi8vZ2l0aHViLmNvbS9wYW5kYW8vZWRpdG9yLm1kXCIgdGl0bGU9XCJIZWFkaW5nIGxpbmtcIj5IZWFkaW5nIGxpbms8L2E+PC9oND48aDUgaWQ9XCJoNS1oZWFkaW5nLTUtbGluay1oZWFkaW5nLWxpbmtcIj48YSBuYW1lPVwiSGVhZGluZyA1IGxpbmsgICBIZWFkaW5nIGxpbmtcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+SGVhZGluZyA1IGxpbmsgPGEgaHJlZj1cImh0dHBzOi8vZ2l0aHViLmNvbS9wYW5kYW8vZWRpdG9yLm1kXCIgdGl0bGU9XCJIZWFkaW5nIGxpbmtcIj5IZWFkaW5nIGxpbms8L2E+PC9oNT48aDYgaWQ9XCJoNi1oZWFkaW5nLTYtbGluay1oZWFkaW5nLWxpbmtcIj48YSBuYW1lPVwiSGVhZGluZyA2IGxpbmsgICBIZWFkaW5nIGxpbmtcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+SGVhZGluZyA2IGxpbmsgPGEgaHJlZj1cImh0dHBzOi8vZ2l0aHViLmNvbS9wYW5kYW8vZWRpdG9yLm1kXCIgdGl0bGU9XCJIZWFkaW5nIGxpbmtcIj5IZWFkaW5nIGxpbms8L2E+PC9oNj48aDQgaWQ9XCJoNC0taGVhZGluZy11bmRlcmxpbmUtXCI+PGEgbmFtZT1cIuagh+mimO+8iOeUqOW6lee6v+eahOW9ouW8j++8iUhlYWRpbmcgKHVuZGVybGluZSlcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+5qCH6aKY77yI55So5bqV57q/55qE5b2i5byP77yJSGVhZGluZyAodW5kZXJsaW5lKTwvaDQ+PGgxIGlkPVwiaDEtdGhpcy1pcy1hbi1oMVwiPjxhIG5hbWU9XCJUaGlzIGlzIGFuIEgxXCIgY2xhc3M9XCJyZWZlcmVuY2UtbGlua1wiPjwvYT48c3BhbiBjbGFzcz1cImhlYWRlci1saW5rIG9jdGljb24gb2N0aWNvbi1saW5rXCI+PC9zcGFuPlRoaXMgaXMgYW4gSDE8L2gxPjxoMiBpZD1cImgyLXRoaXMtaXMtYW4taDJcIj48YSBuYW1lPVwiVGhpcyBpcyBhbiBIMlwiIGNsYXNzPVwicmVmZXJlbmNlLWxpbmtcIj48L2E+PHNwYW4gY2xhc3M9XCJoZWFkZXItbGluayBvY3RpY29uIG9jdGljb24tbGlua1wiPjwvc3Bhbj5UaGlzIGlzIGFuIEgyPC9oMj48aDMgaWQ9XCJoMy11NUI1N3U3QjI2dTY1NDh1Njc5Q3U1NDhDdTZBMkF1N0VCRnU3QjQ5XCI+PGEgbmFtZT1cIuWtl+espuaViOaenOWSjOaoque6v+etiVwiIGNsYXNzPVwicmVmZXJlbmNlLWxpbmtcIj48L2E+PHNwYW4gY2xhc3M9XCJoZWFkZXItbGluayBvY3RpY29uIG9jdGljb24tbGlua1wiPjwvc3Bhbj7lrZfnrKbmlYjmnpzlkozmqKrnur/nrYk8L2gzPjxocj5cbjxwPjxkZWw+5Yig6Zmk57q/PC9kZWw+IDxzPuWIoOmZpOe6v++8iOW8gOWQr+ivhuWIq0hUTUzmoIfnrb7ml7bvvIk8L3M+PGJyPjxlbT7mlpzkvZPlrZc8L2VtPiAgICAgIDxlbT7mlpzkvZPlrZc8L2VtPjxicj48c3Ryb25nPueyl+S9kzwvc3Ryb25nPiAgPHN0cm9uZz7nspfkvZM8L3N0cm9uZz48YnI+PHN0cm9uZz48ZW0+57KX5pac5L2TPC9lbT48L3N0cm9uZz4gPHN0cm9uZz48ZW0+57KX5pac5L2TPC9lbT48L3N0cm9uZz48L3A+XG48cD7kuIrmoIfvvJpYPHN1Yj4yPC9zdWI+77yM5LiL5qCH77yaTzxzdXA+Mjwvc3VwPjwvcD5cbjxwPjxzdHJvbmc+57yp5YaZKOWQjEhUTUznmoRhYmJy5qCH562+KTwvc3Ryb25nPjwvcD5cbjxibG9ja3F1b3RlPlxuPHA+5Y2z5pu06ZW/55qE5Y2V6K+N5oiW55+t6K+t55qE57yp5YaZ5b2i5byP77yM5YmN5o+Q5piv5byA5ZCv6K+G5YirSFRNTOagh+etvuaXtu+8jOW3sum7mOiupOW8gOWQrzwvcD5cbjwvYmxvY2txdW90ZT5cbjxwPlRoZSA8YWJiciB0aXRsZT1cIkh5cGVyIFRleHQgTWFya3VwIExhbmd1YWdlXCI+SFRNTDwvYWJicj4gc3BlY2lmaWNhdGlvbiBpcyBtYWludGFpbmVkIGJ5IHRoZSA8YWJiciB0aXRsZT1cIldvcmxkIFdpZGUgV2ViIENvbnNvcnRpdW1cIj5XM0M8L2FiYnI+LjwvcD5cbjxoMyBpZD1cImgzLS1ibG9ja3F1b3Rlc1wiPjxhIG5hbWU9XCLlvJXnlKggQmxvY2txdW90ZXNcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+5byV55SoIEJsb2NrcXVvdGVzPC9oMz48YmxvY2txdW90ZT5cbjxwPuW8leeUqOaWh+acrCBCbG9ja3F1b3RlczwvcD5cbjwvYmxvY2txdW90ZT5cbjxwPuW8leeUqOeahOihjOWGhea3t+WQiCBCbG9ja3F1b3RlczwvcD5cbjxibG9ja3F1b3RlPlxuPHA+5byV55So77ya5aaC5p6c5oOz6KaB5o+S5YWl56m655m95o2i6KGMPGNvZGU+5Y2zJmx0O2JyIC8mZ3Q75qCH562+PC9jb2RlPu+8jOWcqOaPkuWFpeWkhOWFiOmUruWFpeS4pOS4quS7peS4iueahOepuuagvOeEtuWQjuWbnui9puWNs+WPr++8jDxhIGhyZWY9XCJodHRwOi8vbG9jYWxob3N0L1wiPuaZrumAmumTvuaOpTwvYT7jgII8L3A+XG48L2Jsb2NrcXVvdGU+XG48aDMgaWQ9XCJoMy0tbGlua3NcIj48YSBuYW1lPVwi6ZSa54K55LiO6ZO+5o6lIExpbmtzXCIgY2xhc3M9XCJyZWZlcmVuY2UtbGlua1wiPjwvYT48c3BhbiBjbGFzcz1cImhlYWRlci1saW5rIG9jdGljb24gb2N0aWNvbi1saW5rXCI+PC9zcGFuPumUmueCueS4jumTvuaOpSBMaW5rczwvaDM+PHA+PGEgaHJlZj1cImh0dHA6Ly9sb2NhbGhvc3QvXCI+5pmu6YCa6ZO+5o6lPC9hPjwvcD5cbjxwPjxhIGhyZWY9XCJodHRwOi8vbG9jYWxob3N0L1wiIHRpdGxlPVwi5pmu6YCa6ZO+5o6l5bim5qCH6aKYXCI+5pmu6YCa6ZO+5o6l5bim5qCH6aKYPC9hPjwvcD5cbjxwPuebtOaOpemTvuaOpe+8mjxhIGhyZWY9XCJodHRwczovL2dpdGh1Yi5jb21cIj5odHRwczovL2dpdGh1Yi5jb208L2E+PC9wPlxuPHA+PGEgaHJlZj1cImh0dHA6Ly93d3cudGhpcy1hbmNob3ItbGluay5jb20vXCI+6ZSa54K56ZO+5o6lPC9hPiA8L3A+XG48cD48YSBocmVmPVwibWFpbHRvOnRlc3QudGVzdEBnbWFpbC5jb21cIj5tYWlsdG86dGVzdC50ZXN0QGdtYWlsLmNvbTwvYT48L3A+XG48cD5HRk0gYS10YWlsIGxpbmsgPGEgaHJlZj1cImh0dHBzOi8vZ2l0aHViLmNvbS9wYW5kYW9cIiB0aXRsZT1cIkBwYW5kYW9cIiBjbGFzcz1cImF0LWxpbmtcIj5AcGFuZGFvPC9hPiAg6YKu566x5Zyw5Z2A6Ieq5Yqo6ZO+5o6lIDxhIGhyZWY9XCJtYWlsdG86dGVzdC50ZXN0QGdtYWlsLmNvbVwiPnRlc3QudGVzdEBnbWFpbC5jb208L2E+ICA8YSBocmVmPVwibWFpbHRvOnd3d0B2aXAucXEuY29tXCI+d3d3QHZpcC5xcS5jb208L2E+PC9wPlxuPGJsb2NrcXVvdGU+XG48cD48YSBocmVmPVwiaHR0cHM6Ly9naXRodWIuY29tL3BhbmRhb1wiIHRpdGxlPVwiQHBhbmRhb1wiIGNsYXNzPVwiYXQtbGlua1wiPkBwYW5kYW88L2E+PC9wPlxuPC9ibG9ja3F1b3RlPlxuPGgzIGlkPVwiaDMtLWNvZGVzXCI+PGEgbmFtZT1cIuWkmuivreiogOS7o+eggemrmOS6riBDb2Rlc1wiIGNsYXNzPVwicmVmZXJlbmNlLWxpbmtcIj48L2E+PHNwYW4gY2xhc3M9XCJoZWFkZXItbGluayBvY3RpY29uIG9jdGljb24tbGlua1wiPjwvc3Bhbj7lpJror63oqIDku6PnoIHpq5jkuq4gQ29kZXM8L2gzPjxoNCBpZD1cImg0LS1pbmxpbmUtY29kZVwiPjxhIG5hbWU9XCLooYzlhoXku6PnoIEgSW5saW5lIGNvZGVcIiBjbGFzcz1cInJlZmVyZW5jZS1saW5rXCI+PC9hPjxzcGFuIGNsYXNzPVwiaGVhZGVyLWxpbmsgb2N0aWNvbiBvY3RpY29uLWxpbmtcIj48L3NwYW4+6KGM5YaF5Luj56CBIElubGluZSBjb2RlPC9oND48cD7miafooYzlkb3ku6TvvJo8Y29kZT5ucG0gaW5zdGFsbCBtYXJrZWQ8L2NvZGU+PC9wPlxuPGg0IGlkPVwiaDQtdTdGMjl1OEZEQnU5OENFdTY4M0NcIj48YSBuYW1lPVwi57yp6L+b6aOO5qC8XCIgY2xhc3M9XCJyZWZlcmVuY2UtbGlua1wiPjwvYT48c3BhbiBjbGFzcz1cImhlYWRlci1saW5rIG9jdGljb24gb2N0aWNvbi1saW5rXCI+PC9zcGFuPue8qei/m+mjjuagvDwvaDQ+PHA+5Y2z57yp6L+b5Zub5Liq56m65qC877yM5Lmf5YGa5Li65a6e546w57G75Ly8IDxjb2RlPiZsdDtwcmUmZ3Q7PC9jb2RlPiDpooTmoLzlvI/ljJbmlofmnKwgKCBQcmVmb3JtYXR0ZWQgVGV4dCApIOeahOWKn+iDveOAgjwvcD5cbjxwcmU+PGNvZGU+Jmx0Oz9waHBcbiAgICBlY2hvIFwiSGVsbG8gd29ybGQhXCI7XG4/Jmd0O1xuPC9jb2RlPjwvcHJlPjxwPumihOagvOW8j+WMluaWh+acrO+8mjwvcD5cbjxwcmU+PGNvZGU+fCBGaXJzdCBIZWFkZXIgIHwgU2Vjb25kIEhlYWRlciB8XG58IC0tLS0tLS0tLS0tLS0gfCAtLS0tLS0tLS0tLS0tIHxcbnwgQ29udGVudCBDZWxsICB8IENvbnRlbnQgQ2VsbCAgfFxufCBDb250ZW50IENlbGwgIHwgQ29udGVudCBDZWxsICB8XG48L2NvZGU+PC9wcmU+In0=',0,'2018-08-28 19:37:49','2018-08-30 11:21:57',100);

/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `open_id` varchar(255) NOT NULL DEFAULT '',
  `union_id` varchar(255) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `city` varchar(64) DEFAULT '宇宙市',
  `country` varchar(64) DEFAULT '宇宙国',
  `gender` tinyint(1) DEFAULT '1',
  `language` varchar(64) DEFAULT '外语',
  `nick_name` varchar(255) DEFAULT '外星人',
  `province` varchar(64) DEFAULT '宇宙省',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;

INSERT INTO `t_user` (`open_id`, `union_id`, `avatar_url`, `city`, `country`, `gender`, `language`, `nick_name`, `province`, `create_time`, `update_time`)
VALUES
	('o-Phr5ZqGJBGx9lPKbPZAN9HJjHY',NULL,'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKZ2fnNqAUVhFBxY15KcCHOk93zsefiaqMqrfwC2dO3iamlJzcR6ibyTpoGFia0WhAuWSDtqdazia2tiaEw/132','Hohhot','China',1,'zh_CN','dylan','Inner Mongolia','2018-08-30 12:15:57','2018-08-30 12:19:07');

/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
