package com.enki.service;

import com.enki.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Enki
 * @ClassName OssUploadService
 * @Description: TODO
 * @Date 2023/10/4 10:55
 * @Version 1.0
 */
public interface OssUploadService {
    //图片上传到七牛云
    ResponseResult uploadImg(MultipartFile img);
}
