package com.shrek.example.config.dingtalk;

import com.dingtalk.api.DefaultDingTalkClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 吴署
 * @Date: 2019/9/29 15:46
 * @Description:
 */
@Configuration
public class DefaultDingTalkClientBean {

    @Bean
    public DefaultDingTalkClient getDefaultDingTalkClient(){
        DefaultDingTalkClient defaultDingTalkClient=new DefaultDingTalkClient(null);
        return defaultDingTalkClient;
    }
}
