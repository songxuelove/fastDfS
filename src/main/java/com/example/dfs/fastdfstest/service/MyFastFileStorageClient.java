package com.example.dfs.fastdfstest.service;

import com.github.tobato.fastdfs.domain.conn.TrackerConnectionManager;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorageNode;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.TrackerLocator;
import com.github.tobato.fastdfs.domain.proto.storage.StorageSetMetadataCommand;
import com.github.tobato.fastdfs.domain.proto.storage.StorageUploadFileCommand;
import com.github.tobato.fastdfs.domain.proto.storage.enums.StorageMetadataSetType;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author songxue
 * @date 2022-02-14 16:42
 */
@Component
public class MyFastFileStorageClient extends DefaultFastFileStorageClient {

    public StorePath uploadFile(FastFile fastFile, int storePath) {
        Validate.notNull(fastFile.getInputStream(), "上传文件流不能为空", new Object[0]);
        Validate.notBlank(fastFile.getFileExtName(), "文件扩展名不能为空", new Object[0]);
        StorageNode client = this.getStorageNode(fastFile.getGroupName());
        return this.uploadFileAndMetaData(storePath, client, fastFile.getInputStream(), fastFile.getFileSize(), fastFile.getFileExtName(), fastFile.getMetaDataSet());
    }

    private StorageNode getStorageNode(String groupName) {
        return null == groupName ? this.trackerClient.getStoreStorage() : this.trackerClient.getStoreStorage(groupName);
    }

    public StorePath uploadFileAndMetaData(int storePath, StorageNode client, InputStream inputStream, long fileSize, String fileExtName, Set<MetaData> metaDataSet) {

        client.setStoreIndex((byte) (storePath - 256));

        StorageUploadFileCommand command = new StorageUploadFileCommand(client.getStoreIndex(), inputStream, fileExtName, fileSize, false);
        StorePath path = (StorePath)this.connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
        if (this.hasMetaData(metaDataSet)) {
            StorageSetMetadataCommand setMDCommand = new StorageSetMetadataCommand(path.getGroup(), path.getPath(), metaDataSet, StorageMetadataSetType.STORAGE_SET_METADATA_FLAG_OVERWRITE);
            this.connectionManager.executeFdfsCmd(client.getInetSocketAddress(), setMDCommand);
        }
        return path;
    }

    private boolean hasMetaData(Set<MetaData> metaDataSet) {
        return null != metaDataSet && !metaDataSet.isEmpty();
    }

}
