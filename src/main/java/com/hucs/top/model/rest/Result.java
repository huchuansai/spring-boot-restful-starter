package com.hucs.top.model.rest;

import com.alibaba.fastjson.JSON;
import com.hucs.top.model.ProjectConstant;
import lombok.Data;

/**
 * 统一API响应结果封装
 *
 * @author huchuansai
 */
@Data
public class Result<T> {

    /**
     * 响应结果编码
     */
    private int code;

    /**
     * 响应结果内容
     */
    private String message;

    /**
     * 响应结果对象
     */
    private T data;

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMessage(ProjectConstant.DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<T>().setCode(ResultCode.FAIL).setMessage(message);
    }
}
