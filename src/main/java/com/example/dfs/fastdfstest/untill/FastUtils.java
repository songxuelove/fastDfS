//package com.example.dfs.fastdfstest.untill;
//
//
//
//import org.csource.common.MyException;
//import org.csource.fastdfs.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Date;
//
///**
// *
// * 文件上传工具类
// */
//public class FastUtils {
//
//    private static StorageClient1 client1 ;
//    static {
//        try {
//            ClientGlobal.initByProperties("fastdfs-client.properties");
//            // 创建一个TrackerClient对象
//            TrackerClient trackerClient = new TrackerClient();
//            // 创建一个TrackerServer对象
//            TrackerServer trackerServer = trackerClient.getConnection();
//            // 声明一个StorageServer对象，null
//            StorageServer storageServer = null;
//            storageServer = trackerClient.getStoreStorage(trackerServer);
//            String storageIp = storageServer.getSocket().getInetAddress().getHostAddress();
//            Integer port = storageServer.getSocket().getPort();
//            Integer storePath = DateUtils.getEveryMonth(new Date());
//            storageServer = new StorageServer(storageIp, port, storePath);
//            client1 = new StorageClient1(trackerServer, storageServer);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        catch (MyException e){
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static String upload(MultipartFile file){
//        String oldName = file.getOriginalFilename();
//
//        try {
//            return client1.upload_file1(file.getBytes(),oldName.substring(oldName.lastIndexOf(".") + 1),null);
//
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        catch (MyException e){
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//}
//
//
