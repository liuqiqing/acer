package com.inspur.service;

import java.util.List;
import java.util.Map;

public interface PdjhService {

    // 查询当天所有的叫号数量(不分组)
    int getSum(String Cdate);

    // 查询当天所有的叫号数量（正在处理、已放弃、等待、处理完毕 、已预订）
    List<Map<String, Object>> getpdjhsl(String Cdate);

    // 排队叫号每天处理业务前10的窗口
    List<Map<String, Object>> getckqs(String Cdate);

    // 每天排队等候的时间(平均)
    List<Map<String, Object>> getpddhsj(String Cdate);

    // 分组查询排队叫号时间的数量
    List<Map<String, Object>> getsjsum(String Cdate);

    /*排队完毕*/
    int pdwbsum(String Cdate);

    //排队等待
    int pdddsum(String Cdate);

    //排队处理中
    int pdclsum(String Cdate);

    //空闲窗口
    int kxcksum(String Cdate);

    /*窗口总数*/
    int ckzssum(String Cdate);
    /*排队等待柱状图  */
    List<Map<String, Object>> getpdddinfo(String year, String month, String day, String page);
    //排队等待下载
    List<Map<String, Object>>downloadzpddd(String year, String month, String day);

    //获取空闲窗口数
    public List<Map<String, Object>> getckkxck(String year, String month, String day, String page);
    //下载空闲窗口
    List<Map<String, Object>> downloadkxck(String year, String month, String day, String page);

}
