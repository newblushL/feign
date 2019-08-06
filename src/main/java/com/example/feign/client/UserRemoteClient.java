package com.example.feign.client;

import com.example.feign.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: Feign客户端定义
 * @author: ll
 * @create: 2019-08-06 18:59
 */

@FeignClient(value = "eureka-client-user-service", configuration = FeignConfiguration.class)
public interface UserRemoteClient {

    @GetMapping("/user/hello")
    String hello();
}