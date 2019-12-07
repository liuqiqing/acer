package com.inspur.service.impl;

import com.inspur.dao.pdjh.PdjhMapper;
import com.inspur.service.PdjhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PdjhServiceImpl implements PdjhService  {


    @Autowired
    private PdjhMapper pdjhMapper;
    // 查询当天所有的叫号数量(不分组)
    @Override
    public int getSum(String Cdate) {
        return pdjhMapper.getSum(Cdate);
    }

    // 查询当天所有的叫号数量（正在处理、已放弃、等待、处理完毕）
    @Override
    public List<Map<String, Object>> getpdjhsl(String Cdate) {
        return pdjhMapper.getpdjhsl(Cdate);
    }

    // 排队叫号每天处理业务前10的窗口
    @Override
    public List<Map<String, Object>> getckqs(String Cdate) {
        return pdjhMapper.getckqs(Cdate);
    }

    //  每天排队等候的时间(平均)
    @Override
    public List<Map<String, Object>> getpddhsj(String Cdate) {
        return pdjhMapper.getpddhsj(Cdate);
    }

    @Override
    public List<Map<String, Object>> getsjsum(String Cdate) {
        return pdjhMapper.getsjsum(Cdate);
    }

    //排队完毕
    @Override
    public int pdwbsum(String Cdate) {
        return pdjhMapper.pdwbsum(Cdate);
    }
    //排队等待
    @Override
    public int pdddsum(String Cdate) {
        return pdjhMapper.pdddsum(Cdate);
    }
    //排队处理
    @Override
    public int pdclsum(String Cdate) {
        return pdjhMapper.pdclsum(Cdate);
    }
    //空闲窗口
    @Override
    public int kxcksum(String Cdate) {
        return pdjhMapper.kxcksum(Cdate);
    }
    //窗口总数
    @Override
    public int ckzssum(String Cdate) {
        return pdjhMapper.ckzssum(Cdate);
    }
    /*排队等待柱状图*/
    @Override
    public List<Map<String, Object>> getpdddinfo(String year, String month, String day,String page) {
        return pdjhMapper.getpdddinfo(year, month, day,page);
    }
    //排队等待下载
    @Override
    public List<Map<String, Object>> downloadzpddd(String year, String month, String day) {
        return pdjhMapper.downloadzpddd(year, month, day);
    }

    //空闲窗口统计
    @Override
    public List<Map<String, Object>> getckkxck(String year, String month, String day, String page) {
        return pdjhMapper.getckkxck(year,month,day,page) ;
    }

    //在办窗口下载
    @Override
    public List<Map<String, Object>> downloadkxck(String year, String month, String day, String page) {
        return pdjhMapper.downloadkxck(year, month, day, page) ;
    }


}
