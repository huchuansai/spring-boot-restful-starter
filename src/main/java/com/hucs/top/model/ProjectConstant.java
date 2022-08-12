package com.hucs.top.model;

import java.io.File;

/**
 * @Author: huchuansai
 * @Date: 2022/8/11 11:58 AM
 * @Description: 系统常量
 */
public class ProjectConstant {
    public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    public static final String EMPTY_STRING = "";
    public static final String BASIC_STORAGE = File.separator + "storage";
    // 存放文件的基础路径
    public static String BASE_STORAGE_PATH = System.getProperty("user.dir") + BASIC_STORAGE;
}
