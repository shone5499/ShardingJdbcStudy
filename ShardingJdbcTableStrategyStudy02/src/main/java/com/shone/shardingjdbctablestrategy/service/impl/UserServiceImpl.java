package com.shone.shardingjdbctablestrategy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shone.shardingjdbctablestrategy.entity.User;
import com.shone.shardingjdbctablestrategy.mapper.UserMapper;
import com.shone.shardingjdbctablestrategy.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * DemoClass
 *
 * @author Xiao GuoJian
 * @date 2019-11-07 10:54
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
