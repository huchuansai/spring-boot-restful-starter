package com.hucs.top.config;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: huchuansai
 * @Date: 2022/8/11 2:31 PM
 * @Description:
 */
@Data
@Slf4j
@Configuration
public class PropertyConfig implements InitializingBean {

    @Getter
    @Value("${spring.profiles.active}")
    private String active;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${server.port}")
    private String port;

    @Override
    public void afterPropertiesSet() {
        log.info("PropertyConfig is：" + JSONObject.toJSONString(this.toString()));
    }
}
