
DELETE TABLE 
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


-- 导出  表 wuxian.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顾客编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '顾客姓名',
  `sex` int(11) DEFAULT '0' COMMENT '性别:0男 1女',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `createTime` varchar(50) NOT NULL COMMENT '创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='顾客信息表';

-- 正在导出表  wuxian.customer 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `name`, `sex`, `age`, `tel`, `address`, `createTime`) VALUES
	(1, 'admin', 0, 20, '13936782890', 'dahjsfgjdhgkghk', '2015-03-22'),
	(2, 'zhangsan', 0, 19, '1300003456', 'dfhfjgdf', '2015-03-22'),
	(3, 'dsfh', 1, 30, '12345678', 'saghsdgfj', '2015-03-22'),
	(4, 'dfhfdgj', 1, 21, '123344645765876', 'shfjhgkdgh', '2015-03-22'),
	(5, 'zd', 1, 26, '139000000000', 'adhfsjfgj', '2015-03-22'),
	(6, 'dsf', 0, 32, '124436457568679', 'dsfjhdfkh', '2015-03-22'),
	(7, 'dfhf', 1, 22, '123464575687', 'fhfgjgj', '2015-03-22'),
	(8, '张三', 1, 22, '123246457568679', '高新区', '2015-03-22'),
	(9, '李四', 1, 12, '139000000000', '阿萨德的发挥', '2015-03-22 17:33:12'),
	(11, '王五', 1, 22, '139000000000', 'rkjglkhjlgkj', '2015-03-22 18:13:04');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


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

-- 正在导出表  wuxian.desk 的数据：~35 rows (大约)
/*!40000 ALTER TABLE `desk` DISABLE KEYS */;
INSERT INTO `desk` (`id`, `deskNo`, `deskName`, `bookMark`, `type`, `description`) VALUES
	(1, 1, '大厅一号桌', 2, 1, '大厅一号桌'),
	(2, 2, '大厅二号桌', 2, 1, '大厅二号桌'),
	(3, 3, '大厅三号桌', 2, 1, '大厅三号桌'),
	(4, 4, '大厅四号桌', 2, 1, '大厅四号桌'),
	(5, 5, '大厅五号桌', 3, 1, '大厅五号桌'),
	(6, 6, '大厅六号桌', 1, 1, '大厅六号桌'),
	(7, 7, '大厅七号桌', 1, 1, '大厅七号桌'),
	(8, 8, '大厅八号桌', 1, 1, '大厅八号桌'),
	(9, 9, '大厅九号桌', 1, 1, '大厅九号桌'),
	(10, 10, '大厅九号桌', 1, 1, NULL),
	(11, 11, '大厅九号桌', 1, 1, NULL),
	(12, 12, '大厅九号桌', 1, 1, NULL),
	(13, 13, '大厅九号桌', 1, 1, NULL),
	(14, 14, '大厅九号桌', 1, 1, NULL),
	(15, 15, '大厅九号桌', 1, 1, NULL),
	(16, 16, '大厅九号桌', 1, 1, NULL),
	(17, 17, '大厅九号桌', 1, 1, NULL),
	(18, 18, '大厅九号桌', 1, 1, NULL),
	(19, 19, '大厅九号桌', 1, 1, NULL),
	(20, 20, '大厅九号桌', 1, 1, NULL),
	(21, 21, '大厅九号桌', 1, 1, NULL),
	(22, 1, '二楼一号桌', 1, 2, '二楼一号桌'),
	(23, 2, '二楼二号桌', 1, 2, '二楼二号桌'),
	(24, 3, '二楼三号桌', 1, 2, '二楼三号桌'),
	(25, 4, '二楼四号桌', 1, 2, '二楼四号桌'),
	(26, 5, '二楼五号桌', 1, 2, '二楼五号桌'),
	(27, 6, '二楼六号桌', 1, 2, '二楼六号桌'),
	(28, 7, '二楼七号桌', 1, 2, '二楼七号桌'),
	(29, 8, '二楼八号桌', 1, 2, '二楼八号桌'),
	(30, 9, '二楼九号桌', 1, 2, '二楼九号桌'),
	(31, 10, '二楼十号桌', 1, 2, NULL),
	(32, 11, '二楼十一桌', 1, 2, 'undefined'),
	(33, 12, '二楼十二桌', 1, 2, 'undefined'),
	(39, 13, '二楼十三桌', 1, 2, '二楼十三桌'),
	(40, 14, '二楼十四桌', 1, 2, '二楼十四桌');
