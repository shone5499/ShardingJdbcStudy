package com.shone.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shone.mybatisplus.entity.User;
import com.shone.mybatisplus.mapper.UserMapper;
import com.shone.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DemoClass
 *
 * @author Xiao GuoJian
 * @date 2019-11-07 10:54
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
