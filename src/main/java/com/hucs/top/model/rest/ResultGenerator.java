package com.hucs.top.model.rest;

import com.hucs.top.model.ProjectConstant;

/**
 * 统一结果响应
 *
 * @author huchuansai
 */
public class ResultGenerator {

    /**
     * 业务接口返回成功 返回默认提示
     */
    public static <T> Result<T> genSuccessResult() {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMessage(ProjectConstant.DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 业务接口返回成功 返回泛型成功信息
     */
    public static <T> Result<T> genSuccessResult(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMessage(ProjectConstant.DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    /**
     * 业务接口返回失败 返回ResultCode枚举类定义的全局统一错误提示
     */
    public static <T> Result<T> genFailResult(int code, String message) {
        return new Result<T>().setCode(code).setMessage(message).setData(null);
    }

    public static <T> Result<T> genFailResult(String message) {
        return Result.fail(message);
    }
}
