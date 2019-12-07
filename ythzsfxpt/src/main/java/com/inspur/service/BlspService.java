package com.inspur.service;

import java.util.List;
import java.util.Map;

public interface BlspService {

    int getSum();

    // 获取项目数量
    int getprojectsum();

    //  获取投资总额
    List<Map<String, Object>> getzjsum();

    // 获取市本级项目数量
    int getjnssum();

    // 获取区县项目数量
    int getqxsum();

    // 获取社会投资建设项目数量
    int getshtz();

    //  获取公共投资建设项目数量
    int getggjs();

    //  获取项目类别
    List<Map<String, Object>> getxmlb();

    //  获取项目类型
    List<Map<String, Object>> getxmlx();

    //  各区划项目数量
    List<Map<String, Object>> getqhxmsl();

    //  项目金额分布情况
    List<Map<String, Object>> getxmzjfb();

    // 项目申报情况统计
    List<Map<String, Object>> getsbqktj();

    //业务状态统计
    List<Map<String, Object>> getywzttj(String stageid);

    //  每月联办业务受理数
    List<Map<String, Object>> getlbywsls();

    //  获取项目数量
    List<Map<String, Object>> getproject();
}
