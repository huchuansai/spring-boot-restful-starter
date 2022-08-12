package com.hucs.top.model.rest;

import lombok.Getter;

/**
 * 结果响应枚举类
 *
 * @author huchuansai
 */
@Getter
public enum ResultCode {

    //500 服务器内部错误
    INTERNAL_SERVER_ERROR(500, "数据异常，请联系管理员"),

    //0000 接口返回成功
    SUCCESS(200, "接口返回成功"),

    //0001 接口返回失败
    FAIL(-1, "接口返回失败"),
    ;

    public int code;
    public String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
