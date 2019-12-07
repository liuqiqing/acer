package com.inspur.controller;

import com.github.pagehelper.PageInfo;
import com.inspur.service.EgovIndexService;
import com.inspur.utils.TemplateExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 政务服务首页
 *
 * @author BEAN_BAG
 */
@Controller
@RequestMapping("/egovIndexController")
public class EgovIndexController {

    //全部事项
    private final String qbsxParam = "('JL','ZS','QZ','CF','GG','JF','JD','ZJJG','CJ','SX','XK','QT','QR')";
    //政务服务事项
    private final String zwfwsxParam = "('JL','ZS','QZ','CF','GG','JF','JD','CJ','XK','QT','QR')";
    //依申请事项
    private final String ysqsxParam = "('XK', 'ZS', 'QR', 'JF', 'JL', 'CJ', 'QT', 'GG', 'JD')";
    //试点事项
    private final String sdsxParam = "('XK','QR','JF','JL','CJ','QT')";

    @Autowired
    private EgovIndexService egovIndexService;

    /**
     * 事项总览
     * 已发布的事项，不区分服务类别和网办深度
     * 权力事项为9项，分别为('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')
     * 市本级加上区县的总数
     */
    @RequestMapping("/sxzl")
    @ResponseBody
    public Object sxzl() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sxzl",egovIndexService.sxzl());
        return map;

    }

    /**
     * 事项总览，可网上办理事项
     * 不区分服务类别和网办深度，权力事项为9项，分别为('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')
     * 浪潮事项库，project_item表，字段is_online为1,2,3的为可网上办理事项
     *
     */
    @RequestMapping("/xsblsx")
    @ResponseBody
    public Object xsblsx() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xsblsx", egovIndexService.xsblsx());
        map.put("sxzl", egovIndexService.sxzl());
        return map;

    }

    /**
     * 事项总览，不可网上办理事项
     * 不区分服务类别和网办深度，权力事项为9项，分别为('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')
     * 浪潮事项库，project_item表，字段is_online为0的为不可网上办理事项
     *
     */
    @RequestMapping("/xxblsx")
    @ResponseBody
    public Object xxblsx() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xxblsx",egovIndexService.xxblsx());
        map.put("sxzl", egovIndexService.sxzl());
        return map;

    }


    /**
     * 市本级和区县级事项级别
     * 已发布事项，权力类型为('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')
     * 不区分服务类别和网办深度
     *
     * 区县级为11个区县
     * 分别为：天桥区、章丘区、商河县、市中区、平阴县、济阳区、历城区、历下区、高新区、长清区、槐荫区
     */
    @RequestMapping("/sxjbjn")
    @ResponseBody
    public Object sxjb() {
        List<Map<String, Object>> listjn = egovIndexService.sxjbjn();
        List<Map<String, Object>> listjnqx = egovIndexService.sxjbjnqx();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jnsxsl", listjn.get(0).get("jnsxsl"));
        map.put("jnqxsxsl", listjnqx.get(0).get("jnqxsxsl"));
        return map;
    }

    /**
     *
     * 事项性质
     * 已发布事项，权力类型为('XK','ZS','QR','JF','JL','CJ','QT','GG','JD')
     * 不区分服务类别和网办深度
     *
     */
    @RequestMapping("/sxxz")
    @ResponseBody
    public Object sxxz() {
        List<Map<String, Object>> list = egovIndexService.sxxz();
        return list;
    }

    /**
     *
     * 按事项性质分类当日线上 受理办结 业务数量
     *
     */
    @RequestMapping("/sxxzdrxsslbjywsl")
    @ResponseBody
    public Object sxxzdrxsslbjywsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzdrxsslywsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzdrxsbjywsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }

    /**
     *
     * 按事项性质分类当日线下受理办结业务数量
     *
     */
    @RequestMapping("/sxxzdrxxslbjywsl")
    @ResponseBody
    public Object sxxzdrxxslbjywsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzdrxxslywsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzdrxxbjywsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }

    /**
     *
     * 按事项性质分类当月线上受理办结业务数量
     *
     */
    @RequestMapping("/sxxzdyxsslbjywsl")
    @ResponseBody
    public Object sxxzdyxsslbjywsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzdyxsslywsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzdyxsbjywsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }

    /**
     *
     * 按事项性质分类当月线下受理办结业务数量
     *
     */
    @RequestMapping("/sxxzdyxxslbjywsl")
    @ResponseBody
    public Object sxxzdyxxslbjywsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzdyxxslywsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzdyxxbjywsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }

    /**
     *
     * 按事项性质分类当年线上受理办结业务数量
     *
     */
    @RequestMapping("/sxxzdnxsslbjywsl")
    @ResponseBody
    public Object sxxzdnxsslbjywsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzdnxsslywsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzdnxsbjywsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }

    /**
     *
     * 按事项性质分类当年线下受理办结业务数量
     *
     */
    @RequestMapping("/sxxzdnxxslbjywsl")
    @ResponseBody
    public Object sxxzdnxxslbjywsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzdnxxslywsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzdnxxbjywsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }

    /**
     *
     * 按事项性质分类线上受理办结业务总数量
     *
     */
    @RequestMapping("/sxxzxsslbjywzsl")
    @ResponseBody
    public Object sxxzxsslbjywzsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzxsslywzsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzxsbjywzsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }

    /**
     *
     * 事项性质内页 底部数据表格 办件量表格数据
     */
    @RequestMapping("/bjlTableData")
    @ResponseBody
    public LinkedHashMap<String, Object> sxxzbjlTableData(){
        LinkedHashMap<String, Object> map = egovIndexService.bjlTableData();

        return map;





    }


    /**
     *
     * 按事项性质分类线下受理办结业务总数量
     *
     */
    @RequestMapping("/sxxzxxslbjywzsl")
    @ResponseBody
    public Object sxxzxxslbjywzsl(HttpServletRequest req) {
        List<Map<String, Object>> slList = egovIndexService.sxxzxxslywzsl();
        List<Map<String, Object>> bjList = egovIndexService.sxxzxxslywzsl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("slList", slList);
        map.put("bjList", bjList);
        return map;
    }


    /**
     * 业务办理变化趋势当日线上办理次数
     */
    @RequestMapping("/xsdrblcs")
    @ResponseBody
    public Object xsdrblcs() {
        List<Map<String, Object>> slList = egovIndexService.xsdrslcs();
        List<Map<String, Object>> bjList = egovIndexService.xsdrbjcs();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xsdrslList", slList);
        map.put("xsdrbjList", bjList);
        return map;
    }

    /**
     *
     * 业务办理变化趋势当月线上办理次数
     *
     */
    @RequestMapping("/xsdyblcs")
    @ResponseBody
    public Object xsdyblcs() {
        List<Map<String, Object>> slList = egovIndexService.xsdyslcs();
        List<Map<String, Object>> bjList = egovIndexService.xsdybjcs();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xsdyslList", slList);
        map.put("xsdybjList", bjList);
        return map;
    }

    /**
     * 业务办理变化趋势当年线上办理次数
     */
    @RequestMapping("/xsdnblcs")
    @ResponseBody
    public Object xsdnblcs() {
        List<Map<String, Object>> slList = egovIndexService.xsdnslcs();
        List<Map<String, Object>> bjList = egovIndexService.xsdnbjcs();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xsdnslList", slList);
        map.put("xsdnbjList", bjList);
        return map;
    }


    /**
     * 业务办理变化趋势当日线下办理次数
     */
    @RequestMapping("/xxdrblcs")
    @ResponseBody
    public Object xxdrblcs() {
        List<Map<String, Object>> slList = egovIndexService.xxdrslcs();
        List<Map<String, Object>> bjList = egovIndexService.xxdrbjcs();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xxdrslList", slList);
        map.put("xxdrbjList", bjList);
        return map;
    }

    /**
     * 业务办理变化趋势当月线下办理次数
     */
    @RequestMapping("/xxdyblcs")
    @ResponseBody
    public Object xxdyblcs() {
        List<Map<String, Object>> slList = egovIndexService.xxdyslcs();
        List<Map<String, Object>> bjList = egovIndexService.xxdybjcs();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xxdyslList", slList);
        map.put("xxdybjList", bjList);
        return map;
    }

    /**
     * 业务办理变化趋势当年线下办理次数
     */
    @RequestMapping("/xxdnblcs")
    @ResponseBody
    public Object xxdnblcs() {
        List<Map<String, Object>> slList = egovIndexService.xxdnslcs();
        List<Map<String, Object>> bjList = egovIndexService.xxdnbjcs();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xxdnslList", slList);
        map.put("xxdnbjList", bjList);
        return map;
    }

    /** 业务办理变化趋势 更多页面 start */
    /**
     *
     * 业务办理变化趋势 更多页面 部门列表
     *
     */
    //zzzzz
    @RequestMapping("/org_list")
    @ResponseBody
    public Object org_list(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "orgName",required = false) String orgName) {
        List<Map<String, Object>> list = egovIndexService.getOrgList(page, limit,orgName);

        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(list);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("count",pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());
        resultMap.put("msg", "");
        resultMap.put("code", 0);
        return resultMap;
    }


    /**
     *
     * 业务办理变化趋势 更多页面 当日线上办理次数
     *
     */
    @RequestMapping("/day_online")
    @ResponseBody
    public Object day_online(HttpServletRequest req) {
        String org_code = req.getParameter("org_code");
        List<Map<String, Object>> slList = egovIndexService.day_online_accept(org_code);
        List<Map<String, Object>> bjList = egovIndexService.day_online_finish(org_code);
        Map<String, Object> map = new HashMap<String, Object>();

        List<String> slsjList = new ArrayList<String>();
        List<String> bjsjList = new ArrayList<String>();
        List<String> xsslList = new ArrayList<String>();
        List<String> xsbjList = new ArrayList<String>();
        int drslzl = 0;
        int drbjzl = 0;

        for(int i = 0;i<slList.size();i++){
            Map<String, Object> _map = slList.get(i);
            String _sj = _map.get("SJ").toString();
            String _sxsl = _map.get("SXSL").toString();
            slsjList.add(_sj);
            xsslList.add(_sxsl);
        }
        for(int i = 0;i<bjList.size();i++){
            Map<String, Object> _map = bjList.get(i);
            String _sj = _map.get("SJ").toString();
            String _sxsl = _map.get("SXSL").toString();
            bjsjList.add(_sj);
            xsbjList.add(_sxsl);
        }
        for(int i=0;i<xsslList.size();i++){
            String s = xsslList.get(i);
            int i1 = Integer.parseInt(s);
            drslzl += i1;
        }
        for(int i=0;i<xsbjList.size();i++){
            String s = xsbjList.get(i);
            int i1 = Integer.parseInt(s);
            drbjzl += i1;
        }

        map.put("slsjList", slsjList);
        map.put("bjsjList", bjsjList);
        map.put("xsslList", xsslList);
        map.put("xsbjList", xsbjList);
        map.put("drslzl", drslzl);
        map.put("drbjzl", drbjzl);
        return map;
    }

    /**
     *
     * 业务办理变化趋势 更多页面 当月线上办理次数
     *
     */
    @RequestMapping("/month_online")
    @ResponseBody
    public Object month_online(HttpServletRequest req) {
        String org_code = req.getParameter("org_code");
        List<Map<String, Object>> slList = egovIndexService.month_online_accept(org_code);
        List<Map<String, Object>> bjList = egovIndexService.month_online_finish(org_code);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("month_online_accept", slList);
        map.put("month_online_finish", bjList);
        return map;
    }

    /**
     *
     * 业务办理变化趋势 更多页面 当年线上办理次数
     *
     */
    @RequestMapping("/year_online")
    @ResponseBody
    public Object year_online(HttpServletRequest req) {
        String org_code = req.getParameter("org_code");
        List<Map<String, Object>> slList = egovIndexService.year_online_accept(org_code);
        List<Map<String, Object>> bjList = egovIndexService.year_online_finish(org_code);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("year_online_accept", slList);
        map.put("year_online_finish", bjList);
        return map;
    }

    /**
     *
     * 业务办理变化趋势 更多页面 当日线下办理次数
     *
     */
    @RequestMapping("/day_offline")
    @ResponseBody
    public Object day_offline(HttpServletRequest req) {
        String org_code = req.getParameter("org_code");
        List<Map<String, Object>> slList = egovIndexService.day_offline_accept(org_code);
        List<Map<String, Object>> bjList = egovIndexService.day_offline_finish(org_code);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("day_offline_accept", slList);
        map.put("day_offline_finish", bjList);
        return map;
    }

    /**
     *
     * 业务办理变化趋势 更多页面 当月线下办理次数
     *
     */
    @RequestMapping("/month_offline")
    @ResponseBody
    public Object month_offline(HttpServletRequest req) {
        String org_code = req.getParameter("org_code");
        List<Map<String, Object>> slList = egovIndexService.month_offline_accept(org_code);
        List<Map<String, Object>> bjList = egovIndexService.month_offline_finish(org_code);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("month_offline_accept", slList);
        map.put("month_offline_finish", bjList);
        return map;
    }

    /**
     *
     * 业务办理变化趋势 更多页面 当年线下办理次数
     *
     */
    @RequestMapping("/year_offline")
    @ResponseBody
    public Object year_offline(HttpServletRequest req) {
        String org_code = req.getParameter("org_code");
        List<Map<String, Object>> slList = egovIndexService.year_offline_accept(org_code);
        List<Map<String, Object>> bjList = egovIndexService.year_offline_finish(org_code);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("year_offline_accept", slList);
        map.put("year_offline_finish", bjList);
        return map;
    }
    /** 业务办理变化趋势 更多页面 end */


    //事项受理前十名
    @RequestMapping("/sxslqsm")
    @ResponseBody
    public Object sxslqsm() {
        List<Map<String, Object>> list = egovIndexService.sxslqsm();
        return list;
    }

    //事项办结前十名
    @RequestMapping("/sxbjqsm")
    @ResponseBody
    public Object sxbjqsm() {
        List<Map<String, Object>> list = egovIndexService.sxbjqsm();
        return list;
    }

    //事项受理本日	author zxp
    @RequestMapping("/sxslbr")
    @ResponseBody
    public Object sxslbr() {
        //事项受理本日
        List<Map<String, Object>> sxslbr = egovIndexService.sxslbr();
        return sxslbr;
    }

    //事项办结本日	author zxp
    @RequestMapping("/sxbjbr")
    @ResponseBody
    public Object sxbjbr() {
        //事项办结本日
        List<Map<String, Object>> sxbjbr = egovIndexService.sxbjbr();
        return sxbjbr;
    }

    //事项受理本月	author zxp
    @RequestMapping("/sxslby")
    @ResponseBody
    public Object sxslby() {
        //事项受理本月
        List<Map<String, Object>> sxslby = egovIndexService.sxslby();
        return sxslby;
    }

    //事项办结本月	author zxp
    @RequestMapping("/sxbjby")
    @ResponseBody
    public Object sxbjby() {
        //事项办结本月
        List<Map<String, Object>> sxbjby = egovIndexService.sxbjby();
        return sxbjby;
    }

    //事项受理本年	author zxp
    @RequestMapping("/sxslbn")
    @ResponseBody
    public Object sxslbn() {
        //事项受理本年
        List<Map<String, Object>> sxslbn = egovIndexService.sxslbn();
        return sxslbn;
    }

    //事项办结本年	author zxp
    @RequestMapping("/sxbjbn")
    @ResponseBody
    public Object sxbjbn() {
        //事项办结本年
        List<Map<String, Object>> sxbjbn = egovIndexService.sxbjbn();
        return sxbjbn;
    }

    //事项受理全部	author zxp
    @RequestMapping("/sxslqb")
    @ResponseBody
    public Object sxslqb() {
        //事项受理本年
        List<Map<String, Object>> sxslqb = egovIndexService.sxslqb();
        return sxslqb;
    }

    //事项办结全部	author zxp
    @RequestMapping("/sxbjqb")
    @ResponseBody
    public Object sxbjqb() {
        //事项受理本年
        List<Map<String, Object>> sxbjqb = egovIndexService.sxbjqb();
        return sxbjqb;
    }

    //事项部门受理办结数据表格数据	author zxp
    @RequestMapping("/sxbmslbjTableData")
    @ResponseBody
    public Map<String, Object> sxslbjTableData(@RequestParam("page") Integer page,
                                               @RequestParam("limit") Integer limit) {
        //page当前页，limit每页显示的条数
        //计算开始行和结束行
        int startRows = (page - 1) * limit;
        int endRows = page * limit + 1;
        Map<String, Object> resultMap = egovIndexService.sxslbjTableData(startRows, endRows);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", resultMap.get("nums"));
        map.put("data", resultMap.get("resultList"));
        return map;
    }

    //事项统计详细三级页面		author zxp
    @RequestMapping("/toThirdPage")
    public ModelAndView thirdPage(@RequestParam("orgCode") String orgCode,
                                  @RequestParam("orgName") String orgName,
                                  @RequestParam("itemName") String itemName,
                                  @RequestParam("selectType") String selectType) {

        Map<String, Object> pageParamMap = new HashMap<String, Object>();
        pageParamMap.put("orgCode", orgCode);
        pageParamMap.put("orgName", orgName);
        pageParamMap.put("itemName", itemName);
        pageParamMap.put("selectType", selectType);
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageParamMap", pageParamMap);
        mav.setViewName("/templates/ythzs/thirdPage");

        return mav;
    }

    /**
     * 事项统计详细三级页面数据
     *
     * @param page       当前页
     * @param limit      每页条数
     * @param selectType 查询类型，区分JRSL,JRBJ,BYSL,BYBJ,BNSL,BNBJ
     * @author zxp
     */
    @RequestMapping("/sxtjxxTableData")
    @ResponseBody
    public Map<String, Object> sxtjxxTableData(@RequestParam("page") Integer page,
                                               @RequestParam("limit") Integer limit,
                                               @RequestParam("orgCode") String orgCode,
                                               @RequestParam("orgName") String orgName,
                                               @RequestParam("itemName") String itemName,
                                               @RequestParam("selectType") String selectType) {
        //计算分页参数
        int startRows = (page - 1) * limit;
        int endRows = page * limit + 1;
        //根据参数进行查询
        Map<String, Object> resultMap = egovIndexService.sxtjxxTableData(startRows, endRows, orgName, itemName, selectType);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", resultMap.get("nums"));
        map.put("data", resultMap.get("resultList"));

        return map;
    }

    //部门受理今日	author zxp
    @RequestMapping("bmsljr")
    @ResponseBody
    public Object bmsljr() {
        List<Map<String, Object>> bmsljr = egovIndexService.bmsljr();
        return bmsljr;
    }

    //部门办结今日	author zxp
    @RequestMapping("bmbjjr")
    @ResponseBody
    public Object bmbjjr() {
        List<Map<String, Object>> bmbjjr = egovIndexService.bmbjjr();
        return bmbjjr;
    }

    //部门受理本月	author zxp
    @RequestMapping("bmslby")
    @ResponseBody
    public Object bmslby() {
        List<Map<String, Object>> bmslby = egovIndexService.bmslby();
        return bmslby;
    }

    //部门办结本月	author zxp
    @RequestMapping("bmbjby")
    @ResponseBody
    public Object bmbjby() {
        List<Map<String, Object>> bmbjby = egovIndexService.bmbjby();
        return bmbjby;
    }

    //部门受理本年	author zxp
    @RequestMapping("bmslbn")
    @ResponseBody
    public Object bmslbn() {
        List<Map<String, Object>> bmslbn = egovIndexService.bmslbn();
        return bmslbn;
    }

    //部门办结本年	author zxp
    @RequestMapping("bmbjbn")
    @ResponseBody
    public Object bmbjbn() {
        List<Map<String, Object>> bmbjbn = egovIndexService.bmbjbn();
        return bmbjbn;
    }

    //部门受理全部	author zxp
    @RequestMapping("bmslqb")
    @ResponseBody
    public Object bmslqb() {
        List<Map<String, Object>> bmslqb = egovIndexService.bmslqb();
        return bmslqb;
    }

    //部门办结全部	author zxp
    @RequestMapping("bmbjqb")
    @ResponseBody
    public Object bmbjqb() {
        List<Map<String, Object>> bmbjqb = egovIndexService.bmbjqb();
        return bmbjqb;
    }


    //部门受理排名
    @RequestMapping("/bmslpm")
    @ResponseBody
    public Object bmslpm() {
        List<Map<String, Object>> list = egovIndexService.bmslpm();
        return list;
    }

    //部门办结排名
    @RequestMapping("/bmbjpm")
    @ResponseBody
    public Object bmbjpm() {
        List<Map<String, Object>> list = egovIndexService.bmbjpm();
        return list;
    }

    //部门预警红牌
    @RequestMapping("/bmyjhongpai")
    @ResponseBody
    public Object bmyjhongpai() {
        List<Map<String, Object>> hpslList = egovIndexService.bmyjhongpaisl();
        List<Map<String, Object>> hpmxList = egovIndexService.bmyjhongpaimx();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hpsl", hpslList.get(0).get("sl"));
        map.put("hpmxList", hpmxList);
        return map;
    }

    //部门预警黄牌
    @RequestMapping("/bmyjhuangpai")
    @ResponseBody
    public Object bmyjhuangpai() {
        List<Map<String, Object>> hpslList = egovIndexService.bmyjhuangpaisl();
        List<Map<String, Object>> hpmxList = egovIndexService.bmyjhuangpaimx();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hpsl", hpslList.get(0).get("sl"));
        map.put("hpmxList", hpmxList);
        return map;
    }

    /**
     * 市直部门已发布事项 柱状图
     *
     * @param sxlx 事项类型：全部事项（13类）、政务服务事项（11类）、依申请事项（9类）、试点事项（6类）
     *             默认显示全部事项
     */
    @RequestMapping("/szbmsxgszzt")
    @ResponseBody
    public List<Map<String, Object>> szbmsxgszzt(@RequestParam("sxlx") String sxlx,
                              @RequestParam("startTime")String startTime,
                              @RequestParam("endTime")String endTime) {

        List<Map<String, Object>> szbmsxgszzt = egovIndexService.szbmsxgszzt(sxlx, startTime, endTime);

        return szbmsxgszzt;

    }

    //市直部门柱状图详情表格
    @RequestMapping("/szbmsxgszztxqbg")
    @ResponseBody
    public Object szbmsxgszztxqbg(@RequestParam("sxlx") String sxlx,
                                  @RequestParam(value = "orgName", required = false) String orgName,
                                  @RequestParam("page") int page,
                                  @RequestParam("limit") int limit,
                                  @RequestParam(value = "startTime",required = false)String startTime,
                                  @RequestParam(value = "endTime",required = false)String endTime) {

        List<Map<String, Object>> list = egovIndexService.szbmsxgszztxqbg(sxlx, orgName, page, limit,startTime,endTime);

        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        map.put("msg", "");
        map.put("code", 0);

        return map;

    }


    //区县部门柱状图柱状图
    @RequestMapping("/qxbmsxgszzt")
    @ResponseBody
    public Object qxbmsxgszzt(@RequestParam("sxlx") String sxlx,
                              @RequestParam("startTime")String startTime,
                              @RequestParam("endTime")String endTime) {

        List<Map<String, Object>> zztList = egovIndexService.qxbmsxgszzt(sxlx,startTime,endTime);

        return zztList;
    }

    //区县部门柱状图详情表格
    //today
    @RequestMapping("/qxbmsxgszztxqbg")
    @ResponseBody
    public Object qxbmsxgszztxqbg(@RequestParam("sxlx") String sxlx,
                                  @RequestParam(value = "orgName", required = false) String orgName,
                                  @RequestParam("page") int page,
                                  @RequestParam("limit") int limit,
                                  @RequestParam(value = "startTime",required = false)String startTime,
                                  @RequestParam(value = "endTime",required = false)String endTime) {


        List<Map<String, Object>> list = egovIndexService.qxbmsxgszztxqbg(sxlx, orgName, page, limit,startTime,endTime);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        map.put("msg", "");
        map.put("code", 0);


        return map;
    }

    /**
     * 市直部门饼状图
     * @param sxlx
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping("/szbmsxgsbzt")
    @ResponseBody
    public Object szbmsxgsbzt(@RequestParam("sxlx") String sxlx,
                              @RequestParam("startTime")String startTime,
                              @RequestParam("endTime")String endTime) {

        //线上
        String online = "'1','2','3'";
        //线下
        String offline = "'0'";
        //线上
        Integer xssl = egovIndexService.szbmsxgsbzt(sxlx,startTime,endTime,online);
        //线下
        Integer xxsl = egovIndexService.szbmsxgsbzt(sxlx,startTime,endTime,offline);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("xssl", xssl);
        map.put("xxsl", xxsl);
        return map;

    }

    /**
     * 市直部门饼状图详情表格是否可网上办理
     *
     * @param sxlx    事项类型
     * @param param   是否可网上办理 1是  2否
     * @param orgName 单位名称，查询的时候使用
     * @param page    分页开始索引
     * @param limit   分页每页数量
     * @return
     * @author BEAN_BAG
     */
    @RequestMapping("/szbmsxgsbztxqbg")
    @ResponseBody
    public Object szbmsxgsbztxqbg(@RequestParam("sxlx") String sxlx,
                                  @RequestParam("param") int param,
                                  @RequestParam(value = "orgName", required = false) String orgName,
                                  @RequestParam("page") int page,
                                  @RequestParam("limit") int limit,
                                  @RequestParam(value = "startTime",required = false) String startTime,
                                  @RequestParam(value = "endTime",required = false)String endTime) {

        String isOnline = "";
        if (param == 1) {
            //可网上办理
            isOnline = "'1','2','3'";
        } else if (param == 2) {
            //不可网上办理
            isOnline = "'0'";
        }
        List<Map<String, Object>> list = egovIndexService.szbmsxgsbztxqbg(sxlx, isOnline, orgName, page, limit,startTime,endTime);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        map.put("msg", "");
        map.put("code", 0);

        return map;
    }

    /**
     * 区县部门饼状图
     * @param sxlx
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping("/qxbmsxgsbzt")
    @ResponseBody
    public Object qxbmsxgsbzt(@RequestParam("sxlx") String sxlx,
                              @RequestParam("startTime")String startTime,
                              @RequestParam("endTime")String endTime) {
        //线上
        String online = "'1','2','3'";
        //线下
        String offline = "'0'";

        //线上
        Integer xssl = egovIndexService.qxbmsxgsbzt(sxlx,startTime,endTime,online);
        //线下
        Integer xxsl = egovIndexService.qxbmsxgsbzt(sxlx,startTime,endTime,offline);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("xssl", xssl);
        map.put("xxsl", xxsl);
        return map;


    }


    /**
     * 区县部门饼状图详情表格
     *
     * @param sxlx    事项类型
     * @param param   是否可网上办理 1是  2否
     * @param orgName 单位名称，查询的时候使用,非必须字段
     * @param page    分页开始索引
     * @param limit   分页每页数量
     * @author BEAN_BAG
     */
    @RequestMapping("/qxbmsxgsbztxqbg")
    @ResponseBody
    public Object qxbmsxgsbztxqbg(@RequestParam("sxlx") String sxlx,
                                  @RequestParam("param") int param,
                                  @RequestParam(value = "orgName", required = false) String orgName,
                                  @RequestParam("page") int page,
                                  @RequestParam("limit") int limit,
                                  @RequestParam(value = "startTime",required = false) String startTime,
                                  @RequestParam(value = "endTime",required = false)String endTime) {
        String isOnline = "";
        if (param == 1) {
            //可网上办理
            isOnline = "'1','2','3'";
        } else if (param == 2) {
            //不可网上办理
            isOnline = "'0'";
        }
        List<Map<String, Object>> list = egovIndexService.qxbmsxgsbztxqbg(sxlx, isOnline, orgName, page, limit,startTime,endTime);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        map.put("msg", "");
        map.put("code", 0);

        return map;

    }

    /**
     * 事项总览更多页面新增事项性质柱形图
     *
     * @param sxlx
     * @return
     */
    @RequestMapping("/sxxzChart")
    @ResponseBody
    public List<Map<String, Object>> sxxzChart(@RequestParam("sxlx") String sxlx,
                                               @RequestParam("startTime")String startTime,
                                               @RequestParam("endTime")String endTime) {

        List<Map<String, Object>> list = egovIndexService.sxxzChart(sxlx, startTime, endTime);

        return list;
    }


    /**
     * 事项总览更多页面 新增 事项性质柱形图 详情表格
     *
     * @return
     */
    @RequestMapping("/sxxzchartxqbg")
    @ResponseBody
    public Object sxxzchartxqbg(@RequestParam("sxlx") String sxlx,
                                @RequestParam(value = "orgName", required = false) String orgName,
                                @RequestParam("page") int page,
                                @RequestParam("limit") int limit,
                                @RequestParam("startTime")String startTime,
                                @RequestParam("endTime")String endTime) {

        List<Map<String, Object>> list = egovIndexService.sxxzchartxqbg(sxlx, orgName, page, limit,startTime,endTime);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        map.put("msg", "");
        map.put("code", 0);

        return map;
    }

    //事项性质数据表格
    @RequestMapping("/sxxzTableDate")
    @ResponseBody
    public Object sxxzTableDate(@RequestParam("page") Integer page,
                                @RequestParam("limit") Integer limit) {

        //page当前页，limit每页显示的条数
        //计算开始行和结束行
        int startRows = (page - 1) * limit;
        int endRows = page * limit + 1;
        Map<String, Object> resultMap = egovIndexService.sxxzTableDate(startRows, endRows);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", resultMap.get("nums"));
        map.put("data", resultMap.get("resultList"));

        return map;
    }

    //已发布事项总数-下载
    @RequestMapping("/sxzlDownload")
    public void egovIndexDownload(@RequestParam("sxType") String sxType,
                                  @RequestParam("downloadValue") String downloadValue,
                                  @RequestParam(value = "startTime",required = false)String startTime,
                                  @RequestParam(value = "endTime",required = false)String endTime,
                                  HttpServletResponse response) {
        try {
            List<Map<String, Object>> resultList = null;
            String isOnline = "";
            switch (downloadValue) {
                case "szbmsxgs":
                    resultList = egovIndexService.szbmsxgs(sxType,startTime,endTime);
                    break;
                case "szbmsxgsbzt-xssx":
                    isOnline = "'1','2','3'";
                    resultList = egovIndexService.szbmsxgsbztDownload(sxType, isOnline,startTime,endTime);
                    break;
                case "szbmsxgsbzt-xxsx":
                    isOnline = "'0'";
                    resultList = egovIndexService.szbmsxgsbztDownload(sxType, isOnline,startTime,endTime);
                    break;
                case "qxbmsxgs":
                    resultList = egovIndexService.qxbmsxgs(sxType,startTime,endTime);
                    break;
                case "qxbmsxgsbzt-xssx":
                    isOnline = "'1','2','3'";
                    resultList = egovIndexService.qxbmsxgsbztDownload(sxType, isOnline,startTime,endTime);
                    break;
                case "qxbmsxgsbzt-xxsx":
                    isOnline = "'0'";
                    resultList = egovIndexService.qxbmsxgsbztDownload(sxType, isOnline,startTime,endTime);
                    break;
                case "sxxz-chart":
                    resultList = egovIndexService.sxxzchartxqbg(sxType, null, 0, 0,startTime,endTime);
                default:
                    break;
            }
            if (downloadValue.equals("sxxz-chart")) {
                File file = ResourceUtils.getFile("classpath:static/excel/事项统计.xlsx");
                TemplateExportExcelUtil.exportExcel(file, resultList, response);
            } else {
                File file = ResourceUtils.getFile("classpath:static/excel/已发布事项总数.xlsx");
                TemplateExportExcelUtil.exportExcel(file, resultList, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 办件量(去掉数据交换) 下载
     *
     * @return
     * @date 2019年1月2日
     */
    @RequestMapping("/sxxzDownload")
    public void sxxzDownload(HttpServletResponse response) {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/excel/办件量(去掉数据交换).xlsx");
            //查询数据
            LinkedHashMap<String, Object> map = egovIndexService.bjlTableData();
            ArrayList list1 = (ArrayList) map.get("list1");
            ArrayList list2 = (ArrayList) map.get("list2");
            ArrayList list3 = (ArrayList) map.get("list3");
            ArrayList list4 = (ArrayList) map.get("list4");


            List<Map<String, Object>> downList = new ArrayList<Map<String, Object>>();

            for (int i=1;i<=4;i++){
                Map<String,Object> tempMap = new LinkedHashMap<>();

                switch (i){
                    case 1:
                        for (int j=0;j<list1.size();j++){
                            tempMap.put("k"+j,list1.get(j));
                        }
                        downList.add(tempMap);
                        break;
                    case 2:
                        for (int j=0;j<list2.size();j++){
                            tempMap.put("k"+j,list2.get(j));
                        }
                        downList.add(tempMap);
                        break;
                    case 3:
                        for (int j=0;j<list3.size();j++){
                            tempMap.put("k"+j,list3.get(j));
                        }
                        downList.add(tempMap);
                        break;
                    case 4:
                        for (int j=0;j<list4.size();j++){
                            tempMap.put("k"+j,list4.get(j));
                        }
                        downList.add(tempMap);
                        break;
                        default:
                            break;
                }
            }

            TemplateExportExcelUtil.exportExcel(file, downList, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    //事项受理办结统计表格下载
    @RequestMapping("/egovIdnexSXQSMDownload")
    public void egovIdnexSXQSMDownload(HttpServletResponse response) {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/excel/事项受理办结统计.xlsx");
            //查询数据
            List<Map<String, Object>> list = egovIndexService.egovIdnexSXQSMDownload();
            TemplateExportExcelUtil.exportExcel(file, list, response);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }






}
