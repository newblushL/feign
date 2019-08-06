package com.example.feign.controller;

import com.example.feign.client.UserRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ll
 * @create: 2019-08-06 19:02
 */
@RestController
public class HelloController {

    @Autowired
    private UserRemoteClient userRemoteClient;

    @GetMapping("/callHello")
    public String callHello(){
        String result = userRemoteClient.hello();
        return result;
    }
}