/*!40000 ALTER TABLE `desk` ENABLE KEYS */;


-- 导出  表 wuxian.employee 结构
CREATE TABLE IF NOT EXISTS `employee` (
  `waiterId` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `waiterName` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '员工姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别:0男 1女',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系地址',
  `deptNo` int(11) DEFAULT NULL COMMENT '部门编号',
  `auth` int(11) DEFAULT NULL COMMENT '员工权限',
  `waiterPassword` varchar(50) NOT NULL COMMENT '员工密码',
  `createTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '入职时间',
  KEY `waiterId` (`waiterId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  wuxian.employee 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`waiterId`, `waiterName`, `sex`, `age`, `tel`, `address`, `deptNo`, `auth`, `waiterPassword`, `createTime`) VALUES
	(1, 'zhansan', 0, 20, '', '', 0, 0, '123456', ''),
	(2, 'admin', 0, 30, '', '', 0, 0, '123456', ''),
	(3, '李四', 0, 15, '', '', 0, 0, '123456', ''),
	(4, '王五', 1, 21, '1392834200', 'dhfjdgj', 1, 3, '123456', '2015年3月23日'),
	(5, 'zd', 0, 25, '139000000000', 'adhfsjfgj', 4, 4, '123456', '2015-03-24 20:40:21');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- 导出  表 wuxian.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品名称',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '商品类型 1鱼类 2肉类 3素菜 4其他 5酒水 6饮料 7甜点',
  `phto` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品图片地址',
  `introduce` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '商品介绍',
  `price` double NOT NULL COMMENT '商品价格',
  `description` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '商品描述',
  `create_time` date DEFAULT NULL COMMENT '商品创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 CHECKSUM=1 ROW_FORMAT=COMPACT COMMENT='商品信息表';

