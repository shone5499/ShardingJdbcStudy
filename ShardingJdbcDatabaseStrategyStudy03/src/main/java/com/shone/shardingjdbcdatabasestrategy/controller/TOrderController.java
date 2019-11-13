package com.shone.shardingjdbcdatabasestrategy.controller;


import com.shone.shardingjdbcdatabasestrategy.entity.TOrder;
import com.shone.shardingjdbcdatabasestrategy.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

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
    @RequestMapping("/list")
    public List<TOrder> list(){
        return itOrderService.list(null);
    }

    /**
     * 插入订单
     * @param tOrder
     * @return
     */
    @RequestMapping("/add")
    public Object add(TOrder tOrder){
        tOrder.setAddTime(LocalDateTime.now());
        return itOrderService.save(tOrder);
    }

}
