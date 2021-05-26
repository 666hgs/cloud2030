package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;


@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果:" + payment + "\t" + "哇哈哈哈哈哈哈哈哈哈哇哇哇哇");

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID:" + id, null);
        }


    }

    public static  void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("猛男","泰森");
        map.put("猛女","莫干那");
        for (String value : map.values()){
            System.out.println("value="+value);
        }

    }
}