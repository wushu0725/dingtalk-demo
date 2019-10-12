package com.shrek.example.service.impl;


import com.shrek.example.dao.mysql.ReportTestDao;
import com.alibaba.fastjson.JSONObject;
import com.shrek.example.service.ReportTestService;
import com.shrek.example.util.CommonUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${comments}
 *
 * @author Wushu
 * @email 156810150@qq.com
 * @date 2019-10-11 14:41:39
 */
@Service
public class ReportTestServiceImpl implements ReportTestService {

    @Autowired
    private ReportTestDao reportTestDao;

    @Override
    public JSONObject update(JSONObject jsonObject){
        reportTestDao.update(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject insert(JSONObject jsonObject){
        reportTestDao.insert(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject list(JSONObject jsonObject){
        CommonUtil.fillPageParam(jsonObject);
        int count = reportTestDao.count(jsonObject);
        List<JSONObject> list = reportTestDao.listByPage(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject list2() {
        return CommonUtil.successJson(reportTestDao.list());
    }

    @Override
    public JSONObject delete (Long id){
        reportTestDao.delete(id);
        return CommonUtil.successJson();
    }
}