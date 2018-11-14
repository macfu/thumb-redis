package com.macfu.config;

import com.macfu.task.LikeTask;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liming
 * @Date: 2018/11/13 19:42
 * @Description: 注入定时调度Bean
 */
@Configuration
public class QuartzConfig {

    private static final String LIKE_TASK_IDENTITY = "LikeTaskQuartz";

    @Bean
    public JobDetail quartzDetail() {
        return JobBuilder.newJob(LikeTask.class).withIdentity(LIKE_TASK_IDENTITY).storeDurably().build();
    }

    @Bean
    public Trigger quartzTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInHours(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(quartzDetail()).withIdentity(LIKE_TASK_IDENTITY)
                .withSchedule(scheduleBuilder).build();
    }

}
