# SpringBoot + MybatisPlus + ShardingJdbc实现分表

## MybatisPlus
如果有不会使用的，请参考MybatisPlusStudy01模块，里面实现了最简单的集成

## ShardingJdbc
集成ShardingJdbc，实现最简单的分表操作

注意：SpringBoot 、 MybatisPlus 和 ShardingJdbc的版本兼容性问题。

本例子是在单个数据库中实现，t_order表是主表，t_order0和t_order1根据order_id取模分表的，
可以根据自己需求，例如根据日期的月份作为分片规则

t_order0的order_id字段都是偶数

t_order1的order_id字段都是奇数

调用/torder/list接口可以看到控制台打印的sql语句内容，分别中两个表中查询了数据，如下：

Rule Type: sharding

Logic SQL: SELECT  order_id,user_id,add_time  FROM t_order

Actual SQL: ds0 ::: SELECT  order_id,user_id,add_time  FROM t_order0

Actual SQL: ds0 ::: SELECT  order_id,user_id,add_time  FROM t_order1

