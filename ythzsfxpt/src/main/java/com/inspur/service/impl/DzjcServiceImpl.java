package com.inspur.service.impl;

import com.inspur.dao.dzjc.dzjcMapper;
import com.inspur.dao.dzzz.dzzzMapper;
import com.inspur.service.DzjcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DzjcServiceImpl implements DzjcService {

    @Autowired
    private dzjcMapper dzjcmapper;

    // 获取短信评价的信息
    @Override
    public List<Map<String, Object>> getwspjxx() {
        return dzjcmapper.getwspjxx();
    }

}
