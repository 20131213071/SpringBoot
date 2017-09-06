package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by smx on 2017/7/18.
 */
public class GirlException extends RuntimeException{
    private Integer code;
    private String message;
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
