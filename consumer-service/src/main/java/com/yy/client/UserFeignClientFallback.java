package com.yy.client;

import com.yy.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient{

    @Override
    public User getUser(long id) {
        User user = new User();
        user.setUsername("no data");
        return user;
    }
}
