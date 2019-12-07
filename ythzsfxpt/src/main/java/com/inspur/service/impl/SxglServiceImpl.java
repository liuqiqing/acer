package com.inspur.service.impl;

import com.inspur.dao.dzjc.dzjcMapper;
import com.inspur.dao.sxgl.sxglMapper;
import com.inspur.dao.ywtb.ywtbMapper;
import com.inspur.service.SxglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SxglServiceImpl implements SxglService {

    @Autowired
    private sxglMapper sxglmapper;

    @Autowired
    private ywtbMapper ywtb;

    @Autowired
    private com.inspur.dao.spyh.spyhMapper spyhmapper;//审批用户mapper

    @Autowired
    private dzjcMapper dzjc;


    /**
     * 其中可网上办理的：426
     * “conduct_depth”是网办深度或审批深度：
     * “1”是全程网办（0跑腿）；
     * “2”是在线预审（只跑1次）；
     * “3”是事项公开，
     * “4”是在线申办。
     */
    @Override
    public int kwsblsl() {
        return sxglmapper.kwsblsl();
    }
    /**
     * 其中可网上办理的：全部数量
     * “conduct_depth”是网办深度或审批深度：
     * “1”是全程网办（0跑腿）；
     * “2”是在线预审（只跑1次）；
     * “3”是事项公开，
     * “4”是在线申办。
     */
    @Override
    public int kwsbl() {
        return sxglmapper.kwsbl();
    }

    /**
     * 已办结数量
     */
    @Override
    public int ybjsl() {
        int ybjsl = spyhmapper.ybjsl();
        return ybjsl;
    }

    /**
     * 已办结数量
     * state 96
     */
    @Override
    public int tjsl() {
        int tjsl = spyhmapper.tjsl();
        return tjsl;
    }

    /**
     * 网上申报数量
     * APPLY_FROM = '01'
     */
    @Override
    public int wssbl() {
        int wssbl = spyhmapper.wssbl();
        return wssbl;
    }

    /**
     * 一窗受理量  APPLY_FROM = '07'
     * APPLY_FROM = '01'
     */
    @Override
    public int ycsll() {
        int ycsll = spyhmapper.ycsll();
        return ycsll;
    }

    /**
     * 济南市办结事项前十
     */
    @Override
    public List<Map<String, Object>> sxbjqs() {
        List<Map<String,Object>> list = spyhmapper.sxbjqs();
        return list;
    }
    /**
     * 红牌数量
     * CUR_RESULT_TYPE=5
     *   @return
     */
    @Override
    public int hongpai() {
        return dzjc.hongpai();
    }
    /**
     * 黄牌数量
     * CUR_RESULT_TYPE=2
     * @return
     */
    @Override
    public int huangpai() {
        return dzjc.huangpai();
    }

    /**
     *
     * 获取网办深度，只查已发布的
     */
    @Override
    public List<Map<String, Object>> getwbsd() {
        return sxglmapper.getwbsd();
    }
    /**
     *当天的审批的办结数量
     *state 99
     */
    @Override
    public int spbj(String Cdate) {
        return spyhmapper.spbj(Cdate);
    }
    /**
     *当天的一网通办的办结数量
     *state 99
     */
    @Override
    public int ywtbbj(String Cdate) {
        return ywtb.ywtbbj(Cdate);
    }

    /**
     *当天的审批的受理数量
     *state 99
     */
    @Override
    public int spsl(String Cdate) {
        return spyhmapper.spsl(Cdate);
    }
    //今日网上申报数
    @Override
    public int jrwssbsum(String Cdate) {
        return spyhmapper.jrwssbsum(Cdate);
    }
    /*今日网上收件数*/
    @Override
    public int jrwssjsum(String Cdate) {
        return spyhmapper.jrwssjsum(Cdate);
    }
}
