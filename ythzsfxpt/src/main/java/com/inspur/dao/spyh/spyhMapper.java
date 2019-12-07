package com.inspur.dao.spyh;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface spyhMapper {

    public List<Map<String,Object>> getOrgList(@Param("pageNumKey") int pageNum,
                                               @Param("pageSizeKey") int pageSize,
                                               @Param("orgName") String orgName);


    /**
     *
     * 自然人、法人、项目 事项办件量统计
     *
     */
    public Integer bjlTableData(@Param("tableName") String tableName,
                                @Param("applyFrom") String applyFrom);

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
     */
    public List<Map<String,Object>> sxbjqs();


    /**
     *当天的审批的办结数量
     *state 99
     */
    public int spbj(String Cdate);

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
