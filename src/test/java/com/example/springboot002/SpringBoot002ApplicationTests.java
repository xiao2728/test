package com.example.springboot002;

import com.example.springboot002.dao.DetailMapper;
import com.example.springboot002.pojo.Detail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringBoot002Application.class)
class SpringBoot002ApplicationTests {
@Autowired
private DetailMapper detailDao;
    @Test
    void contextLoads() {
        Detail detail = detailDao.getDetailById(1L);
        System.out.println(detail);
    }

}
