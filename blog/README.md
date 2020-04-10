# blog

[TOC]

## 数据库相关

用户表

```sql
# 用户信息表
CREATE TABLE `user_info` (
	`user_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
	`username` varchar(32) NOT NULL COMMENT '用户名',
	`password` varchar(32) NOT NULL COMMENT '密码',
	`name` varchar(20) NOT NULL COMMENT '昵称',
	`email` varchar(20) NOT NULL COMMENT '邮箱',
	`create_time` bigint(20) NOT NULL COMMENT '创建时间',
	`modify_time` bigint(20) NOT NULL COMMENT '修改时间',
	`is_deleted` tinyint(4) NOT NULL COMMENT '用户是否已注销（0-未删除 1-已删除）',
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```

