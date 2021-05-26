package com.atguigu.springcloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author hgs
 * @Date 2021/5/11 13:44
 * @Version 1.0
 */

@Configuration
public class RabbitMqConfig {

    //发布订阅模式
    //声明了队列
    @Bean(name = "queue1")
    public Queue queue(){
        return new Queue("publish-queue1");
    }

    @Bean(name = "queue2")
    public Queue queue2(){
        return new Queue("publish-queue2");
    }
    //广播的交换机
    //声明交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("publish-exchange");
    }
    //将队列绑定到交换机
    @Bean
    Binding bindQueue1ToFanoutExchange(@Qualifier("queue1")Queue queue, FanoutExchange  fanoutExchange){
        return   BindingBuilder.bind(queue).to(fanoutExchange);
    }
    //将队列绑定到交换机
    @Bean
    Binding bindQueue2ToFanoutExchange(@Qualifier("queue2")Queue queue,FanoutExchange  fanoutExchange){
        return   BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
