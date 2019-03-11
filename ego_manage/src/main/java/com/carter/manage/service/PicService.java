package com.carter.manage.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface PicService {
    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    Map<String,Object> upload(MultipartFile file) throws IOException;
}
