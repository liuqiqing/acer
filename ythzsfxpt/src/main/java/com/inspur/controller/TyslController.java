package com.inspur.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inspur.dao.syck.SyckMapper;
import com.inspur.service.*;

import com.inspur.utils.TemplateExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 一窗受理controller
 * @author ly
 * @date 20191030
 *
 */
@RestController
@RequestMapping("/tyslcontroller")
public class TyslController {

    @Autowired
    private TyslService tyslService;

    @Autowired
    private DzjcService dzjcService;

    @Autowired
    private DtglService dtglService;
    @Autowired
    private SxglService sxglService;

    @Autowired
    private SyckService syckService;



    @RequestMapping(value = "/tyslsum", method = RequestMethod.GET)
    public Map<String, Object> tyslsum() {
        Map<String, Object> map = new HashMap<String, Object>();
        int tyslsum = tyslService.getSum();
        System.out.println("tyslsum========" + tyslsum);
        map.put("tyslsum", tyslsum);
        return map;
    }

    /**
     * 获取每天的一窗受理数量
     *
     * @return
     */
    @RequestMapping(value = "/getycsjsl", method = RequestMethod.GET)
    public Map<String, Object> getycsjsl() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象,获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        System.out.println("Cdate======" + Cdate);
        //市收件
        List<Map<String, Object>> ycsjsl = tyslService.getycsjsl(Cdate);
        System.out.println("ycsjsl========" + ycsjsl);
        int sum = 0;
        for (int i = 0; i < ycsjsl.size(); i++) {
            System.out.println(ycsjsl.get(i));
            sum += Integer.parseInt(ycsjsl.get(i).get("SUM").toString());
        }
        System.out.println("tyslsum========" + sum);
        /*省收件*/
        int sycsum=syckService.ssjs(Cdate);

