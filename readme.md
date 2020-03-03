# Springboot+MybatisPlus+ShardingJdbc学习
项目是自己学习ShardingJdbc的一些简单的使用。
项目分四个子模块，由易到难，一步一步实现这三个的集成，分别如下：

## 1 MybatisPlusStudy模块
此模块是其他的项目的第一步，简单的用Springboot集成MybatisPlus。

## 2 ShardingJdbcTableStrategyStudy
此模块用Springboot+MybatisPlus+ShardingJdbc，实现单库的分表。

application中集成了两种分表方式，分片键都是order_id，生成规则是用ShardingJdbc的雪花算法。

第一种是根据order_id的奇数，偶数将分表；

第二种是根据order_id的雪花算法反向推出生成时间，按照年月分表；

## 3 ShardingJdbcDatabaseStrategyStudy
此模块用Springboot+MybatisPlus+ShardingJdbc实现分库分表。

## 4 ReadAndWriteSeparateStydy
此模块用Springboot+MybatisPlus+ShardingJdbc实现读写分离。

更复杂的使用请参考ShardingJdbc官方文档

