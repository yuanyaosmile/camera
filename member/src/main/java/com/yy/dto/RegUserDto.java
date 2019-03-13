package com.yy.dto;


import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class RegUserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
