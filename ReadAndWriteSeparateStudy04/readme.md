# ShardingJdbc实现读写分离

### Springboot + MybatisPlus + ShardingJdbc

这里使用ShardingJdbc只是实现了最简单的读写分离

向主库master写数据，从库读取数据

至于主库从库之间的数据同步，需要我们自己去实现

读写分离的配置相当简单，写好各个类后，到ShardingJdbc官网把springboot的配置复制进来即可。
