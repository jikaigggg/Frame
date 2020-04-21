package com.jikaigg.blog.exception;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class CustomizeException extends RuntimeException {
    //错误信息
    private String message;
    //错误码
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
