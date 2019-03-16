package com.yy.service.impl;

import com.yy.dao.UserMapper;
import com.yy.dto.RegUserDto;
import com.yy.entity.User;
import com.yy.exception.CodeMsg;
import com.yy.exception.GlobalException;
import com.yy.service.UserService;
import com.yy.utils.MD5Util;
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

        if (dbPassword.equals(password)) {
            return user;
        } else {
            throw new GlobalException(CodeMsg.WRONG_PASSWORD);
        }


    }

    @Override
    public boolean register(RegUserDto userDto) {

        //校验两次输入的密码是否一致，暂时放在这里，之后放到前端验证
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            throw new GlobalException(CodeMsg.TWO_PASSWORD);
        }

        //检查用户名是否已经被注册
        User user = userMapper.getUser(userDto.getUsername());
        if (user != null) {
            throw new GlobalException(CodeMsg.USER_EXISTS);
        }

        //使用MD5并加salt进行密码加密
        String salt = MD5Util.getSalt();
        String passwordToDB = MD5Util.inputToDB(userDto.getPassword(), salt);
        userDto.setPassword(passwordToDB);
        userDto.setSalt(salt);

        int res = userMapper.register(userDto);
        if (res != 1) {
            throw new GlobalException(CodeMsg.REGISTER_FAILED);
        }

        return true;
    }

    @Override
    public User login(@NotNull String username, @NotNull String password) {
        User user = userMapper.getUser(username);

        if (user == null) {
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }

        String salt = user.getSalt();
        String inputPasswordMD5 = MD5Util.inputToDB(password, salt);

        if (user.getPassword().equals(inputPasswordMD5)) {
            return user;
        } else {
            throw new GlobalException(CodeMsg.WRONG_PASSWORD);
        }
    }
}
