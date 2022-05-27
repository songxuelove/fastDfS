package com.example.dfs.fastdfstest.service;

import com.github.tobato.fastdfs.domain.conn.TrackerConnectionManager;
import com.github.tobato.fastdfs.domain.fdfs.TrackerLocator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author songxue
 * 项目启动监听器
 * @date 2022-05-23 19:48
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private final TrackerConnectionManager trackerConnectionManager;

    @Value("${fdfs.retry-after-second}")
    private Integer retryAfterSecond;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("修改fastDFS重连时间为" + retryAfterSecond + "秒");
        try {
            Field field = trackerConnectionManager.getClass().getDeclaredField("trackerLocator");
            // 使用工具类
            ReflectionUtils.makeAccessible(field);
            TrackerLocator trackerLocator = (TrackerLocator) field.get(trackerConnectionManager);
            trackerLocator.setRetryAfterSecend(retryAfterSecond);
            ReflectionUtils.setField(field, trackerConnectionManager, trackerLocator);
            log.info("修改fastDFS重连时间成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