-- 正在导出表  wuxian.goods 的数据：~39 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`, `name`, `type`, `phto`, `introduce`, `price`, `description`, `create_time`) VALUES
	(45, '秋刀鱼', 1, 'qiudaoyu.jpg', '秋刀鱼', 8, '秋刀鱼', '2015-01-27'),
	(46, '干鱿鱼', 1, 'ganyouyu.jpg', '干鱿鱼', 8, '干鱿鱼', '2015-01-27'),
	(47, '福寿鱼', 1, 'fushouyu.jpg', '福寿鱼', 15, '', '2015-01-27'),
	(48, '开心鱼', 1, 'kaixinyu.jpg', '', 4, '', '2015-01-27'),
	(49, '湿鱿鱼', 1, 'shiyouyu.jpg', '', 5, '', '2015-01-27'),
	(50, '鸡腿', 2, 'jitui.jpg', '', 6, '', '2015-01-27'),
	(51, '鸡翅', 2, 'jichi.jpg', '', 6, '', '2015-01-27'),
	(52, '鸡爪', 2, 'jizhua.jpg', '', 4, '', '2015-01-27'),
	(53, '鸡肾', 2, 'jisheng.jpg', '', 2, '', '2015-01-27'),
	(54, '骨肉相连', 2, 'grxl.jpg', '', 3, '', '2015-01-27'),
	(55, '鸡脆骨', 2, 'jcg.jpg', '', 2, '', '2015-01-27'),
	(56, '牛肉', 2, 'niurou.jpg', '', 2, '', '2015-01-27'),
	(57, '肥牛', 2, 'feiniu.jpg', '', 3, '', '2015-01-27'),
	(58, '羊肉', 2, 'yanrou.jpg', '', 2, '', '2015-01-27'),
	(59, '五花肉', 2, 'wuhuarou.jpg', '', 2, '', '2015-01-27'),
	(60, '茄子', 3, 'qiezi.jpg', '', 7, '', '2015-01-27'),
	(61, '玉米', 3, 'yumi.jpg', '', 7, '', '2015-01-27'),
	(62, '韭菜', 3, 'jiucai.jpg', '', 2, '', '2015-01-27'),
	(63, '娃娃菜', 3, 'wwc.jpg', '', 2, '', '2015-01-27'),
	(64, '香菇', 3, 'xianggu.jpg', '', 2, '', '2015-01-27'),
	(65, '豆角', 3, 'doujiao.jpg', '', 2, '', '2015-01-27'),
	(66, '金针菇', 3, 'jzg.jpg', '', 2, '', '2015-01-27'),
	(67, '土豆', 3, 'tudou.jpg', '', 2, '', '2015-01-27'),
	(68, '青椒', 3, 'qingjiao.jpg', '', 2, '', '2015-01-27'),
	(69, '腊肠', 2, 'nachang.jpg', '', 5, '', '2015-01-27'),
	(70, '年糕', 4, 'niangao.jpg', '', 3, '', '2015-01-27'),
	(71, '豆皮', 4, 'doupi.jpg', '', 3, '', '2015-01-27'),
	(72, '豆干', 4, 'dougan.jpg', '', 2, '', '2015-01-27'),
	(73, '豆腐', 4, 'doufu.jpg', '', 2, '', '2015-01-27'),
	(74, '牛筋', 2, 'niujing.jpg', '', 3, '', '2015-01-27'),
	(75, '面筋', 4, 'mianjin.jpg', '', 2, '', '2015-01-27'),
	(76, '热狗', 2, 'regou.jpg', '', 2, '', '2015-01-27'),
	(77, '馒头', 4, 'mantao.jpg', '', 2, '', '2015-01-27'),
	(78, '多春鱼', 1, 'duochunyu.jpg', '', 15, '', '2015-01-27'),
	(79, '百威', 5, 'baiwei.jpg', '', 8, '', '2015-01-27'),
	(80, '纯生罐装', 5, 'chunshengguan.jpg', '', 5, '', '2015-01-27'),
	(81, '青岛纯生', 5, 'qindaocunshen.jpg', '', 7, '', '2015-01-27'),
	(82, '王老吉', 5, 'wanglaoji.jpg', '', 5, '', '2015-01-27'),
	(83, '雪花', 5, 'xuehua.jpg', '', 7, '', '2015-01-27');
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


-- 导出  表 wuxian.goods_1 结构
CREATE TABLE IF NOT EXISTS `goods_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品名称',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '商品类型 1特色 2主食 3热菜 4凉菜 5酒水 6饮料 7甜点',
  `phto` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品图片地址',
  `introduce` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '商品介绍',
  `price` double NOT NULL COMMENT '商品价格',
  `description` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '商品描述',
  `create_time` date DEFAULT NULL COMMENT '商品创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 CHECKSUM=1 ROW_FORMAT=COMPACT COMMENT='商品信息表';

