# blog

[TOC]

## 数据库相关

#### 用户表

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
#### 用户表
account_id,name,token,create_time,modified_time
```sql
#用户表
CREATE TABLE blog.user(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    account_id VARCHAR(100),
    name VARCHAR(500),
    token VARCHAR(36),
    create_time BIGINT,
    modified_time BIGINT,
    avatar_url VARCHAR(100)
);
```

#### 问题表
```sql
#问题表
CREATE TABLE blog.question(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    title VARCHAR(50),
    description TEXT,
    create_time BIGINT,
    modified_time BIGINT,
    creator INT,
    comment_count INT default 0,
    view_count INT default 0,
    like_count INT default 0,
    tag VARCHAR(256)
);
```


#### 评论表
```sql
#评论表
CREATE TABLE blog.comment(
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '',
    parent_id BIGINT COMMENT '父类ID',
    content VARCHAR(1024) COMMENT '评论内容',
    type INT COMMENT '父类类型',
    commentator INT COMMENT '评论人ID',
    create_time BIGINT COMMENT '创建时间',
    modified_time BIGINT COMMENT '更新时间',
    like_count BIGINT COMMENT '点赞数'
);
```
