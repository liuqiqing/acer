package com.inspur.service.impl;

import com.inspur.dao.blsp.BlspMapper;
import com.inspur.dao.syck.SyckMapper;
import com.inspur.service.BlspService;
import com.inspur.service.SyckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SyckServiceImpl implements SyckService {

    @Autowired
    private SyckMapper syckMapper;
    //测试
    @Override
    public int getSum() {
        return syckMapper.getSum();
    }



    //省收件数

    @Override
    public int ssjs(String Cdate) {
        return syckMapper.ssjs(Cdate);
    }
    //省收件时间排行
    @Override
    public List<Map<String, Object>> ssjph(String Cdate) {
        return syckMapper.ssjph(Cdate);
    }
}