-- 正在导出表  wuxian.goods_1 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `goods_1` DISABLE KEYS */;
INSERT INTO `goods_1` (`id`, `name`, `type`, `phto`, `introduce`, `price`, `description`, `create_time`) VALUES
	(31, '咕噜肉', 2, 'glr.jpg', '主料：去皮五花猪肉500克，熟鲜', 30, '\r\n\r\n1.将猪肉切成切成菱形块，肉块用精盐，汾酒拌匀，腌约15分钟，加入鸡蛋液和湿淀粉拌匀，在粘上干淀粉.\r\n\r\n2.炒锅放由烧至六成热，把肉炸至五成熟，倒入漏勺沥油。\r\n\r\n3、留油少许，投入葱蒜，辣椒爆出香味加葱，番茄酱烧至微沸，用湿淀粉调稀勾芡，随即倒入肉块和笋块拌炒，搓淋入麻油和花生油炒匀即可', '2014-12-30'),
	(32, '糖醋里脊', 3, 'tclj.jpg', 'dfjsfgj', 32, 'rujeftkyyt', '2014-12-30'),
	(33, '蜂蜜蛋糕', 1, 'fmdg.jpg', 'dafhsf', 7, 'gfjsfgkdghk', '2014-12-30'),
	(34, '奶茶', 5, 'nc.jpg', 'dfhsfgj', 6, 'ertjfkjgh', '2014-12-30'),
	(36, '凉拌黄瓜', 4, 'lbhg.jpg', 'dffdgj', 10, 'dafjsfgkgh', '2014-12-30'),
	(37, '奶白鲫鱼汤', 3, 'lbjyt.jpg', 'adffjd', 12, 'aerjfskdghk', '2014-12-30'),
	(38, '冻青柠鸡尾酒', 5, 'jwj.jpg', 'afdhsfdh', 8, 'sfdkghlfhj', '2014-12-30'),
	(39, '糖醋鱼块', 3, 'tcy.jpg', 'shsdfgf', 35, 'dajfdkgk', '2014-12-30'),
	(40, '宫保鸡丁', 3, 'gbjd.jpg', 'adffsj', 20, 'djdkgjhg', '2014-12-30'),
	(41, '肉片炒白菜', 3, 'rcbc.jpg', '肉片炒白菜是个好简单的下饭菜，有肉有菜，有些辣但是好醒胃！', 8, '肉片炒白菜是个好简单的下饭菜，有肉有菜，有些辣但是好醒胃！', '2015-01-05'),
	(42, '秘制牛肉干', 1, 'nrg.jpg', '  牛肉5斤，葱姜，花椒，大料，辣椒碎，孜然，糖，红酒，酱油，适量的盐。', 20, '牛肉5斤，葱姜，花椒，大料，辣椒碎，孜然，糖，红酒，酱油，适量的盐。\r\n', '2015-01-07'),
	(43, '清水冬瓜汤', 3, 'dgt.jpg', ' 前两天，台风袭来，待在家不敢出门。冰箱快空了，突然有点“弹尽粮绝”的感觉。仅剩了一块冬瓜，想起以前妈妈常做的超强刮油清脂冬瓜汤，不禁欣喜起来：台风天气，宅在家里，偷偷减肥，呵——', 5, '\r\n前两天，台风袭来，待在家不敢出门。冰箱快空了，突然有点“弹尽粮绝”的感觉。仅剩了一块冬瓜，想起以前妈妈常做的超强刮油清脂冬瓜汤，不禁欣喜起来：台风天气，宅在家里，偷偷减肥，呵——', '2015-01-07'),
	(44, '鱼香茄子', 3, 'yxcz.jpg', '  主料：茄子一个（一人份）  调料：酱油 葱 姜蒜 料酒 米醋 生粉（加少许水勾兑备用） 泡红椒 白糖 植物油少许', 12, '\r\n\r\n主料：茄子一个（一人份）\r\n\r\n调料：酱油 葱 姜蒜 料酒 米醋 生粉（加少许水勾兑备用） 泡红椒 白糖 植物油少许\r\n', '2015-01-07');
