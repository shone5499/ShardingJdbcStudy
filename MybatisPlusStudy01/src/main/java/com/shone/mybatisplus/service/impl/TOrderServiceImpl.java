package com.shone.mybatisplus.service.impl;

import com.shone.mybatisplus.entity.TOrder;
import com.shone.mybatisplus.mapper.TOrderMapper;
import com.shone.mybatisplus.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
