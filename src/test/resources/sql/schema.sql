-- --------------------------------------------------------
-- 主机:                           192.168.1.100
-- 服务器版本:                        5.7.4-m14 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 wuxian.checkout 结构
CREATE TABLE IF NOT EXISTS `checkout` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `price` float(11,2) NOT NULL COMMENT '总价',
  `createTime` date NOT NULL COMMENT '结账时间',
  `deskNo` int(11) DEFAULT NULL COMMENT '桌号',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.checkout 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `checkout` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkout` ENABLE KEYS */;


-- 导出  表 wuxian.company 结构
CREATE TABLE IF NOT EXISTS `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '品商名称',
  `address` text NOT NULL COMMENT '地址',
  `company_log` text COMMENT '公司log',
  `company_photo` text COMMENT '公司照片',
  `qr_code` text NOT NULL COMMENT '二维码地址',
  `create_time` date NOT NULL COMMENT '创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.company 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;


-- 导出  表 wuxian.desk 结构
CREATE TABLE IF NOT EXISTS `desk` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '桌的ID编号',
  `deskNo` int(11) DEFAULT NULL COMMENT '桌号',
  `deskName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '桌号名',
  `bookMark` int(11) DEFAULT NULL COMMENT '是否被订 1未订 2已定 3就餐',
  `type` int(11) DEFAULT NULL COMMENT '楼层 1大厅 2 二楼 3 三楼',
  `description` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '描述',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.desk 的数据：~34 rows (大约)
/*!40000 ALTER TABLE `desk` DISABLE KEYS */;
INSERT INTO `desk` (`id`, `deskNo`, `deskName`, `bookMark`, `type`, `description`) VALUES
	(1, 1, '一号桌', 1, 1, '大厅一号桌'),
	(2, 2, '二号桌', 1, 1, '大厅二号桌'),
	(3, 3, '三号桌', 1, 1, '大厅三号桌'),
	(4, 4, '四号桌', 1, 1, '大厅四号桌'),
	(5, 5, '五号桌', 1, 1, '大厅五号桌'),
	(6, 6, '六号桌', 1, 1, '大厅六号桌'),
	(7, 7, '七号桌', 1, 1, '大厅七号桌'),
	(8, 8, '八号桌', 1, 1, '大厅八号桌'),
	(9, 9, '九号桌', 1, 1, '大厅九号桌'),
	(10, 10, '九号桌', 1, 1, NULL),
	(11, 11, '九号桌', 2, 1, NULL),
	(12, 12, '九号桌', 1, 1, NULL),
	(13, 13, '九号桌', 1, 1, NULL),
	(14, 14, '九号桌', 1, 1, NULL),
	(15, 15, '九号桌', 1, 1, NULL),
	(16, 16, '九号桌', 1, 1, NULL),
	(17, 17, '九号桌', 1, 1, NULL),
	(18, 18, '九号桌', 1, 1, NULL),
	(19, 19, '九号桌', 1, 1, NULL),
	(20, 20, '九号桌', 1, 1, NULL),
	(21, 21, '九号桌', 1, 1, NULL),
	(22, 1, '一号桌', 1, 2, '二楼一号桌'),
	(23, 2, '二号桌', 1, 2, '二楼二号桌'),
	(24, 3, '三号桌', 1, 2, '二楼三号桌'),
	(25, 4, '四号桌', 1, 2, '二楼四号桌'),
	(26, 5, '五号桌', 1, 2, '二楼五号桌'),
	(27, 6, '六号桌', 1, 2, '二楼六号桌'),
	(28, 7, '七号桌', 1, 2, '二楼七号桌'),
	(29, 8, '八号桌', 1, 2, '二楼八号桌'),
	(30, 9, '九号桌', 1, 2, '二楼九号桌'),
	(31, 10, '十号桌', 1, 2, NULL),
	(32, 11, '十一桌', 1, 2, 'undefined'),
	(33, 12, '十二桌', 1, 2, 'undefined'),
	(39, 13, '十三桌', 1, 2, '二楼十三桌'),
	(40, 14, '十四桌', 1, 2, '二楼十四桌');
/*!40000 ALTER TABLE `desk` ENABLE KEYS */;


-- 导出  表 wuxian.employee 结构
CREATE TABLE IF NOT EXISTS `employee` (
  `waiterId` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `waiterName` varchar(30) NOT NULL COMMENT '员工姓名',
  `waiterPassword` int(11) NOT NULL COMMENT '员工密码',
  KEY `waiterId` (`waiterId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.employee 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`waiterId`, `waiterName`, `waiterPassword`) VALUES
	(1, 'zhansan', 123456),
	(2, 'admin', 123456),
	(3, '李四', 123456);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- 导出  表 wuxian.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品名称',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '商品类型 1特色 2主食 3热菜 4凉菜 5酒水 6饮料 7甜点',
  `phto` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品图片地址',
  `introduce` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '商品介绍',
  `price` double NOT NULL COMMENT '商品价格',
  `description` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '商品描述',
  `create_time` date NOT NULL COMMENT '商品创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 CHECKSUM=1 ROW_FORMAT=COMPACT COMMENT='商品信息表';

