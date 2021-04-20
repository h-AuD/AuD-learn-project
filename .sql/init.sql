CREATE TABLE `USER` (
  `ID` int(11) NOT NULL COMMENT '主键',
  `NAME` varchar(50) NOT NULL unique key COMMENT '名称',
  `AGE` int(3) NOT NULL COMMENT '年龄',
  `CTIME` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `MATERIAL` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MEDIA_ID` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `TITLE` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '图文消息的标题',
  `AUTHOR` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '作者',
  `THUMB_MEDIA_ID` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '图文消息的封面图片素材id（必须是永久mediaID）',
  `DIGEST` varchar(200) DEFAULT NULL COMMENT '图文摘要',
  `CONTENT` longtext COMMENT '图文消息的具体内容,文章需要放在DB?不合适吧',
  `URL` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL',
  `MEDIA_TYPE` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `CONTENT_SOURCE_URL` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '图文消息的原文地址，即点击"阅读原文"后的URL',
  `SHOW_COVER_PIC` bit(1) DEFAULT NULL COMMENT '是否显示封面，0为false，即不显示，1为true，即显示',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '这篇图文消息素材的最后更新时间',
  `SEQ` int(11) DEFAULT NULL COMMENT '多图文消息的顺序',
  `CTIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '刷新时间',
  `c` bit(1) NOT NULL DEFAULT b'0' COMMENT '标志位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='素材信息';