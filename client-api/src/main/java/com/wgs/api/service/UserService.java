package com.wgs.api.service;

import com.wgs.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-api")
public interface UserService {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    User getUser(@RequestParam(value = "name") String name);
}
