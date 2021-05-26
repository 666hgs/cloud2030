package com.atguigu.springcloud.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author hgs
 * @Date 2021/5/8 21:27
 * @Version 1.0
 */
//@Component
@Async
@Slf4j
public class ScheduledTasks {

    // cron接受cron表达式，根据cron表达式确定定时规则

    @Scheduled(cron="0/5 * * * * ? ")  //每5秒执行一次
    @Async("executor1")
    public void testCorn(){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sdf.format(new Date())+"*********每5秒执行一次testCorn()");
    }
}
