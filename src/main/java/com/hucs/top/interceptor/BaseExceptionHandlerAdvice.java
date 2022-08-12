package com.hucs.top.interceptor;

import com.hucs.top.model.rest.ApiException;
import com.hucs.top.model.rest.ResultCode;
import com.hucs.top.model.rest.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class, Service.class})
/**
 * @Description:
 * @Param:
 * @return:
 * @Author: huchuansai 异常拦截器
 * @Date: 2021/5/6 11:39 上午
 */
public class BaseExceptionHandlerAdvice {
    public static String SYSTEM_EXCEPTION_MSG = "数据异常，请联系系统管理员";
    public static String HTTP_FORMAT_EXCEPTION = "参数类型错误";
    public static String SPRING_DAO_EXCEPTION = "数据查询异常，请联系系统管理员";

    /**
     * 自定义Exception处理,自定义业务code、httpStatus状态码(默认500)
     * @param request
     * @param ex
     * @return 异常请求结果
     * 2018年4月20日 上午10:53:08
     */
    @ResponseBody
    @ExceptionHandler({ApiException.class})
    public String handleApiException(HttpServletRequest request, ApiException ex) {
        log.error(ex.getMessage(), ex);
        if (StringUtils.isEmpty(ex.getMessage())) {
            return ResultGenerator.genFailResult(ResultCode.FAIL.code, SYSTEM_EXCEPTION_MSG).toString();
        }
        return ResultGenerator.genFailResult(ResultCode.FAIL.code, ex.getMessage()).toString();
    }

    /**
     * NullPointerException处理
     *
     * @param request
     * @param ex
     * @return 异常请求结果
     * 2018年4月20日 上午10:49:32
     */
    @ResponseBody
    @ExceptionHandler({NullPointerException.class})
    public String handleNullPointerException(HttpServletRequest request, NullPointerException ex) {
        log.error(ex.getMessage(), ex);
        return ResultGenerator.genFailResult(ResultCode.FAIL.code, SYSTEM_EXCEPTION_MSG).toString();
    }

    /**
     * IllegalArgumentException处理
     *
     * @param request
     * @param ex
     * @return 异常请求结果
     * 2018年4月20日 上午10:51:38
     */
    @ResponseBody
    @ExceptionHandler({IllegalArgumentException.class})
    public String handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException ex) {
        log.error(ex.getMessage(), ex);
        return ResultGenerator.genFailResult(ResultCode.FAIL.code, SYSTEM_EXCEPTION_MSG).toString();
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public String httpRequestMethodNotSupportedException(HttpServletResponse response, HttpRequestMethodNotSupportedException ex) {
        log.error(ex.getMessage(), ex);
        return ResultGenerator.genFailResult(ResultCode.FAIL.code, "请求方式错误(request method not support)").toString();
    }


    /**
     * 通用Exception处理
     * 2018年4月20日 上午10:52:00
     */
    @ResponseBody
    @ExceptionHandler({Exception.class})
    public String handleException(HttpServletRequest request, Exception ex) {
        log.error(ex.getMessage(), ex);
        log.error("exception uri is：" + request.getRequestURI());

        String errorMessage = null;
        if (ex instanceof MethodArgumentNotValidException) {
            //参数不通过指定的注解校验,比如@Min @NotNull等
            errorMessage = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldError().getDefaultMessage();
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            errorMessage = SYSTEM_EXCEPTION_MSG;
        } else if (ex instanceof MissingServletRequestParameterException) {
            errorMessage = SYSTEM_EXCEPTION_MSG;
        } else if (ex instanceof HttpMessageNotReadableException) {
            errorMessage = HTTP_FORMAT_EXCEPTION;
        } else if (ex instanceof DataAccessException) {
            errorMessage = SPRING_DAO_EXCEPTION;
        }
        if (!StringUtils.isEmpty(errorMessage)) {
            return ResultGenerator.genFailResult(ResultCode.FAIL.code, errorMessage).toString();
        }
        if (!StringUtils.isEmpty(ex.getMessage())) {
            return ResultGenerator.genFailResult(ResultCode.FAIL.code, ex.getMessage()).toString();
        }
        return ResultGenerator.genFailResult(ResultCode.FAIL.code, SYSTEM_EXCEPTION_MSG).toString();
    }

}
