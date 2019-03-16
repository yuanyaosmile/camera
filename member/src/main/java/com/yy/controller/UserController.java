package com.yy.controller;

import com.yy.dto.RegUserDto;
import com.yy.entity.User;
import com.yy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/to_login")
    public String to_login(Model model){
        return "login";
    }



    @RequestMapping("/to_index")
    public String to_index(Model model){
        return "index";
    }


    @RequestMapping("/to_haha")
    public String to_haha(Model model){
        return "haha";
    }

    @RequestMapping("/login")
    public String login(@NotNull String username, @NotNull String password, Model model){
        User user = userService.login(username,password);
        model.addAttribute("user",user);
        return "index" ;
    }

    @RequestMapping("/to_register")
    public String to_register(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(RegUserDto userDto,Model model){
        boolean res = userService.register(userDto);
        //model.addAttribute("user",user);
        return "login";
    }
}
