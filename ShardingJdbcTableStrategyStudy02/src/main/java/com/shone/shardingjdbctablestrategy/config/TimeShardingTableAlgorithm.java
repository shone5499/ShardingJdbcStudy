package com.shone.shardingjdbctablestrategy.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * 精确分片算法实现
 * order_id是雪花算法生成的
 * 此功能是利用生成的id，推算出日期，插入到对应的表中,或者根据分片键查询时逆向找出应该查询哪个表
 * 按照时间 年月yyyyMM进行数据分片
 * PreciseShardingAlgorithm是必选的，用于处理=和IN的分片
 *
 * @author Xiao GuoJian
 * @date 2019-11-09 17:39
 */
@Slf4j
public class TimeShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

    private DateTimeFormatter yearAndMonth = DateTimeFormatter.ofPattern("yyyyMM");

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        log.info("=======进入到TimeShardingTableAlgorithm方法=======表名="+preciseShardingValue.getLogicTableName()
                + " 字段名="+preciseShardingValue.getColumnName()+" value="+preciseShardingValue.getValue());
        StringBuffer tableName = new StringBuffer();
        tableName.append(preciseShardingValue.getLogicTableName())
                .append("_").append(getTime(preciseShardingValue.getValue()));

        return tableName.toString();
    }

    /**
     * 使用sharding-jdbc 自带的雪花算法 来生成主键的
     * 根据雪花算法的id，逆推可以推出分片键的时间戳
     * @param shardingKey
     * @return
     */
    public String getTime(long shardingKey){
        Instant instant =  Instant.ofEpochMilli(SnowflakeShardingKeyGenerator.EPOCH+(Long.valueOf(shardingKey+"")>>22));
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return  yearAndMonth.format(localDateTime);
    }
}
