package com.example.dfs.fastdfstest;

import com.example.dfs.fastdfstest.service.MyFastFileStorageClient;
import com.example.dfs.fastdfstest.untill.DateFormatUtils;
import com.example.dfs.fastdfstest.untill.DateUtils;


import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

@SpringBootApplication
public class FastDfsTestApplication {
    @Autowired
    private MyFastFileStorageClient fastFileStorageClient;

    public static void main(String[] args) {
        SpringApplication.run(FastDfsTestApplication.class, args);
    }

    @Test
    public void day(){
        DateUtils.getEveryMonth(new Date());
        //System.out.println();
    }






}
