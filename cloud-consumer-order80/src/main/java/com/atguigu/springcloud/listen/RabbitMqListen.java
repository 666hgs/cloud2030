package com.atguigu.springcloud.listen;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author hgs
 * @Date 2021/5/11 13:58
 * @Version 1.0
 */
@Component
public class RabbitMqListen {
    @RabbitListener(queues = "publish-queue1")
    public void  publishQueue(Map str){

        System.out.println("publish-queue1当前监听到了："+str);
    }

    @RabbitListener(queues = "publish-queue2")
    public void  publishQueue2(Map str){

        System.out.println("publish-queue2 当前监听到了："+str);
    }



}
