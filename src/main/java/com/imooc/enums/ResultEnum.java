package com.imooc.enums;

/**
 * Created by Administrator on 2017/7/19.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你在上小学"),
    MIDDLE_SCHOOL(101,"你在读初中"),

    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
//不需要set，直接从构造器里面取值
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
