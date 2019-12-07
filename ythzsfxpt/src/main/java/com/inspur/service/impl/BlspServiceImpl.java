package com.inspur.service.impl;

import com.inspur.dao.blsp.BlspMapper;
import com.inspur.service.BlspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BlspServiceImpl implements BlspService {

    @Autowired
    private BlspMapper blspMapper;

    @Override
    public int getSum() {
        return blspMapper.getSum();
    }

    // 获取项目总数量
    @Override
    public int getprojectsum() {
        return blspMapper.getprojectsum();
    }

    @Override
    public List<Map<String, Object>> getzjsum() {
        return blspMapper.getzjsum();
    }

    @Override
    public int getjnssum() {
        return blspMapper.getjnssum();
    }
    // 获取区县项目数量
    @Override
    public int getqxsum() {
        return blspMapper.getqxsum();
    }
    // 获取社会投资建设项目数量
    @Override
    public int getshtz() {
        return blspMapper.getshtz();
    }
    //  获取公共投资建设项目数量
    @Override
    public int getggjs() {
        return blspMapper.getggjs();
    }
    //  获取项目类别
    @Override
    public List<Map<String, Object>> getxmlb() {
        return blspMapper.getxmlb();
    }
    //  获取项目类型
    @Override
    public List<Map<String, Object>> getxmlx() {
        return blspMapper.getxmlx();
    }
    //  各区划项目数量
    @Override
    public List<Map<String, Object>> getqhxmsl() {
        return blspMapper.getqhxmsl();
    }
    //  项目金额分布情况
    @Override
    public List<Map<String, Object>> getxmzjfb() {
        return blspMapper.getxmzjfb();
    }
    // 项目申报情况统计
    @Override
    public List<Map<String, Object>> getsbqktj() {
        return blspMapper.getsbqktj();
    }
    // 业务状态统计
    @Override
    public List<Map<String, Object>> getywzttj(String stageid) {
        return blspMapper.getywzttj(stageid);
    }
    // 每月联办业务受理数
    @Override
    public List<Map<String, Object>> getlbywsls() {
        return blspMapper.getlbywsls();
    }
    //  获取项目数量
    @Override
    public List<Map<String, Object>> getproject() {
        return blspMapper.getproject();
    }
}
