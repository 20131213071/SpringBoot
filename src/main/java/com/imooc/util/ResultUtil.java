package com.imooc.util;

import com.imooc.domain.Result;

/**
 * Created by smx on 2017/7/11.
 */
public class ResultUtil {
   // Result result = new Result();
   public static Result success(Object object) {
       Result result = new Result();
       result.setCode(0);
       result.setMsg("成功");
       result.setData(object);
       return result;
   }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
