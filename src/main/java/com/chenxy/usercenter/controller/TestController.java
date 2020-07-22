package com.chenxy.usercenter.controller;

import com.chenxy.common.controller.BaseController;
import com.chenxy.common.exception.BusinessException;
import com.chenxy.common.exception.BusinessExceptionEnum;
import com.chenxy.common.result.CommonResult;
import com.chenxy.usercenter.pojo.DO.UserDO;
import com.chenxy.usercenter.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserService userService;

    @GetMapping("/test1")
    public String test1(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String ss = dateTimeFormatter.format(localDateTime).toString();
        return ss;
    }

    @GetMapping("/test4")
    public CommonResult test4(){
        UserDO userDO = new UserDO();
        userDO.setId(1);
        userDO.setUsername("hhh");
        redisTemplate.opsForValue().set("test:test3",userDO);
        stringRedisTemplate.opsForValue().set("test:test4","test4");
        return CommonResult.create(null);
    }

}
