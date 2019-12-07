package com.inspur.service.impl;

import com.inspur.dao.spyh.spyhMapper;
import com.inspur.dao.tysl.TyslMapper;
import com.inspur.service.TyslService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TyslServiceImpl implements TyslService {
    @Autowired
    private TyslMapper tyslMapper;
    @Autowired
    private spyhMapper spyhmapper;

    @Override
    public int getSum() {
        return tyslMapper.getSum();
    }


    // 获取每天的一窗收件数量
    @Override
    public List<Map<String, Object>> getycsjsl(String Cdate) {
        return tyslMapper.getycsjsl(Cdate);
    }

    // 获取一窗收件变化趋势
    @Override
    public List<Map<String, Object>> getycsjqs() {
        return tyslMapper.getycsjqs();
    }
    // 获取一窗收件事项列表
    @Override
    public List<Map<String, Object>> getycsjlb(String Cdate,int page) {
        return tyslMapper.getycsjlb(Cdate, page);
    }

    // 下载一窗收件事项列表
    @Override
    public List<Map<String, Object>> downloadsxlb(String Cdate) {
        return tyslMapper.downloadsxlb(Cdate);
    }

    //  各业务处室一窗办理次数排名
    @Override
    public List<Map<String, Object>> getbmblsl(String year, String month, String day,String page) {
        return tyslMapper.getbmblsl(year, month, day, page);
    }
    //  下载各业务处室一窗办理数量
    @Override
    public List<Map<String, Object>> downloadbmblsl(String year, String month, String day, String page) {
        return tyslMapper.downloadbmblsl(year, month, day, page);
    }
    // 获取窗口人员办件情况
    @Override
    public List<Map<String, Object>> getckrybjqk(String year, String month, String day,String page) {
        return tyslMapper.getckrybjqk(year, month, day, page);
    }
    //本日办结数
    @Override
    public int brbjsum(String Cdate) {
        return tyslMapper.brbjsum(Cdate);
    }

    //本日受理数
    @Override
    public int brslsum(String Cdate) {
        return tyslMapper.brslsum(Cdate);
    }
    /*在办窗口柱状图*/
    @Override
    public List<Map<String, Object>> getckxxqk(String year, String month, String day, String page) {
        return tyslMapper.getckxxqk(year,month,day,page);
    }
    //下载在办窗口
    @Override
    public List<Map<String, Object>> downloadzbck(String year, String month, String day, String page) {
        return tyslMapper.downloadzbck(year,month,day,page);
    }
    /*w网上收件数*/
    @Override
    public int jrwssbsum(String Cdate) {
        return spyhmapper.jrwssbsum(Cdate);
    }

    //  本日办结列表
    @Override
    public List<Map<String, Object>> getbrbjlb(String year, String month, String day,String page) {
        return tyslMapper.getbrbjlb(year, month, day, page);
    }
    //  本日受理列表
    @Override
    public List<Map<String, Object>> getbrsllb(String year, String month, String day,String page) {
        return tyslMapper.getbrsllb(year, month, day, page);
    }
    //下载本日办结列表
    @Override
    public List<Map<String, Object>> downloadbrbjlb(String year, String month, String day, String page) {
        return tyslMapper.downloadbrbjlb(year, month, day, page) ;
    }
    //下载本日受理列表
    @Override
    public List<Map<String, Object>> downloadbrsllb(String year, String month, String day, String page) {
        return tyslMapper.downloadbrsllb(year, month, day, page) ;
    }
    //空闲窗口列表
    @Override
    public List<Map<String, Object>> getkxcklb(String year, String month, String day, String page) {
        return tyslMapper.getkxcklb(year, month, day, page) ;
    }






}
