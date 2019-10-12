package com.shrek.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HydeeServiceTest {

    @Autowired
    private HydeeService hydeeService;

    @Test
    public void report1() throws Exception {
        JSONObject jsonObject=hydeeService.report1();
        System.out.println(jsonObject.toJSONString());
    }

}