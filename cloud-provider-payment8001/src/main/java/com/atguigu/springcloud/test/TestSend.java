package com.atguigu.springcloud.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author hgs
 * @Date 2021/5/11 13:47
 * @Version 1.0
 */
@Component
@Async
public class TestSend {

    //rabbitmq跟springboot整合，springboot提供了模板给我们使用。
    //例如：restTemplate redisTemplate thymeleafTemplate
    @Autowired
    RabbitTemplate rabbitTemplate;

    //广播订阅模式
    // cron接受cron表达式，根据cron表达式确定定时规则

    @Scheduled(cron="0/5 * * * * ? ")  //每5秒执行一次
    @Async("executor1")
    public void testSendPublish(){
        Map map=new HashMap<>();
        map.put("name","张三");
        map.put("age",18);
        //1.交换机的名称  2.你的规则，发布订阅模式为空 3.消息的主题
        rabbitTemplate.convertAndSend("publish-exchange","",map);

    }

}
