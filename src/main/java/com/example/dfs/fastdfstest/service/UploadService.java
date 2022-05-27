package com.example.dfs.fastdfstest.service;



import com.example.dfs.fastdfstest.untill.DateUtils;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

/**
 * @author songxue
 * @date 2022-1-13 10:27
 * @param
 * @return
 * @other
 **/

@Slf4j
@Service
public class UploadService {

    @Autowired
    private MyFastFileStorageClient fastFileStorageClient;


    public void upload(String file) {
        if (null == file) {
            return;
        }
        //上传图片
        // base64编码格式到fastDFS
        byte[] picBuf = Base64.getMimeDecoder().decode(file);
        //byte[] byteArr = PicUtil.stringToInputStream(file);
        InputStream stream = new ByteArrayInputStream(picBuf);
        //ByteArrayInputStream stream = new ByteArrayInputStream(picBuf);

        // 上传并且生成缩略图 1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
        FastFile fastFile = (new FastFile.Builder()).withFile(stream, picBuf.length, "jpg").build();
        int storePath = DateUtils.getEveryMonth(new Date());
        StorePath path = fastFileStorageClient.uploadFile(fastFile, storePath);
        //StorePath path = fastFileStorageClient2.uploadFile(fastFile);
        //StorePath storePath = fastFileStorageClient2.uploadImageAndCrtThumbImage(stream, picBuf.length, "jpg", null);
        // StorePath storePath = fastFileStorageClient.uploadFileByStorePath(2, stream, picBuf.length, "jpg", null);

        System.out.println(path);


    }
}
