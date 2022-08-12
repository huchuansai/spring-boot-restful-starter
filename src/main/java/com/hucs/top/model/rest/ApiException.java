package com.hucs.top.model.rest;

import com.alibaba.fastjson.JSON;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;

    private final int code;

    private Object data;

    public ApiException(String message) {
        this.message = message;
        this.code = ResultCode.FAIL.getCode();
    }

    public ApiException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiException{" + "message='" + message + '\'' +
                ", code=" + code +
                ",data=" + JSON.toJSON(data) +
                '}';
    }
}
