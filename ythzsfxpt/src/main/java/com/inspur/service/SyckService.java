package com.inspur.service;

import java.util.List;
import java.util.Map;

public interface SyckService {

    int getSum();
    //省收件数
    int ssjs(String Cdate);
    //省收件时间排行
    List<Map<String, Object>> ssjph(String Cdate);
}
