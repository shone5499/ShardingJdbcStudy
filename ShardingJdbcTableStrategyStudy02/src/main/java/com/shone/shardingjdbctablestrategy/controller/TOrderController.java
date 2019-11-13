package com.shone.shardingjdbctablestrategy.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shone.shardingjdbctablestrategy.entity.TOrder;
import com.shone.shardingjdbctablestrategy.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Shone
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/torder")
public class TOrderController {

    @Autowired
    private ITOrderService itOrderService;

    /**
     * 查询订单列表
     * @return
     */
    @GetMapping("/list")
    public List<TOrder> list(TOrder tOrder){
        Wrapper<TOrder> wrapper = new QueryWrapper(tOrder);
        return itOrderService.list(wrapper);
    }

    /**
     * 插入订单
     * @param tOrder
     * @return
     */
    @PostMapping("/add")
    public Object add(TOrder tOrder){
        tOrder.setAddTime(LocalDateTime.now());
        return itOrderService.save(tOrder);
    }

    /**
     * 根据查询订单列表
     * @return
     */
    @GetMapping("/listByIds")
    public Collection<TOrder> listByIds(String idStr){
        List<Long> ids = Arrays.asList(idStr.split(",")).stream().map(Long::parseLong).collect(Collectors.toList());
        return itOrderService.listByIds(ids);
    }

    /**
     * 根据查询订单列表
     * 根据分片键Orderid范围查询
     * 测试走范围分片算法
     * @return
     */
    @GetMapping("/listByRangeId")
    public List<TOrder> listByRangeId(Long startId, Long endId){
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.between("order_id",startId,endId);
        return itOrderService.list(wrapper);
    }

}
