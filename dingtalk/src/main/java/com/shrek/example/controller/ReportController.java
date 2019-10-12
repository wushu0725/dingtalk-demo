package com.shrek.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.shrek.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("report")
public class ReportController {



    /**
     * 首页接口
     * @param request
     * @return
     */
    @PostMapping("test")
    public JSONObject index(HttpServletRequest request) {
        JSONObject jsonObject=CommonUtil.request2Json(request);
        JSONObject requestJson = new JSONObject();


        return requestJson;
    }

}