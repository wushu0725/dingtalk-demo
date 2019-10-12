package com.shrek.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shrek.example.dao.paiban.HydeeDao;
import com.shrek.example.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 吴署
 * @Date: 2019/10/12 13:09
 * @Description:
 */

@Service
@Slf4j
public class HydeeService {
    @Autowired
    private HydeeDao hydeeDao;

    public JSONObject report1(){
        return CommonUtil.successJson(hydeeDao.report1());
    }

}
