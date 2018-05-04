package com.wgs.eurekaprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wgs.entity.User;

@RestController
public class MainController {

    @RequestMapping("/test")
    public User test(@RequestParam("name") String name){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId("111");
        user.setName(name);
        return user;
    }
}
