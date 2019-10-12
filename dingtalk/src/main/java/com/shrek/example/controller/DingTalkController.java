package com.shrek.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.shrek.example.service.impl.DingtalkService;
import com.shrek.example.util.CommonUtil;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 吴署
 * @Date: 2019/9/29 21:35
 * @Description:
 */

@RestController
@RequestMapping("user")
public class DingTalkController {

    @Autowired
    DefaultDingTalkClient defaultDingTalkClient;
    @Autowired
    DingtalkService dingtalkService;

    @GetMapping("getUserInfo")
    public JSONObject getUserInfo(HttpServletRequest request) throws ApiException {
        JSONObject jsonObject=CommonUtil.request2Json(request);
        String code=jsonObject.getString("code");
        String corpId=jsonObject.getString("corpId");
        System.out.println("code="+code);
        return CommonUtil.successJson(dingtalkService.getUserInfoDetail(code,corpId));
    }
}
