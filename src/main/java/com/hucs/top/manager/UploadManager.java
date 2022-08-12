package com.hucs.top.manager;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: huchuansai
 * @Date: 2022/8/11 2:15 PM
 * @Description:
 */
public interface UploadManager {
    /**
     * @Description: 文件上传接口
     * @Author: huchuansai
     * @Date: 2022/8/11 2:15 PM
     * @Return: 图片访问地址
     **/
    String uploadFile(MultipartFile file);
}
