package com.shrek.example.dao.mysql;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DingTalkDao {

    /**
     * 获取dingTalk信息
     * @param jsonObject
     * @return
     */
    JSONObject getDingTalkCache(JSONObject jsonObject);

    /**
     * 删除dingTalk信息
     *
     * @param jsonObject
     * @return
     */
    int deleteDingTalkCache(JSONObject jsonObject);

    /**
     * 插入dingTalk信息
     *
     * @param jsonObject
     * @return
     */
    int insertDingTalkCache(JSONObject jsonObject);
}
