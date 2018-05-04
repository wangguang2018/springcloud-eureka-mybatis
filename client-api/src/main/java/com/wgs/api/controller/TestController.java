package com.wgs.api.controller;

import com.wgs.api.service.UserService;
import com.wgs.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public User test(){
        User user = userService.getUser("hello");
        return user;
    }

    public User error(){
        return new User();
    }

}
