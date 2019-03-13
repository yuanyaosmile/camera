package com.yy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CodeMsg {
    private int code;
    private String msg;

    public static final CodeMsg USER_NOT_EXIST = new CodeMsg(100001,"用户不存在");

    public static final CodeMsg WRONG_PASSWORD = new CodeMsg(100002,"密码错误");

    public static final CodeMsg TWO_PASSWORD = new CodeMsg(100003,"两次输入的密码不一致");

    public static final CodeMsg REGISTER_FAILED = new CodeMsg(100004,"注册失败");

    public static final CodeMsg USER_EXISTS = new CodeMsg(100005,"用户名已经存在");

}

