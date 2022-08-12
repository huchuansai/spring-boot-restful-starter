package com.hucs.top.controller;

import com.hucs.top.manager.UploadManager;
import com.hucs.top.model.rest.Result;
import com.hucs.top.model.rest.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: huchuansai
 * @Date: 2022/8/11 1:58 PM
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/upload")
@Api(tags = "UploadController 文件上传Controller")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadController {

    private final UploadManager uploadManager;

    @PostMapping()
    @ApiOperation(value = "上传文件")
    public Result<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return ResultGenerator.genSuccessResult(uploadManager.uploadFile(file));
    }
}