/*!40000 ALTER TABLE `goods_1` ENABLE KEYS */;


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
  `id` varchar(50) NOT NULL COMMENT '我的订单ID',
  `orderId` varchar(50) DEFAULT NULL COMMENT '开台ID',
  `goodsIds` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各商品ID',
  `goodsNames` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各商品名称',
  `goodsQtys` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各选定商品数量',
  `goodsNum` int(11) DEFAULT '0' COMMENT '商品总数量',
  `price` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '各商品价格 ',
  `totalPrice` double DEFAULT '0' COMMENT '总价格',
  `createDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '我的订单创建的时间',
  `goodsTastes` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 1不辣 2微辣 3 辣 4无',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户订单信息表';

-- 正在导出表  wuxian.myorder 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `myorder` DISABLE KEYS */;
INSERT INTO `myorder` (`id`, `orderId`, `goodsIds`, `goodsNames`, `goodsQtys`, `goodsNum`, `price`, `totalPrice`, `createDate`, `goodsTastes`) VALUES
	('201501301318215', '96', '45,54,60,61,79,80,1,1,', '秋刀鱼,骨肉相连,茄子,玉米,百威,纯生罐装,百威,王老吉,', '2,2,1,1,2,1,1,1,', 11, '16,6,7,7,16,5,8,5,', 70, '2015-01-30 13:18:23', '1,1,1,1,4,4,1,1,'),
	('201503082159322', '97', '45,46,80,60,', '秋刀鱼,干鱿鱼,纯生罐装,茄子,', '2,2,1,1,', 6, '16,16,5,7,', 44, '2015-03-08 21:59:32', '1,1,4,1,'),
	('201503291623001', '98', '45,46,', '秋刀鱼,干鱿鱼,', '1,1,', 2, '8,8,', 16, '2015-03-29 16:23:01', '1,1,'),
	('201504072105031', '99', '1,', '福寿鱼,', '1,', 1, '15,', 15, '2015-04-07 21:05:03', '1,'),
	('201504072109552', '100', '1,1,1,1,1,1,1,1,1,1,1,3,', '秋刀鱼,干鱿鱼,福寿鱼,开心鱼,茄子,娃娃菜,百威,纯生罐装,秋刀鱼,娃娃菜,青岛纯生,百威,', '1,1,1,1,1,1,1,1,1,1,1,3,', 14, '8,8,15,4,7,2,8,5,8,2,7,24,', 98, '2015-04-07 21:09:55', '1,1,1,1,1,1,1,1,1,1,1,1,'),
	('201504072130074', '101', '2,3,', '百威,王老吉,', '2,3,', 5, '16,15,', 31, '2015-04-07 21:30:07', '1,1,'),
	('201504072136313', '102', '2,', '韭菜,', '2,', 2, '4,', 4, '2015-04-07 21:36:31', '1,');
/*!40000 ALTER TABLE `myorder` ENABLE KEYS */;


-- 导出  表 wuxian.ordertable 结构
CREATE TABLE IF NOT EXISTS `ordertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '开台ID号',
  `orderId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '顾客订单号',
  `deskNo` int(11) NOT NULL COMMENT '桌编号',
  `tel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '顾客电话',
  `waiterId` int(11) NOT NULL COMMENT '服务员ID',
  `clientNo` int(11) NOT NULL COMMENT '顾客人数',
  `payment` double DEFAULT NULL COMMENT '订金',
  `phone` int(11) NOT NULL COMMENT '是否手机订单 0否 1是',
  `vip` int(11) DEFAULT NULL COMMENT 'vip 0否 1是',
  `orderBook` int(11) NOT NULL COMMENT '是否下单     0未下单    1已下单',
  `checkOut` int(11) NOT NULL COMMENT '是否结账 0代表否 1代表是',
  `remark` text COLLATE utf8_unicode_ci COMMENT '备注',
  `createTime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 ROW_FORMAT=COMPACT COMMENT='后台开台记录表';

-- 正在导出表  wuxian.ordertable 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `ordertable` DISABLE KEYS */;
INSERT INTO `ordertable` (`id`, `orderId`, `deskNo`, `tel`, `waiterId`, `clientNo`, `payment`, `phone`, `vip`, `orderBook`, `checkOut`, `remark`, `createTime`) VALUES
	(96, '201501301318215', 5, NULL, 1, 1, 0, 1, 0, 1, 0, '', '2015-01-30 13:18:23'),
	(97, '201503082159322', 2, NULL, 1, 1, 0, 1, 0, 1, 1, '', '2015-03-08 21:59:32'),
	(98, '201503291623001', 1, NULL, 1, 1, 0, 1, 0, 0, 1, '', '2015-03-29 16:23:01'),
	(99, '201504072105031', 1, NULL, 1, 2, 0, 1, 0, 0, 0, '', '2015-04-07 21:05:03'),
	(100, '201504072109552', 2, NULL, 1, 3, 0, 1, 0, 0, 0, '', '2015-04-07 21:09:55'),
	(101, '201504072130074', 4, NULL, 1, 2, 0, 1, 0, 0, 0, '', '2015-04-07 21:30:07'),
	(102, '201504072136313', 3, NULL, 1, 1, 0, 1, 0, 0, 0, '', '2015-04-07 21:36:31');
/*!40000 ALTER TABLE `ordertable` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
