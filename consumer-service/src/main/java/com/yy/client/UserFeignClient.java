package com.yy.client;

import com.yy.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "member-service",fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/user/get/{id}")
    User getUser(@PathVariable("id") long id);
}
