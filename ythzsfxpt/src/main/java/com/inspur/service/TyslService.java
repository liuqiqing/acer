package com.inspur.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface TyslService {
    int getSum();

    // 获取每天的一窗收件数量
    List<Map<String, Object>> getycsjsl(String Cdate);

    // 获取一窗收件变化趋势
    public List<Map<String, Object>> getycsjqs();

    // 获取一窗收件列表信息
    public List<Map<String, Object>> getycsjlb(String Cdate, int page);

    // // 下载一窗事项列表
    List<Map<String, Object>> downloadsxlb(String Cdate);

    //  各业务处室一窗办理次数排名
    List<Map<String, Object>> getbmblsl(@RequestParam(value = "year", required = true) String year,
                                        @RequestParam(value = "month", required = true) String month,
                                        @RequestParam(value = "day", required = true) String day,
                                        @RequestParam(value = "page", required = true) String page);

    //  下载各业务处室一窗办理数量
    List<Map<String, Object>> downloadbmblsl(@RequestParam(value = "year", required = true) String year,
                                             @RequestParam(value = "month", required = true) String month,
                                             @RequestParam(value = "day", required = true) String day,
                                             @RequestParam(value = "page", required = false) String page);

    // 获取窗口人员办件情况
    List<Map<String, Object>> getckrybjqk(@RequestParam(value = "year", required = true) String year,
                                          @RequestParam(value = "month", required = true) String month,
                                          @RequestParam(value = "day", required = true) String day,
                                          @RequestParam(value = "page", required = true) String page);

    //本日办结数
    int brbjsum(String Cdate);

    //本日受理数
    int brslsum(String Cdate);
    //在办窗口柱状图
    List<Map<String,Object>>getckxxqk(@RequestParam(value = "year", required = true) String year,
                                      @RequestParam(value = "month", required = true) String month,
                                      @RequestParam(value = "day", required = true) String day,
                                      @RequestParam(value = "page", required = true) String page);
    /*下载在办窗口*/

    List<Map<String,Object>>downloadzbck(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = false) String page);
    /*网上申报数*/
    int jrwssbsum(String Cdate);
    //  本日办结列表
    List<Map<String, Object>> getbrbjlb(@RequestParam(value = "year", required = true) String year,
                                        @RequestParam(value = "month", required = true) String month,
                                        @RequestParam(value = "day", required = true) String day,
                                        @RequestParam(value = "page", required = false) String page);

    //  本日受理列表
    List<Map<String, Object>> getbrsllb(@RequestParam(value = "year", required = true) String year,
                                        @RequestParam(value = "month", required = true) String month,
                                        @RequestParam(value = "day", required = true) String day,
                                        @RequestParam(value = "page", required = false) String page);

    //下载本日办结列表
    List<Map<String, Object>> downloadbrbjlb(@RequestParam(value = "year", required = true) String year,
                                             @RequestParam(value = "month", required = true) String month,
                                             @RequestParam(value = "day", required = true) String day,
                                             @RequestParam(value = "page", required = false) String page);

    //下载本日受理列表
    List<Map<String, Object>> downloadbrsllb(@RequestParam(value = "year", required = true) String year,
                                             @RequestParam(value = "month", required = true) String month,
                                             @RequestParam(value = "day", required = true) String day,
                                             @RequestParam(value = "page", required = false) String page);


    //空闲窗口列表
    public List<Map<String, Object>> getkxcklb(@RequestParam(value = "year", required = true) String year,
                                               @RequestParam(value = "month", required = true) String month,
                                               @RequestParam(value = "day", required = true) String day,
                                               @RequestParam(value = "page", required = true) String page);

}
