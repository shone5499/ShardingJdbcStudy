package com.shone.readandwriteseparate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shone.readandwriteseparate.entity.User;
import com.shone.readandwriteseparate.mapper.UserMapper;
import com.shone.readandwriteseparate.service.IUserService;
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