        System.out.println("sycsum========" + sycsum);
        //本日办结
        int brbjsum=tyslService.brbjsum(Cdate);
        //本日受理
        int brslsum=tyslService.brslsum(Cdate);
        //网上收件
        int jrwssjsum=sxglService.jrwssjsum(Cdate);
        //总收件数
        int sjsum=sum+sycsum+jrwssjsum;
        System.out.println("本日办结+++++++++++++++++++"+brbjsum);
        //本日办结
        map.put("brbjsum",brbjsum);
        //本日受理
        map.put("brslsum",brslsum);
        //网上收件
        map.put("jrwssjsum",jrwssjsum);
        //市收件
        map.put("ycsjsl", sum);
        //省收件
        map.put("sycsum",sycsum);
        //总收件数
        map.put("sjsum",sjsum);
        return map;
    }

    /**
     * 获取一窗收件数量变化趋势
     *
     * @return
     */
    @RequestMapping(value = "/getycsjqs", method = RequestMethod.GET)
    public Map<String, Object> getycsjqs() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = tyslService.getycsjqs();
        System.out.println("tyslsum========" + list);
        map.put("ycsjqs", list);
        return map;
    }

    /**
     * 获取一窗收件事项列表
     *
     * @return
     */
    @RequestMapping(value = "/getycsjlb", method = RequestMethod.GET)
    public Map<String, Object> getycsjlb(@RequestParam(value = "page", required = true) int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象,获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        System.out.println("Cdate======" + Cdate);
        List<Map<String, Object>> list = tyslService.getycsjlb(Cdate, page);

        System.out.println("ycsjlb========" + list);
        map.put("ycsjlb", list);
        return map;
    }

    /**
     * 下载一窗收件事项列表
     *
     * @return
     */
    @RequestMapping(value = "/downloadsxlb", method = RequestMethod.GET)
    public void downloadsxlb(HttpServletResponse response) {
        File file = null;
        try {
            //response.setContentType("application/ms-excel;charset=utf-8");
            file = ResourceUtils.getFile("classpath:static/excel/一窗事项列表.xlsx");
            System.out.println(file);
            Date now = new Date();    //创建一个Date对象,获取当前时间
            //指定格式化格式
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String Cdate = f.format(now);
            //查询数据
            List<Map<String, Object>> list = tyslService.downloadsxlb(Cdate);
            // 往excel里写入数据
            TemplateExportExcelUtil.exportExcel(file, list, response);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一窗收件事项列表
     *
     * @return
     */
    @RequestMapping(value = "/getbmblsl", method = RequestMethod.GET)
    public Map<String, Object> getbmblsl(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = tyslService.getbmblsl(year, month, day, page);
        System.out.println("bmsl========" + list);
        map.put("bmsl", list);
        return map;
    }

    /**
     * 下载各业务处室一窗办理数量
     *
     * @return
     */
    @RequestMapping(value = "/downloadbmblsl", method = RequestMethod.GET)
    public void downloadbmblsl(@RequestParam(value = "year", required = true) String year,
                               @RequestParam(value = "month", required = true) String month,
                               @RequestParam(value = "day", required = true) String day,
                               HttpServletResponse response) {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/excel/各业务处室办理数量.xlsx");
            //查询数据
            List<Map<String, Object>> list = tyslService.downloadbmblsl(year, month, day, "");
            //System.out.println(list);
            // 往excel里写入数据
            TemplateExportExcelUtil.exportExcel(file, list, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * // 获取短信评价的信息
     *
     * @return
     */
    @RequestMapping(value = "/getwspjxx", method = RequestMethod.GET)
    public Map<String, Object> getwspjxx() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象,获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        String Cdate = f.format(now);
        System.out.println("Cdate=============="+Cdate);
        // 获取网上评价的信息 scoreType 1是满意 2是基本满意 3是不满意
        List<Map<String, Object>> list = dzjcService.getwspjxx();
        // 获取短信评价的信息 replay 1是满意 2是基本满意 3是不满意
        List<Map<String, Object>> lists = dtglService.getdxpjxx(Cdate);
        //部门显示

        System.out.println("list========" + list);
        System.out.println("lists========" + lists);
        map.put("wspj", list);
        map.put("dxpj", lists);
        return map;
    }


    /**
     * // 获取窗口人员办件情况
     *
     * @return
     */
    @RequestMapping(value = "/getckrybjqk", method = RequestMethod.GET)
    public Map<String, Object> getckrybjqk(@RequestParam(value = "year", required = true) String year,
                                           @RequestParam(value = "month", required = true) String month,
                                           @RequestParam(value = "day", required = true) String day,
                                           @RequestParam(value = "page", required = true) String page) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = tyslService .getckrybjqk(year,month,day,page);
        System.out.println("ckrybjqk========="+list);
        map.put("ckrybjqk", list);
        return map;
    }


    /**
     * // feb分页
     *
     * @return
     */
    @RequestMapping(value = "/getckfycx", method = RequestMethod.GET)
    public Map<String, Object> getckfycx(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page,HttpServletRequest request) {
        String pagess = request.getParameter("pagess");
        int num =  Integer.parseInt(pagess);
        Map<String, Object> map = new HashMap<String, Object>();
        if (page == null) {
            PageHelper.startPage(0, 10);
        } else {
            PageHelper.startPage(num, 10);
        }
        List<Map<String, Object>> list = tyslService .getckrybjqk(year, month, day, page);
        PageInfo pageInfo = new PageInfo(list);

        System.out.println("pageInfo=========" + pageInfo);


        map.put("ckrybjqk", pageInfo);
       // map.put("bmpj",pageInfo1);
        return map;
    }/*
    部门评价分页

    */

    @RequestMapping(value = "/getbmpj", method = RequestMethod.GET)
    public Map<String, Object> getbmpjfy(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "page", required = true) String page,HttpServletRequest request) {
        String pagess = request.getParameter("pagess");
        int num = Integer.parseInt(pagess);
        Map<String, Object> map = new HashMap<String, Object>();
        if (page == null) {
            PageHelper.startPage(0, 10);
        } else {
            PageHelper.startPage(num, 10);
        }
        Date now = new Date();    //创建一个Date对象,获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        String Cdate = f.format(now);
        List<Map<String, Object>> lists = dtglService.getmsgxx(Cdate);
        Map<String, Object> maps = new HashMap<String, Object>();
        List<Map<String,Object>> list=new LinkedList<Map<String,Object>>();
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(JSONObject.parseObject(lists.get(i).get("userArg").toString()).get("orgName"));
            maps.put("reply",lists.get(i).get("reply").toString());
            maps.put("orgName",JSONObject.parseObject(lists.get(i).get("userArg").toString()).get("orgName"));
            list.add(i,maps);
        }
        Set set=maps.keySet();
        //满意为1
        int my=0;
        int bmy=0;
        int yb=0;
        double bfb=0.0;
        Object value=null;
        for (Object key:set){
               value = maps.get("orgName");
                if (maps.get("reply").toString().equals(1)){
                    my+=1;
                }
                if (maps.get("reply").toString().equals(2)){
                    bmy+=1;
                }
                if (maps.get("reply").toString().equals(3)){
                    yb+=1;
                }
            bfb=my+yb/my+bmy+yb;
            }
        System.out.println("value=============" +value);
        System.out.println("my+=++++++++++++++"+my);
        map.put("bfb",bfb);
        map.put("bmmc",value);
        map.put("my",my);
        map.put("bmy",bmy);
        map.put("yb",yb);
        return map;
    }

    //获取在办窗口数
    @RequestMapping(value = "/getckxxqk", method = RequestMethod.GET)
    public Map<String, Object> getckxxqk(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = tyslService .getckxxqk(year, month, day, page);
        System.out.println("ckrybj=========" + list);
        map.put("ckrybj", list);
        return map;

    }


    //下载在办窗口
    @RequestMapping(value = "/downloadzbck", method = RequestMethod.GET)
    public void downloadzbck(@RequestParam(value = "year", required = true) String year,
                             @RequestParam(value = "month", required = true) String month,
                             @RequestParam(value = "day", required = true) String day,
                             @RequestParam(value = "page", required = false) String page,HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/excel/各窗口办件统计.xlsx");
            //查询数据
            List<Map<String, Object>> list = tyslService.downloadzbck(year, month, day, page);

            //System.out.println(list);
            // 往excel里写入数据
            TemplateExportExcelUtil.exportExcel(file, list, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //省收件时间排行
    @RequestMapping(value = "/getssjph", method = RequestMethod.GET)
    public Map<String, Object> getssjph() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象,获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        String Cdate = f.format(now);
        List<Map<String, Object>> list = syckService.ssjph(Cdate);
        System.out.println("ssjph=========" + list);
        map.put("ssjph", list);
        return map;
    }

    /**
     * 本日办结列表
     *
     * @return
     */
    @RequestMapping(value = "/getbrbjlb", method = RequestMethod.GET)
    public Map<String, Object> getbrbjlb(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = tyslService.getbrbjlb(year, month, day, page);
        System.out.println("brbj========" + list);
        map.put("brbj", list);
        return map;
    }

    /**
     * 本日受理列表
     *
     * @return
     */
    @RequestMapping(value = "/getbrsllb", method = RequestMethod.GET)
    public Map<String, Object> getbrsllb(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = tyslService.getbrsllb(year, month, day, page);
        System.out.println("brsl========" + list);
        map.put("brsl", list);
        return map;
    }



    //下载本日办结列表
    @RequestMapping(value = "/downloadbrbjlb", method = RequestMethod.GET)
    public void downloadbrbjlb(@RequestParam(value = "year", required = true) String year,
                               @RequestParam(value = "month", required = true) String month,
                               @RequestParam(value = "day", required = true) String day,
                               @RequestParam(value = "page", required = false) String page,HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/excel/今日办结事项.xlsx");
            //查询数据
            List<Map<String, Object>> list = tyslService.downloadbrbjlb(year, month, day, page);

            //System.out.println(list);
            // 往excel里写入数据
            TemplateExportExcelUtil.exportExcel(file, list, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    //下载本日受理列表
    @RequestMapping(value = "/downloadbrsllb", method = RequestMethod.GET)
    public void downloadbrsllb(@RequestParam(value = "year", required = true) String year,
                               @RequestParam(value = "month", required = true) String month,
                               @RequestParam(value = "day", required = true) String day,
                               @RequestParam(value = "page", required = false) String page,HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:static/excel/今日受理事项.xlsx");

            //查询数据
            List<Map<String, Object>> list = tyslService.downloadbrsllb(year, month, day, page);

            //System.out.println(list);
            // 往excel里写入数据
            TemplateExportExcelUtil.exportExcel(file, list, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    /**
     * 空闲窗口列表
     *
     * @return
     */
    @RequestMapping(value = "/getkxcklb", method = RequestMethod.GET)
    public Map<String, Object> getkxcklb(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = tyslService.getkxcklb(year, month, day, page);
        System.out.println("kxcklb========" + list);
        map.put("kxcklb", list);
        return map;
    }


}
