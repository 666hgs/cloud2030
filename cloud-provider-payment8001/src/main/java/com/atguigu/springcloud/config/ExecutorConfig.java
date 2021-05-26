package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.Serializable;
import java.util.concurrent.*;

/**
 * @Description
 * @Author hgs
 * @Date 2021/5/8 21:43
 * @Version 1.0
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Bean
    public Executor executor1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("test-schedule1-");
        executor.setMaxPoolSize(20);
        executor.setCorePoolSize(15);
        executor.setQueueCapacity(0);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
