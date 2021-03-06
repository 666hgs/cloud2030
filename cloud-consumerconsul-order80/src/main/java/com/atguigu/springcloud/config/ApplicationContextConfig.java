package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author hgs
 * @Date 2021/3/21 15:45
 * @Version 1.0
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
