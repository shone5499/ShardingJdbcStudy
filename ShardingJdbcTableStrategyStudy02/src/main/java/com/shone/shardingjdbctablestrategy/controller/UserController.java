package com.shone.shardingjdbctablestrategy.controller;

import com.shone.shardingjdbctablestrategy.entity.User;
import com.shone.shardingjdbctablestrategy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * DemoClass
 *
 * @author Xiao GuoJian
 * @date 2019-11-07 10:57
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/list")
    public List<User> list(){
        return iUserService.list(null);
    }
}
