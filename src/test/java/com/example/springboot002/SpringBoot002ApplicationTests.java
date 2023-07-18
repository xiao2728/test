package com.example.springboot002;

import com.example.springboot002.mapper.DetailMapper;
import com.example.springboot002.pojo.Detail;
import com.example.springboot002.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = SpringBoot002Application.class)
class SpringBoot002ApplicationTests {
@Autowired
private DetailMapper detailDao;
@Autowired
private RedisUtil redisUtil;
    @Test
    void contextLoads() {
        Detail detail = detailDao.getDetailById(1L);
        System.out.println(detail);
    }
    @Test
    public void setRedis(){
    redisUtil.putValue("1","123456",2l, TimeUnit.MINUTES);
    }
}
