DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `nickname` VARCHAR(64) DEFAULT NULL COMMENT '昵称',
  `username` varchar(64) DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(128) DEFAULT NULL COMMENT '密码盐',
  `encrypt` VARCHAR (20) DEFAULT NULL COMMENT '加密方式',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `id_code` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `ext` VARCHAR (1024) DEFAULT NULL COMMENT '扩展属性',

  `version` INTEGER DEFAULT 0 COMMENT '版本号',
  `status` SMALLINT DEFAULT 0 COMMENT '用户状态',

  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX uni_index_user_name(`username`),
  UNIQUE INDEX uni_index_user_id(`user_id`),
  UNIQUE INDEX uni_index_mobile(`mobile`),
  UNIQUE INDEX uni_index_email(`email`),
  UNIQUE INDEX uni_index_id_code(`id_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='账户表';