-- 正在导出表  wuxian.goods 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`, `name`, `type`, `phto`, `introduce`, `price`, `description`, `create_time`) VALUES
	(31, '咕噜肉', 2, 'glr.jpg', '主料：去皮五花猪肉500克，熟鲜', 30, '\r\n\r\n1.将猪肉切成切成菱形块，肉块用精盐，汾酒拌匀，腌约15分钟，加入鸡蛋液和湿淀粉拌匀，在粘上干淀粉.\r\n\r\n2.炒锅放由烧至六成热，把肉炸至五成熟，倒入漏勺沥油。\r\n\r\n3、留油少许，投入葱蒜，辣椒爆出香味加葱，番茄酱烧至微沸，用湿淀粉调稀勾芡，随即倒入肉块和笋块拌炒，搓淋入麻油和花生油炒匀即可', '2014-12-30'),
	(32, '糖醋里脊', 3, 'tclj.jpg', 'dfjsfgj', 32, 'rujeftkyyt', '2014-12-30'),
	(33, '蜂蜜蛋糕', 1, 'fmdg.jpg', 'dafhsf', 7, 'gfjsfgkdghk', '2014-12-30'),
	(34, '奶茶', 5, 'nc.jpg', 'dfhsfgj', 6, 'ertjfkjgh', '2014-12-30'),
	(36, '凉拌黄瓜', 4, 'lbhg.jpg', 'dffdgj', 10, 'dafjsfgkgh', '2014-12-30'),
	(37, '奶白鲫鱼汤', 3, 'lbjyt.jpg', 'adffjd', 12, 'aerjfskdghk', '2014-12-30'),
	(38, '冻青柠鸡尾酒', 5, 'jwj.jpg', 'afdhsfdh', 8, 'sfdkghlfhj', '2014-12-30'),
	(39, '糖醋鱼块', 3, 'tcy.jpg', 'shsdfgf', 35, 'dajfdkgk', '2014-12-30'),
	(40, '宫保鸡丁', 3, 'gbjd.jpg', 'adffsj', 20, 'djdkgjhg', '2014-12-30');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


-- 导出  表 wuxian.goodsintroduce 结构
CREATE TABLE IF NOT EXISTS `goodsintroduce` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goodsName` varchar(100) NOT NULL COMMENT '商品名称',
  `introduce` text COMMENT '商品介绍',
  `price` float(11,2) NOT NULL COMMENT '商品价格',
  `description` text COMMENT '商品描述',
  KEY `goodsId` (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.goodsintroduce 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goodsintroduce` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsintroduce` ENABLE KEYS */;


-- 导出  表 wuxian.goodsphoto 结构
CREATE TABLE IF NOT EXISTS `goodsphoto` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goodsName` varchar(30) NOT NULL COMMENT '商品名称',
  `photo` text NOT NULL COMMENT '商品图片',
  KEY `goodsId` (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.goodsphoto 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goodsphoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsphoto` ENABLE KEYS */;


-- 导出  表 wuxian.log 结构
CREATE TABLE IF NOT EXISTS `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goodsId` int(11) NOT NULL COMMENT '商品ID',
  `orderId` int(11) NOT NULL COMMENT '我的订单ID',
  `deskNum` int(11) NOT NULL COMMENT '桌位号',
  `checkOutPrice` float(11,2) NOT NULL COMMENT '结账价格',
  `createTime` date NOT NULL COMMENT '创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;


-- 导出  表 wuxian.myorder 结构
CREATE TABLE IF NOT EXISTS `myorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '我的订单ID',
  `orderId` int(11) DEFAULT NULL COMMENT '开台ID',
  `goodsIds` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各商品ID',
  `goodsNames` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各商品名称',
  `goodsQtys` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各选定商品数量',
  `goodsNum` int(11) DEFAULT '0' COMMENT '商品总数量',
  `price` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各商品价格 ',
  `totalPrice` double DEFAULT '0' COMMENT '总价格',
  `createDate` date DEFAULT NULL COMMENT '我的订单创建的时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8 COMMENT='用户订单信息表';

-- 正在导出表  wuxian.myorder 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `myorder` DISABLE KEYS */;
INSERT INTO `myorder` (`id`, `orderId`, `goodsIds`, `goodsNames`, `goodsQtys`, `goodsNum`, `price`, `totalPrice`, `createDate`) VALUES
	(253, 21, '37,34,32,', '奶白鲫鱼汤,奶茶,糖醋里脊,', '1,1,1,', 3, '12.0,6.0,32.0,', 50, '2014-12-31'),
	(254, 22, '31,33,', '咕噜肉,蜂蜜蛋糕,', '1,1,', 2, '30.0,7.0,', 37, '2014-12-31');
/*!40000 ALTER TABLE `myorder` ENABLE KEYS */;


-- 导出  表 wuxian.ordertable 结构
CREATE TABLE IF NOT EXISTS `ordertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '开台ID号',
  `orderId` int(11) NOT NULL COMMENT '顾客订单号',
  `deskNo` int(11) NOT NULL COMMENT '桌编号',
  `tel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '顾客电话',
  `waiterId` int(11) DEFAULT NULL COMMENT '服务员ID',
  `clientNo` int(11) DEFAULT NULL COMMENT '顾客人数',
  `payment` double DEFAULT NULL COMMENT '订金',
  `vip` int(11) DEFAULT NULL COMMENT 'vip 0否 1是',
  `checkOut` int(11) DEFAULT NULL COMMENT '是否结账 0代表否 1代表是',
  `remark` text COLLATE utf8_unicode_ci COMMENT '备注',
  `createTime` date DEFAULT NULL COMMENT '开台时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 COMMENT='后台开台记录表';

-- 正在导出表  wuxian.ordertable 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `ordertable` DISABLE KEYS */;
INSERT INTO `ordertable` (`id`, `orderId`, `deskNo`, `tel`, `waiterId`, `clientNo`, `payment`, `vip`, `checkOut`, `remark`, `createTime`) VALUES
	(21, 253, 5, NULL, 2, 2, 100, 1, 1, 'dsgdfh', '2014-12-31'),
	(22, 254, 11, NULL, 1, 1, 20, 1, 0, 'sdg', '2014-12-31');
/*!40000 ALTER TABLE `ordertable` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
