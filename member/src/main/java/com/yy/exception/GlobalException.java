package com.yy.exception;

public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = -4090615814473866409L;
    public CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg){
        super();
        this.codeMsg = codeMsg;
    }
}
