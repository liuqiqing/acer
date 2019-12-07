package com.inspur.dao.sxgl;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface sxglMapper {

    /**
     * 市直部门事项个数 柱状图
     */
    public List<Map<String,Object>> szbmsxgszzt(@Param("sxlx") String sxlx,
                                                @Param("startTime") String startTime,
                                                @Param("endTime") String endTime);

    /**
     * 市直部门事项个数 柱状图 详情表格
     * @return
     */
    public List<Map<String,Object>> szbmsxgszztxqbg(@Param("sxType") String sxType,
                                                    @Param("orgName") String orgName,
                                                    @Param("pageNumKey") int pageNum,
                                                    @Param("pageSizeKey") int pageSize,
                                                    @Param("startTime") String startTime,
                                                    @Param("endTime") String endTime);

    /**
     * 市直部门事项个数 饼状图
     * @return
     */
    public Integer szbmsxgsbzt(@Param("sxlx") String sxlx,
                               @Param("startTime") String startTime,
                               @Param("endTime") String endTime,
                               @Param("isOnline") String isOnline);


    /**
     * 市直部门事项个数 饼状图 详情表格
     * @return
     */
    public List<Map<String,Object>> szbmsxgsbztxqbg(@Param("sxType") String sxType,
                                                    @Param("isOnline") String isOnline,
                                                    @Param("orgName") String orgName,
                                                    @Param("pageNumKey") int pageNum,
                                                    @Param("pageSizeKey") int pageSize,
                                                    @Param("startTime") String startTime,
                                                    @Param("endTime") String endTime);

    /**
     * 区县部门事项个数 柱状图
     */
    public List<Map<String,Object>> qxbmsxgszzt(@Param("sxlx") String sxlx,
                                                @Param("startTime") String startTime,
                                                @Param("endTime") String endTime);

    /**
     * 区县部门事项个数 柱状图 详情表格
     */
    public List<Map<String,Object>> qxbmsxgszztxqbg(@Param("sxType") String sxType,
                                                    @Param("orgName") String orgName,
                                                    @Param("pageNumKey") int pageNum,
                                                    @Param("pageSizeKey") int pageSize,
                                                    @Param("startTime") String startTime,
                                                    @Param("endTime") String endTime);

    /**
     * 区县部门事项个数 饼状图
     * @return
     */
    public Integer qxbmsxgsbzt(@Param("sxlx") String sxlx,
                               @Param("startTime") String startTime,
                               @Param("endTime") String endTime,
                               @Param("isOnline") String isOnline);

    /**
     * 区县部门事项个数 饼状图 详情表格
     * @return
     */
    public List<Map<String,Object>> qxbmsxgsbztxqbg(@Param("sxType") String sxType,
                                                    @Param("isOnline") String isOnline,
                                                    @Param("orgName") String orgName,
                                                    @Param("pageNumKey") int pageNum,
                                                    @Param("pageSizeKey") int pageSize,
                                                    @Param("startTime") String startTime,
                                                    @Param("endTime") String endTime);

    /**
     * 事项总览页面新增事项性质柱形图
     * @param sxlx
     * @return
     */
    public List<Map<String,Object>> sxxzChart(@Param("sxlx") String sxlx,
                                              @Param("startTime") String startTime,
                                              @Param("endTime") String endTime);

    /**
     * 市直部门事项个数 柱状图 表格下载
     * @return
     */
    public List<Map<String,Object>> szbmsxgs(@Param("sxType") String sxType,
                                             @Param("startTime") String startTime,
                                             @Param("endTime") String endTime);

    /**
     * 区县部门事项个数 柱状图 表格下载
     * @return
     */
    public List<Map<String,Object>> qxbmsxgs(@Param("sxType") String sxType,
                                             @Param("startTime") String startTime,
                                             @Param("endTime") String endTime);


    /**
     * 市直部门事项个数 饼状图 表格下载
     * @return
     */
    public List<Map<String,Object>> szbmsxgsbztDownload(@Param("sxType") String sxType,
                                                        @Param("isOnline") String isOnline,
                                                        @Param("startTime") String startTime,
                                                        @Param("endTime") String endTime);

    /**
     * 区县部门事项个数 饼状图 表格下载
     * @return
     */
    public List<Map<String,Object>> qxbmsxgsbztDownload(@Param("sxType") String sxType,
                                                        @Param("isOnline") String isOnline,
                                                        @Param("startTime") String startTime,
                                                        @Param("endTime") String endTime);


    /**
     * 事项总览更多页面 新增 事项性质柱形图 详情表格
     * @return
     */
    public List<Map<String,Object>> sxxzchartxqbg(@Param("sxType") String sxType,
                                                  @Param("orgName") String orgName,
                                                  @Param("pageNumKey") int pageNum,
                                                  @Param("pageSizeKey") int pageSize,
                                                  @Param("startTime") String startTime,
                                                  @Param("endTime") String endTime);

    /**
     * 其中可网上办理的：
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
     *
     * 获取网办深度，只查已发布的
     */
    public List<Map<String,Object>> getwbsd();


}
