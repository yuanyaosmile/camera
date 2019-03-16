package com.yy.service;

import com.yy.dto.RegUserDto;
import com.yy.entity.User;

public interface UserService {
    User getUser(String username, String password);

    boolean register(RegUserDto userDto);

    User login(String username, String password);
}
