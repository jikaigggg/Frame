package com.jikaigg.blog.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    //定义所有错误的枚举
    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不要换个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行恢复，请选择"),
    NO_LOGIN(2003,"未登陆，请先登录"),
    SYSTEM_ERROR(2004,"你找的页面不存在，请尝试其他页面"),
    TYPR_PARAM_NOT_FOUND(2005,"类型不对，请重新输入"),
    COMMENT_NOT_FOUND(2006,"你评论的问题不存在");

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
    private Integer code;
    private String message;
    CustomizeErrorCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
