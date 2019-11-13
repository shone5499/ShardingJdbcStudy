package com.shone.shardingjdbctablestrategy.config;

import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 范围分片算法
 * 按照时间 年月yyyyMM进行数据分片
 * 在数据查询的时候的处理
 * RangeShardingAlgorithm是可选的，用于处理BETWEEN AND分片，如果不配置RangeShardingAlgorithm，SQL中的BETWEEN AND将按照全库路由处理。
 * 必须使用分片键进行查询才有效，如果没有分片键，则此类无效
 *
 * @author Xiao GuoJian
 * @date 2019-11-09 18:12
 */

@Slf4j
public class TimeRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    private DateTimeFormatter yearAndMonth = DateTimeFormatter.ofPattern("yyyyMM");
    private DateTimeFormatter yearAndMonthAndDay = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        log.info("===============进入到TimeRangeShardingAlgorithm方法============表名="+rangeShardingValue.getLogicTableName());
        Collection<String> result;
        Range<Long> shardingKey = rangeShardingValue.getValueRange();
        long startShardingKey = shardingKey.lowerEndpoint();
        long endShardingKey = shardingKey.upperEndpoint();
        //获取到开始时间戳
        String startTimeString = getYearAndMonth(startShardingKey);
        //获取结束时间戳
        String endTimeString = getYearAndMonth(endShardingKey);
        result = getBetweenDate(startTimeString,endTimeString).stream().map(s -> rangeShardingValue.getLogicTableName()+"_"+s).collect(Collectors.toList());

        return result;
    }

    public String getYearAndMonth(long shardingKey){
        Instant instant =  Instant.ofEpochMilli(SnowflakeShardingKeyGenerator.EPOCH+(Long.valueOf(shardingKey+"")>>22));
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return  yearAndMonth.format(localDateTime);
    }

    /**
     * 获取两个月份间隔的所有月份
     * @param start 格式必须为'201809'
     * @param end 格式必须为'201902'
     * @return
     */
    public List<String> getBetweenDate(String start, String end){
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start+"01",yearAndMonthAndDay);
        LocalDate endDate = LocalDate.parse(end+"01",yearAndMonthAndDay);

        long distance = ChronoUnit.MONTHS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusMonths(1))
                .limit(distance + 1).forEach(f -> list.add(yearAndMonth.format(f)));
        return list;
    }

}
