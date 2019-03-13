package com.yy.service.impl;

import com.yy.dao.UserMapper;
import com.yy.dto.RegUserDto;
import com.yy.entity.User;
import com.yy.exception.CodeMsg;
import com.yy.exception.GlobalException;
import com.yy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(@NotNull String username, @NotNull String password) {
        User user = userMapper.getUser(username);

        if (user == null) {
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }

        String dbPassword = user.getPassword();

        if (dbPassword.equals(password)){
            return user;
        }else {
            throw new GlobalException(CodeMsg.WRONG_PASSWORD);
        }


    }

    @Override
    public boolean register(RegUserDto userDto) {

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())){
            throw new GlobalException(CodeMsg.TWO_PASSWORD);
        }

        User user = userMapper.getUser(userDto.getUsername());
        if (user != null){
            throw new GlobalException(CodeMsg.USER_EXISTS);
        }

        int res = userMapper.register(userDto);
        if (res != 1){
            throw new GlobalException(CodeMsg.REGISTER_FAILED);
        }

        return true;
    }
}
