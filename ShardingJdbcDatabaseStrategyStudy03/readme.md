# SpringBoot+MybatisPlus+ShardingJdbc实现分库分表

## MybatisPlus
如果有不会使用的，请参考MybatisPlusStudy01模块，里面实现了最简单的集成

## ShardingJdbc
集成ShardingJdbc，实现最简单的分表操作

注意：SpringBoot 、 MybatisPlus 和 ShardingJdbc的版本兼容性问题。

本例子是在单个数据库中实现，t_order表是主表

sharding_jdbc_db1和sharding_jdbc_db2库中的数据是根据t_order表的user_id字段分库的

user_id为奇数在sharding_jdbc_db2库中

user_id为偶数在sharding_jdbc_db1库中

t_order0和t_order1根据order_id取模分表的


t_order0的order_id字段都是偶数

t_order1的order_id字段都是奇数

调用/torder/list接口可以看到控制台打印的sql语句内容，分别中两个库两个表中查询了数据，如下：

Rule Type: sharding

Logic SQL: SELECT  order_id,user_id,add_time  FROM t_order

Actual SQL: ds0 ::: SELECT  order_id,user_id,add_time  FROM t_order0

Actual SQL: ds0 ::: SELECT  order_id,user_id,add_time  FROM t_order1

Actual SQL: ds1 ::: SELECT  order_id,user_id,add_time  FROM t_order0

Actual SQL: ds1 ::: SELECT  order_id,user_id,add_time  FROM t_order1

注意：在SharddingJdbc中需要将不分库分表的表也配置在分片规则中，例如本例子中没有配置user表的规则，则user表的数据源是不固定的，两个库都有可能被查。
这种情况官方提供两种解决方式：

方法1：配置default-data-source，凡是在默认数据源中的表可以无需配置在分片规则中，ShardingSphere将在找不到分片数据源的情况下将表路由至默认数据源。

方法2：将不参与分库分表的数据源独立于ShardingSphere之外，在应用中使用多个数据源分别处理分片和不分片的情况。