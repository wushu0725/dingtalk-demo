package com.shrek.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.shrek.example.dao.mysql.DingTalkDao;
import com.shrek.example.util.constants.DingTalkConstant;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 吴署
 * @Date: 2019/9/29 21:50
 * @Description:
 */
@Service
@Slf4j
public class DingtalkService {

    @Autowired
    private DingTalkDao dingTalkDao;

    @Autowired
    DefaultDingTalkClient defaultDingTalkClient;


    /**
     * 获取钉钉AccessToken
     * @param corpId
     * @return
     */
    public String getAccessToken(String corpId){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("corpId",corpId);
        try {
            String accessToken=this.getAccessToken(jsonObject);
            System.out.println("accessToken========"+accessToken);
            return accessToken;
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 获取用户详情
     * @param code
     * @param corpId
     * @return JSONObject
     */
    public JSONObject getUserInfoDetail(String code,String corpId){
        try {
            String accessToken = updateAccessToken(corpId);
            log.info("获取token:"+accessToken);
            //获取用户钉钉基本信息
            JSONObject userJson = this.getUserInfo(code,accessToken);

            log.info("获取用户ID:"+userJson.getString("userId"));
            //获取用户详细信息
            defaultDingTalkClient.resetServerUrl(DingTalkConstant.OAPI_GETINFODETAIL_HOST);
            OapiUserGetRequest request = new OapiUserGetRequest();
            request.setUserid(userJson.getString("userId"));
            request.setHttpMethod("GET");
            OapiUserGetResponse response = defaultDingTalkClient.execute(request, accessToken);

            log.info("获取用户详情:"+response.getName());
            JSONObject retrunJson = new JSONObject();
            retrunJson.put("userId",userJson.getString("userId"));
            retrunJson.put("name",response.getName());
            retrunJson.put("mobile",response.getMobile());
            return retrunJson;
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据code获取用户钉钉基本信息
     * @param code
     * @param accessToken
     * @return
     */
    public JSONObject getUserInfo(String code,String accessToken) throws ApiException {
        defaultDingTalkClient.resetServerUrl(DingTalkConstant.OAPI_GETINFO_HOST);
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(code);
        request.setHttpMethod("GET");
        OapiUserGetuserinfoResponse response = defaultDingTalkClient.execute(request, accessToken);
        String userId = response.getUserid();
//        System.out.println(userId);
        JSONObject returnJson = new JSONObject();
        returnJson.put("userId",userId);
        return returnJson;
    }

    /**
     * 获取钉钉token，先从本地数据库判断是否有未失效的，
     * 有 则从本地读取出来，
     * 没有 则从钉钉t端获取来，在更新到数据库并缓存
     * （最好是放缓存，此处还未加缓存）
     * @return
     */
    public String getAccessToken(JSONObject jsonObject) throws ApiException {
        JSONObject returnObject =dingTalkDao.getDingTalkCache(jsonObject);
        //失效或者不存在，重新生成accessToken并保存数据库
        if(returnObject==null){
            return updateAccessToken(jsonObject.getString("corpId"));
        }else {
            return returnObject.getString("value");
        }
    }

    private String updateAccessToken(String corpId) throws ApiException {
        defaultDingTalkClient.resetServerUrl(DingTalkConstant.OAPI_GETTOKEN_HOST);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(DingTalkConstant.APP_KEY);
        request.setAppsecret(DingTalkConstant.APP_SECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response =defaultDingTalkClient.execute(request);
        return response.getAccessToken();
    }

    /**
     * 获取微信token，先从本地数据库判断是否有未失效的，
     * 有 则从本地读取出来，
     * 没有 则从微信端获取来，在更新到数据库并缓存
     * （最好是放缓存，此处还未加缓存）
     * @return
     */
//    public String getWebChatCache(JSONObject jsonObject1) {
//
//        CommonUtil.fillOrgPk(jsonObject1);
//        JSONObject jsonObject = webChatCacheDao.getWebChatCache(jsonObject1);
//
//        if(jsonObject==null) {   //失效或者不存在，调用微信接口获取并保存数据库
//            JSONObject configObject = webchatConfigService.getByPkOrg(jsonObject1);
//            String accessToken = WebChatUtil.getAccessToken(configObject.getString("cortid"), configObject.getString("secret"));
//            String txlAccessToken = WebChatUtil.getAccessToken(configObject.getString("cortid"), configObject.getString("txlsecret"));
//            String jspApiTicket = WebChatUtil.getJSApiTicket(accessToken);
//            webChatCacheDao.deleteWebChatCache(jsonObject1);//清掉之前的数据
//            JSONObject insertObject = new JSONObject();
//            CommonUtil.fillOrgPk(insertObject);
//            //微信的token和JSapiticket默认失效2小时
//            insertObject.put("expireTime", this.getBeforeByHourTime(2));
//            insertObject.put("key", WebChatCommon.ACCESSTOKEN);
//            insertObject.put("value", accessToken);
//            webChatCacheDao.insertWebChatCache(insertObject);
//            insertObject.put("key", WebChatCommon.JSAPITICKET);
//            insertObject.put("value", jspApiTicket);
//            webChatCacheDao.insertWebChatCache(insertObject);
//            insertObject.put("key", WebChatCommon.TXLJSAPITICKET);
//            insertObject.put("value", txlAccessToken);
//            webChatCacheDao.insertWebChatCache(insertObject);
//            if(WebChatCommon.ACCESSTOKEN.equals(jsonObject1.getString("key"))){
//                return accessToken;
//            }else if(WebChatCommon.JSAPITICKET.equals(jsonObject1.getString("key"))){
//                return jspApiTicket;
//            }else {
//                return txlAccessToken;
//            }
//
//        }else {                    //有则直接从数据库返回
//            return jsonObject.getString("value");
//        }
//    }
}
