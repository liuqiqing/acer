package com.inspur.service.impl;

import com.inspur.dao.dtgl.DtglMapper;
import com.inspur.service.DtglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DtglServiceImpl implements DtglService {

    @Autowired
    private DtglMapper dtglMapper;

    // 获取短信评价 当月
    @Override
    public List<Map<String, Object>> getdxpjxx(String Cdate) {
        return dtglMapper.getdxpjxx(Cdate);
    }

    @Override
    public List<Map<String, Object>> getmsgxx(String Cdate) {
        return dtglMapper.getmsgxx(Cdate);
    }
}
