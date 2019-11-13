package com.shone.shardingjdbctablestrategy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shone.shardingjdbctablestrategy.entity.TOrder;
import com.shone.shardingjdbctablestrategy.mapper.TOrderMapper;
import com.shone.shardingjdbctablestrategy.service.ITOrderService;
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
