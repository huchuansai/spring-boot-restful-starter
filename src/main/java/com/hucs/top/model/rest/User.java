package com.hucs.top.model.rest;

import lombok.Data;

/**
 * @Author: huchuansai
 * @Date: 2022/8/12 10:52 AM
 * @Description: 用户实体，参数透传
 */
@Data
public class User {
    private String accessToken;
    private Long userId;
}
