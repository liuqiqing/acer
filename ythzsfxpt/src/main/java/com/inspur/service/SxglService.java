package com.inspur.service;

import java.util.List;
import java.util.Map;

public interface SxglService {
    /**
     * 其中可网上办理的：426
     * “conduct_depth”是网办深度或审批深度：
     * “1”是全程网办（0跑腿）；
     * “2”是在线预审（只跑1次）；
     * “3”是事项公开，
     * “4”是在线申办。
     *
     */
    public int kwsblsl();


    /**
     * 其中可网上办理的：全部
     * “conduct_depth”是网办深度或审批深度：
     *
     */
    public int kwsbl();

    /**
     * 已办结数量
     * state 99
     */
    public int ybjsl();

    /**
     * 已办结数量
     * state 96
     */
    public int tjsl();

    /**
     * 网上申报数量
     * APPLY_FROM = '01'
     */
    public int wssbl();

    /**
     * 一窗受理量  APPLY_FROM = '07'
     * APPLY_FROM = '01'
     */
    public int ycsll();

    /**
     *  济南市办结事项前十
     *
     *
     */
    public List<Map<String,Object>> sxbjqs();


    /**
     * 红牌数量
     * CUR_RESULT_TYPE=5
     *   @return
     */
    int hongpai();

    /**
     * 黄牌数量
     * CUR_RESULT_TYPE=2
     * @return
     */
    int huangpai();

    /**
     *
     * 获取网办深度，只查已发布的
     */
    public List<Map<String,Object>> getwbsd();

    /**
     *当天的审批的办结数量
     *state 99
     */
    public int spbj(String Cdate);

    /**
     *当天的一网通办的办结数量
     *state 99
     */
    public int ywtbbj(String Cdate);

    /**
     *当天的审批的受理数量
     *state 01
     */
    public int spsl(String Cdate);

    //今日网上申报数
    int jrwssbsum(String Cdate);

    //今日网上收件数
    int jrwssjsum(String Cdate);

}
