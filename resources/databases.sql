CREATE TABLE `Github_BookInfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `BookName` varchar(50) NOT NULL COMMENT '书名',
  `Author` varchar(50) NOT NULL COMMENT '作者',
  `Press` varchar(55) NOT NULL COMMENT '出版社',
  `PressTime` varchar(50) NOT NULL COMMENT '出版时间',
  `Price` double(11,2) NOT NULL COMMENT '价格',
  `Isbn` varchar(50) NOT NULL COMMENT 'isbn码',
  `Star` double(16,2) NOT NULL COMMENT '评分',
  `EvaluateCount` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `BookType` int(11) NOT NULL DEFAULT '0' COMMENT '类型',
  `AddTime` timestamp NOT NULL DEFAULT '2017-05-08 00:00:00' COMMENT '添加时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`),
  KEY `IX_AddTime` (`AddTime`) USING BTREE,
  KEY `IX_UpdateTime` (`UpdateTime`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='豆瓣图书信息表'