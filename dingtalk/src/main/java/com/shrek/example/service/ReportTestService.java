package com.shrek.example.service;


import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * ${comments}
 *
 * @author Wushu
 * @email 156810150@qq.com
 * @date 2019-10-11 14:41:39
 */
public interface ReportTestService {
    JSONObject update(JSONObject jsonObject);

    JSONObject insert(JSONObject jsonObject);

    JSONObject list(JSONObject jsonObject);
    JSONObject list2();

    JSONObject delete(Long id);
}