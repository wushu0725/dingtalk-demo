package com.shrek.example.util.constants;

/**
 * @Auther: 吴署
 * @Date: 2019/9/29 15:43
 * @Description: 钉钉常量类
 */

public class DingTalkConstant {

    /**
     * 企业corpid
     */
    public static final String CORP_ID = "dingdaf39d3210fa34f435c2f4657eb6378f";

    /**
     * 应用agentId
     */
    public static final String AGENT_ID = "296972044";

    /**
     * 应用的appkey
     */
    public static final String APP_KEY = "dingqncis2jqsmg0oh09";

    /**
     * 应用的appsecret
     */
    public static final String APP_SECRET = "0caOq8ETuXpXLEByvvv7HXLH2IGLv9U-RFqsP6yous11XU0LaKUpEvUDRUPcxyZB";

    /**
     * 回调host
     */
    public static final String CALLBACK_URL_HOST = "http://www.shrek11.cn/ding-app-demo";

    /**
     * 加解密需要用到的token，企业可以随机填写。如 "123456"
     */
    public static final String TOKEN = "123456";

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    public static final String ENCODING_AES_KEY = "abcdefghijabcdefghijabcdefghijabcdefghij123";

    /**
     * DING API地址
     */
    public static final String OAPI_HOST = "https://oapi.dingtalk.com";

    /**
     * 获取用户信息
     */
    public static final String OAPI_GETINFO_HOST =OAPI_HOST+"/user/getuserinfo";

    /**
     * 获取用户详情
     */
    public static final String OAPI_GETINFODETAIL_HOST = OAPI_HOST+"/user/get";

    /**
     * 获取钉钉token
     */
    public static final String OAPI_GETTOKEN_HOST=OAPI_HOST+"/gettoken";

}
