package com.hucs.top.utils;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hucs.top.model.rest.ApiException;
import com.hucs.top.model.rest.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Objects;

/**
 * @Author: huchuansai
 * @Date: 2021/12/2 9:24 上午
 * @Description:
 */
@Slf4j
public class HttpUtil {

    private static final String NORMAL_HEADER_NAME = "token";

    public static <T> T post(String url, String headerName, String headerValue, String body, Class<T> clazz) {
        log.info("pre post request url is：{}， body is：{}", url, body);
        String response = HttpRequest.post(url)
                .header(StringUtils.isEmpty(headerName) ? NORMAL_HEADER_NAME : headerName, headerValue)
                .body(body)
                .execute()
                .body();
        return parseResponse(response, clazz, true);
    }

    public static <T> T post(String url, File file, Class<T> clazz) {
        log.info("pre post request url is：{}", url);
        String response = HttpRequest.post(url).form("file", file).execute().body();
        return parseResponse(response, clazz, true);
    }

    public static void postIgnoreResponse(String url, String headerName, String headerValue, String body) {
        log.info("pre post request url is：{}， body is：{}", url, body);
        String response = HttpRequest.post(url)
                .header(StringUtils.isEmpty(headerName) ? NORMAL_HEADER_NAME : headerName, headerValue)
                .body(body)
                .execute()
                .body();
        log.info("receive response body is：{}", response);
    }

    public static <T> T delete(String url, String headerName, String headerValue, Class<T> clazz) {
        String response = HttpRequest.delete(url)
                .header(StringUtils.isEmpty(headerName) ? NORMAL_HEADER_NAME : headerName, headerValue)
                .execute()
                .body();
        return parseResponse(response, clazz, true);
    }

    // 此put接口不关心返回结果
    public static <T> T put(String url, String headerName, String headerValue, String body, Class<T> clazz) {
        log.info("pre put request url is：{}， body is：{}", url, body);
        String response = HttpRequest.put(url)
                .header(StringUtils.isEmpty(headerName) ? NORMAL_HEADER_NAME : headerName, headerValue)
                .body(body)
                .execute()
                .body();

        log.info("receive response body is：{}", response);
        return null;
    }

    public static <T> T get(String url, String headerName, String headerValue, Class<T> clazz) {
        String response = HttpRequest.get(url)
                .header(StringUtils.isEmpty(headerName) ? NORMAL_HEADER_NAME : headerName, headerValue)
                .execute()
                .body();
        return parseResponse(response, clazz, true);
    }

    public static <T> T parseResponse(String response, Class<T> clazz, boolean showLog) {
        if (showLog) log.info("receive response body is：{}", response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Integer code = jsonObject.getInteger("code");
        Integer statusCode = jsonObject.getInteger("statusCode");
        Integer resultCode = Objects.nonNull(code) ? code : statusCode;
        if (HttpStatus.OK.value() != resultCode) {
            throw new ApiException(jsonObject.getString("message"), ResultCode.FAIL.getCode());
        }
        String data = jsonObject.getString("data");
        if (clazz.equals(String.class)) {
            return objParse(clazz, data);
        }
        return JSONObject.parseObject(data, clazz);
    }

    public static <T> T objParse(Class<T> returnClass, Object value) {
        try {
            if (value.getClass().equals(returnClass)) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.convertValue(value, returnClass);
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
