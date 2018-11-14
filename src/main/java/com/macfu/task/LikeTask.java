package com.macfu.task;

import com.macfu.service.LikedService;
import com.macfu.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Author: liming
 * @Date: 2018/11/14 14:24
 * @Description: 点赞的定时任务调度
 */
@Slf4j
public class LikeTask extends QuartzJobBean {
    @Autowired
    LikedService likedService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("LIkeTask ---------{}", DateUtils.getYYYYMMDDSecond(new Date()));
        // 将Redis里的点赞信息同步到数据库里面
    }
}
