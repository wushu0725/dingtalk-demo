package com.shrek.example.dao.mysql;

import com.alibaba.fastjson.JSONObject;
import com.shrek.example.util.CommonUtil;
import java.util.List;
/**
 * ${comments}
 * 
 * @author Wushu
 * @email 156810150@qq.com
 * @date 2019-10-11 14:41:39
 */

public interface ReportTestDao {
    int update(JSONObject jsonObject);

    int insert(JSONObject jsonObject);

    List<JSONObject> listByPage(JSONObject jsonObject);

    List<JSONObject> list();

    int delete(Long id);

    int count(JSONObject jsonObject);
}
