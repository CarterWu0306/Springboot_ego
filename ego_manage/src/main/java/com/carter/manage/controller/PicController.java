package com.carter.manage.controller;

import com.carter.manage.service.PicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Controller
public class PicController {
    @Resource
    private PicService picServiceImpl;

    @RequestMapping("pic/upload")


    @ResponseBody
    public Map<String,Object> upload(@RequestParam("uploadFile")MultipartFile uploadFile) throws IOException {
        Map<String,Object> map = null;
        try {
            map = picServiceImpl.upload(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error", 1);
            map.put("message","上传图片时服务器异常");
        }
        return map;
    }
}
