package com.hucs.top.manager.ext;

import cn.hutool.core.util.RandomUtil;
import com.hucs.top.config.PropertyConfig;
import com.hucs.top.manager.UploadManager;
import com.hucs.top.model.PrefixKeyConstant;
import com.hucs.top.model.ProjectConstant;
import com.hucs.top.model.error.SystemError;
import com.hucs.top.model.rest.ApiException;
import com.hucs.top.utils.DateUtil;
import com.hucs.top.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: huchuansai
 * @Date: 2022/8/11 2:16 PM
 * @Description:
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadManagerImpl implements UploadManager {

    private final PropertyConfig propertyConfig;

    @Override
    public String uploadFile(MultipartFile file) {
        if (Objects.isNull(file)) throw new ApiException(SystemError.PARAM_ERROR.getMessage());
        // 创建文件夹
        getOrCreatePathFile(ProjectConstant.BASE_STORAGE_PATH);

        // 文件名
        String fileName = DateUtil.formatYYYYMMDDHHMMSS(new Date()) + RandomUtil.randomString(4) + getFileExtension(file.getOriginalFilename());
        // 要保存的文件的绝对路径
        String filePath = ProjectConstant.BASE_STORAGE_PATH + File.separator + fileName;
        File localFile = new File(filePath);
        // 写入数据
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        // 例如：localhost:6004/api/storage/a.txt
        return getIp() + PrefixKeyConstant.COLON + propertyConfig.getPort() + propertyConfig.getContextPath() + ProjectConstant.BASIC_STORAGE + File.separator + fileName;
    }

    // 获取文件的扩展名
    public static String getFileExtension(String fileName) {
        if (StringUtil.isEmpty(fileName)) throw new ApiException(SystemError.PARAM_ERROR.getMessage());

        if (fileName.lastIndexOf(PrefixKeyConstant.DOT) != -1 && fileName.lastIndexOf(PrefixKeyConstant.DOT) != 0) {
            return PrefixKeyConstant.DOT + fileName.substring(fileName.lastIndexOf(PrefixKeyConstant.DOT) + 1);
        }
        return ProjectConstant.EMPTY_STRING;
    }

    public static File getOrCreatePathFile(String dirPath) {
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            // 如果目录不存在，则创建目录
            boolean mkdirResult = dirFile.mkdirs();
            if (!mkdirResult) {
                log.error("create dirPath error");
            }
        }
        return dirFile;
    }

    @SneakyThrows
    public static String getIp() {
        InetAddress ip4 = Inet4Address.getLocalHost();
        return ip4.getHostAddress();
    }
}
