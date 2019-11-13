package com.shone.shardingjdbcdatabasestrategy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shone.shardingjdbcdatabasestrategy.entity.TOrder;
import com.shone.shardingjdbcdatabasestrategy.mapper.TOrderMapper;
import com.shone.shardingjdbcdatabasestrategy.service.ITOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Shone
 * @since 2019-11-07
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
