package com.jikaigg.exception;

/**
 * 自定义异常类
 */
public class TestException extends Exception{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TestException(String message) {
        this.message = message;
    }
}
