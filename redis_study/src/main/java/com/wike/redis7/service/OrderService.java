package com.wike.redis7.service;

import io.netty.util.SuppressForbidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author wujiang
 * @create 2023-04-10 17:51
 */
@Service
@Slf4j
public class OrderService {

    public static final String ORDER_KEY = "ord:";
    @Resource
    private RedisTemplate redisTemplate;


    /**
      * @MethodName addOrder
      * @Description
      * @Author wike
      * @Date 2023/4/11 11:52
      */
    public void addOrder(){
        int keyId = ThreadLocalRandom.current().nextInt(1000)+1;
        String serialNo = UUID.randomUUID().toString();

        String key = ORDER_KEY + keyId;
        String value = "京东订单"+ serialNo;

        redisTemplate.opsForValue().set(key,value);
        System.out.println("***key***:"+key);
        System.out.println("***value***:"+value);
    }
    /**
     * @MethodName getOrderById
     * @Description
     * @param keyId
     * @return String
     * @throws
     * @Author wike
     * @Date 2023/4/11 12:07
     */
    public String getOrderById(Integer keyId){

        return (String) redisTemplate.opsForValue().get(ORDER_KEY+keyId);
    }



}
