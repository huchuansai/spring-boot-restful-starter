package com.hucs.top.model.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: huchuansai
 * @time: 2021/5/27 3:48 下午
 */
@AllArgsConstructor
public enum SystemError {
    PARAM_ERROR(1001, "参数错误"),
    ;
    @Getter
    private int code;
    @Getter
    private String message;
}
