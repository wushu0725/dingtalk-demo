package com.shrek.example.controller;

import com.shrek.example.service.ReportTestService;
import com.shrek.example.service.impl.HydeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.alibaba.fastjson.JSONObject;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.shrek.example.util.CommonUtil;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/reportTest")
public class ReportTestController {

    @Autowired
    private ReportTestService reportTestService;

    @Autowired
    private HydeeService hydeeService;

    @PostMapping
    public JSONObject insert(@RequestBody JSONObject requestJson) {
        return reportTestService.insert(requestJson);
    }

    @PutMapping
    public JSONObject update(@RequestBody JSONObject requestJson) {
        return reportTestService.update(requestJson);
    }

    @DeleteMapping
    public JSONObject delete(HttpServletRequest request) {
        return reportTestService.delete(Long.valueOf(request.getParameter("id")));
    }

    @GetMapping
    public JSONObject list(HttpServletRequest request) {
        JSONObject jsonObject=CommonUtil.request2Json(request);
        return reportTestService.list(jsonObject);
    }

    @GetMapping("/test")
    public JSONObject list2(HttpServletRequest request) {
        return reportTestService.list2();
    }

    @GetMapping("/test2")
    public JSONObject list3(HttpServletRequest request) {
        return hydeeService.report1();
    }

    @GetMapping("/hydee")
    public JSONObject hydee(HttpServletRequest request) {
        return hydeeService.report1();
    }
}