package com.hucs.top.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: Spring ApplicationContext
 * @Author: huchuansai
 * @Date: 2021/6/30 5:55 下午
 **/
@Component
@Slf4j
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    /**
     * 获取applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);

    }

    /**
     * 通过class获取Bean.
     *
     * @param classType
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> classType) {
        return getApplicationContext().getBean(classType);
    }

    /**
     * 通过name,以及Class返回指定的Bean
     *
     * @param name
     * @param classType
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> classType) {
        return getApplicationContext().getBean(name, classType);
    }

}


