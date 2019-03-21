package com.yy.controller;


import com.yy.client.UserFeignClient;
import com.yy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    UserFeignClient userFeignClient;

   /*@Autowired
    RestTemplate restTemplate;*/

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") long id){
        return userFeignClient.getUser(id);

       // User user = restTemplate.getForObject("http://member-service/user/get/" + id, User.class);
       // return user;
    }
}
