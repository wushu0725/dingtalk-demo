package com.shrek.example.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.shrek.example.util.constants.DingTalkConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DingtalkServiceTest {

    @Autowired
    DefaultDingTalkClient defaultDingTalkClient;

    @Test
    public void getAccessToken() throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");

        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode("f7550565ed4f35ad866edd2955f7979e");
        request.setHttpMethod("GET");
        OapiUserGetuserinfoResponse response = client.execute(request, "b5544ffb45133c16ad48610192b63142");
        String userId = response.getUserid();
        System.out.println(userId);


    }
    @Test
    public void getAccessToken2() throws Exception {
        defaultDingTalkClient.resetServerUrl(DingTalkConstant.OAPI_GETINFO_HOST);
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode("e37d5e7801e03c94baa0b638c654f4f9");
        request.setHttpMethod("GET");
        OapiUserGetuserinfoResponse response = defaultDingTalkClient.execute(request, "b5544ffb45133c16ad48610192b63142");
        String userId = response.getUserid();
        System.out.println(userId);

        defaultDingTalkClient.resetServerUrl(DingTalkConstant.OAPI_GETINFODETAIL_HOST);
        OapiUserGetRequest request2 = new OapiUserGetRequest();
        request2.setUserid(userId);
        request2.setHttpMethod("GET");
        OapiUserGetResponse response2 = defaultDingTalkClient.execute(request2, "b5544ffb45133c16ad48610192b63142");

        System.out.println("name:"+response2.getName()
                        +"   "+response2.getMobile()+ "   "+response2.getNickname());
        System.out.println(response2.toString());
    }

}