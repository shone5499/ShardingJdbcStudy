package com.shone.readandwriteseparate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shone.readandwriteseparate.entity.TOrder;
import com.shone.readandwriteseparate.mapper.TOrderMapper;
import com.shone.readandwriteseparate.service.ITOrderService;
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
