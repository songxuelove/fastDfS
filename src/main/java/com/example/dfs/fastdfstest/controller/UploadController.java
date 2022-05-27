package com.example.dfs.fastdfstest.controller;

/**
 * @author songxue
 * @date 2022-01-13 10:29
 */

import com.example.dfs.fastdfstest.service.UploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

import java.io.IOException;

@Resource
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @PostMapping("/import")
    public String importData(String file) throws Exception {

        uploadService.upload(file);
        return "已经实现了";
    }
}
