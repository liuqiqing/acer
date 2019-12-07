package com.inspur.controller;

import com.inspur.service.EgovIndexService;
import com.inspur.service.PdjhService;
import com.inspur.service.SxglService;
import com.inspur.utils.TaskDemo;
import com.inspur.utils.TemplateExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sxgl")
public class SxglController {
    @Autowired
    private SxglService sxglService;

    @Autowired
    private EgovIndexService egovIndexService;

    @Autowired
    private PdjhService pdjhService;

    final Map<String,Integer> map;

    public SxglController(Map<String, Integer> map) {
        this.map = map;
    }

    /**
     * 其中可网上办理的：426
     * “conduct_depth”是网办深度或审批深度：
     * “1”是全程网办（0跑腿）；
     * “2”是在线预审（只跑1次）；
     * “3”是事项公开，
     * “4”是在线申办。
     */
    @RequestMapping(value = "/kwsblsl", method = RequestMethod.POST)
    public Map<String, Integer> kwsblsl() {
        int wsbl = sxglService.kwsblsl();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("wsbl", wsbl);
        System.out.println("wsbl:=======" + wsbl);
        return map;
    }

    /**
     * 已办结数量
     * CURRENT_NODE_NAME = '已办结' and IS_DELETE = '0'
     */
    @RequestMapping(value = "/ybjsl", method = RequestMethod.POST)
    public Map<String, Integer> ybjsl() {
        int ybjsl = sxglService.ybjsl();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("ybjsl", ybjsl);
        System.out.println("ybjsl:=======" + ybjsl);
        return map;
    }

    /**
     * 当月的事项办结量
     */
    @RequestMapping(value = "/tjcx", method = RequestMethod.POST)
    public Map<String, Integer> tjsl() {
        // 办结数
        int ybjsl = sxglService.ybjsl();
        // 退件数量
        int tjsl = sxglService.tjsl();
        // 网上申报数量
        int wssbl = sxglService.wssbl();
        // 一窗受理量
        int ycsll = sxglService.ycsll();
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("ybjsl", ybjsl);
        map.put("tjsl", tjsl);
        map.put("wssbl", wssbl);
        map.put("ycsll", ycsll);
        System.out.println("ybjsl:=======" + ybjsl);
        System.out.println("tjsl:=======" + tjsl);
        System.out.println("wssbl:=======" + wssbl);
        System.out.println("ycsll:=======" + ycsll);
        return map;
    }

    /**
     * 可网上办理数量
     *
     * @return
     */
    @RequestMapping(value = "/wsblsl", method = RequestMethod.GET)
    public Map<String, Object> wsblsl() {
        Map<String, Object> map = new HashMap<String, Object>();
        //可网上办理数量(事项数)
        int wsbl = sxglService.kwsblsl();
        int wsbls = sxglService.kwsbl();
        map.put("wsbl", wsbl);
        map.put("total", wsbls);
        return map;
    }

    /**
     * 济南市办结事项前十
     */
    @RequestMapping(value = "/sxbjqs", method = RequestMethod.POST)
    public Map<String, Object> sxbjqs() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = sxglService.sxbjqs();
        map.put("list", list);
        return map;
    }

    /**
     * 红牌数量和黄牌数量
     */
    @RequestMapping(value = "/hhpsl", method = RequestMethod.GET)
    public Map<String, Object> hhpsl() {
        Map<String, Object> map = new HashMap<String, Object>();
        int hongpai = sxglService.hongpai();
        int huangpai = sxglService.huangpai();
        map.put("hongpai", hongpai);
        map.put("huangpai", huangpai);
        System.out.println("hongpai====" + hongpai);
        System.out.println("huangpai====" + huangpai);
        return map;
    }

    /**
     * 查询当天所有的叫号数量(不分组)
     */
    @RequestMapping(value = "/pdjh", method = RequestMethod.GET)
    public Map<String, Object> pdjh() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象，获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        System.out.println("Cdate======" + Cdate);
        int pdjh = pdjhService.getSum(Cdate);
        map.put("pdjh", pdjh);
        System.out.println("pdjh====" + pdjh);
        return map;
    }

    /**
     * // 查询当天所有的叫号数量（正在处理、已放弃、等待、处理完毕）
     */
    @RequestMapping(value = "/getpdjhsl", method = RequestMethod.GET)
    public Map<String, Object> getpdjhsl() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象，获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        System.out.println("Cdate======" + Cdate);
        List<Map<String, Object>> pdjhsl = pdjhService.getpdjhsl(Cdate);
        map.put("pdjhsl", pdjhsl);
        System.out.println("pdjhsl====" + pdjhsl);
        return map;
    }

    /**
     * 排队叫号每天处理业务前10的窗口
     */
    @RequestMapping(value = "/getckqs", method = RequestMethod.GET)
    public Map<String, Object> getckqs() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象，获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        System.out.println("Cdate======" + Cdate);
        List<Map<String, Object>> ckqs = pdjhService.getckqs(Cdate);
        map.put("ckqs", ckqs);
        System.out.println("ckqs====" + ckqs);
        return map;
    }

    /**
     * 每天排队等候的时间(平均)
     */
    @RequestMapping(value = "/getpddhsj", method = RequestMethod.GET)
    public Map<String, Object> getpddhsj() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象，获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        System.out.println("Cdate======" + Cdate);
        // <!-- 查询排队等候时间 a：1-5分钟，b:5-10分钟，c:10-15分钟，d:15-20分钟，e：20-25分钟，f:25-30  g30以上 -->
        List<Map<String, Object>> ckqs = pdjhService.getpddhsj(Cdate);
        // <!-- 分组查询排队叫号时间的数量    -->
        List<Map<String, Object>> total = pdjhService.getsjsum(Cdate);
        //map.put("ckqs", ckqs);
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        int sum5 = 0;
        int sum6 = 0;
        int sum7 = 0;
        int total1 = 0;
        int total2 = 0;
        int total3 = 0;
        int total4 = 0;
        int total5 = 0;
        int total6 = 0;
        int total7 = 0;
        // 获取排队叫号时间的数量
        for (int i = 0; i < total.size(); i++) {
            if (total.get(i).get("msg").equals("a")) {
                total1 = Integer.parseInt(total.get(i).get("total").toString());
            } else if (total.get(i).get("msg").equals("b")) {
                total2 = Integer.parseInt(total.get(i).get("total").toString());
            } else if (total.get(i).get("msg").equals("c")) {
                total3 = Integer.parseInt(total.get(i).get("total").toString());
            } else if (total.get(i).get("msg").equals("d")) {
                total4 = Integer.parseInt(total.get(i).get("total").toString());
            } else if (total.get(i).get("msg").equals("e")) {
                total5 = Integer.parseInt(total.get(i).get("total").toString());
            } else if (total.get(i).get("msg").equals("f")) {
                total6 = Integer.parseInt(total.get(i).get("total").toString());
            } else {
                total7 = Integer.parseInt(total.get(i).get("total").toString());
            }
        }
        // 查询排队等候时间
        for (int i = 0; i < ckqs.size(); i++) {
            //System.out.println(ckqs.get(i).get("msg"));
            if (ckqs.get(i).get("msg").equals("a")) {
                sum1 += Integer.parseInt(ckqs.get(i).get("time").toString());
            } else if (ckqs.get(i).get("msg").equals("b")) {
                sum2 += Integer.parseInt(ckqs.get(i).get("time").toString());
            } else if (ckqs.get(i).get("msg").equals("c")) {
                sum3 += Integer.parseInt(ckqs.get(i).get("time").toString());
            } else if (ckqs.get(i).get("msg").equals("d")) {
                sum4 += Integer.parseInt(ckqs.get(i).get("time").toString());
            } else if (ckqs.get(i).get("msg").equals("e")) {
                sum5 += Integer.parseInt(ckqs.get(i).get("time").toString());
            } else if (ckqs.get(i).get("msg").equals("f")) {
                sum6 += Integer.parseInt(ckqs.get(i).get("time").toString());
            } else {
                sum7 += Integer.parseInt(ckqs.get(i).get("time").toString());
            }

        }
        Map<String, Object> maps = new HashMap<String, Object>();
        if (total1 == 0) {
            map.put("a", 0);
        } else {
            map.put("a", sum1 / total1);
        }
        if (total2 == 0) {
            map.put("b", 0);
        } else {
            map.put("b", sum2 / total2);
        }
        if (total3 == 0) {
            map.put("c", 0);
        } else {
            map.put("c", sum3 / total3);
        }
        if (total4 == 0) {
            map.put("d", 0);
        } else {
            map.put("d", sum4 / total4);
        }
        if (total5 == 0) {
            map.put("e", 0);
        } else {
            map.put("e", sum5 / total5);
        }
        if (total6 == 0) {
            map.put("f", 0);
        } else {
            map.put("f", sum6 / total6);
        }
        if (total7 == 0) {
            map.put("g", 0);
        } else {
            map.put("g", sum7 / total7);
        }
        System.out.println("map:=====" + map);
        return map;
    }

    /**
     * 网办深度要素分类
     * （1）-互联网咨询
     * （2）-互联网收件
     * （3）-互联网预审
     * （4）-互联网受理
     * （5）-互联网办理
     * （6）-互联网办理结果信息反馈
     * （7）-互联网电子证照反馈
     * （9）其他
     * 网办深度分级展现方案：
     * 一级信息发布：包含（1）互联网咨询，不支持网上申办。
     * 二级材料预审：包含（2）互联网收件、（3）互联网预审，支持网上申办。
     * 三级材料核验：包含（4）互联网受理，支持网上申办。
     * 四级全程网办：包含（5）互联网办理、（6）互联网办理结果信息反馈、（7）互联网电子证照反馈，支持网上申办。
     * 分级展现逻辑：
     * 1、若某一事项网办深度有且仅有要素（9），则归类为第一级。
     * 2、若某一事项包含多个要素且不包含要素（9），则系统经逻辑判断后取其最大值进行分级。
     * 若某一事项同时包含要素（9）和其他要素，则系统自动忽略要素（9），其他要素取其最大值进行分级。
     * IS_ONLINE :0 不可网上办理
     */
    @RequestMapping(value = "/getwbsd", method = RequestMethod.GET)
    public Map<String, Object> getwbsd() {
        // 获取网办深度
        List<Map<String, Object>> wbsd = sxglService.getwbsd();
        //System.out.println(wbsd);
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        String[] a = null;
        for (int i = 0; i < wbsd.size(); i++) {
            // 如果 IS_ONLINE == 0 并且 有且仅有要素（9），则归类为第一级。
            if (wbsd.get(i).get("IS_ONLINE").equals("0")) {
                if (wbsd.get(i).get("ONLINE_HANDLE_TYPE") != null) {
                    String type = wbsd.get(i).get("ONLINE_HANDLE_TYPE").toString();
                    boolean status = type.contains("1");
                    //若某一事项网办深度有且仅有要素（9），则归类为第一级。
                    if (status == true || type.equals('9')) {
                        //    一级信息发布
                        //    System.out.println();
                        sum1++;
                    }
                }
            } else {
                if (wbsd.get(i).get("ONLINE_HANDLE_TYPE") != null) {
                    String type = wbsd.get(i).get("ONLINE_HANDLE_TYPE").toString();
                    //二级材料预审
                    boolean status = type.contains("2^3");
                    boolean state = type.contains("2,3");
                    //三级材料核验
                    boolean states = type.contains("4");
                    //  四级全程网办
                    boolean wbstate = type.contains("5^6^7");
                    boolean wbstates = type.contains("5,6,7");
                    //    其他情况
                    //    若某一事项包含多个要素且不包含要素（9），则系统经逻辑判断后取其最大值进行分级。
                    //    若某一事项同时包含要素（9）和其他要素，则系统自动忽略要素（9），其他要素取其最大值进行分级
                    boolean other = type.contains("9");
                    if (status == true || state == true) {
                        //    二级材料预审
                        sum2++;
                    } else if (states == true) {
                        //三级材料核验
                        sum3++;
                    } else if (wbstate == true || wbstates) {
                        // 四级全程网办
                    } else if (type.length() > 2 && other == false) {
                        //若某一事项包含多个要素且不包含要素（9）
                        //System.out.println(type);
                        if (type.contains("5") || type.contains("6") || type.contains("7")) {
                            // 四级全程网办
                            sum4++;
                        } else if (type.contains("4")) {
                            //三级材料核验
                            sum3++;
                        } else if (type.contains("2") || type.contains("3")) {
                            //二级材料预审
                            sum2++;
                        }
                    } else if (type.length() > 2 && other == true) {
                        //若某一事项同时包含要素（9）和其他要素
                        //String str = type.replace("^",",");
                        //System.out.println(type);
                        if (type.contains("5") || type.contains("6") || type.contains("7")) {
                            // 四级全程网办
                            sum4++;
                        } else if (type.contains("4")) {
                            //三级材料核验
                            sum3++;
                        } else if (type.contains("2") || type.contains("3")) {
                            //二级材料预审
                            sum2++;
                        }
                    }
                }
            }

        }
        Map<String, Object> map = new HashMap<String, Object>();
        // 一级信息发布
        map.put("a", sum1);
        // 二级材料预审
        map.put("b", sum2);
        // 三级材料核验
        map.put("c", sum3);
        // 四级全程网办
        map.put("d", sum4);
        return map;
    }

    /**
     * 每天的办结数量
     */
    @RequestMapping(value = "/getdtbjsl", method = RequestMethod.GET)
    public Map<String, Object> getdtbjsl() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象，获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        System.out.println("Cdate======" + Cdate);
        // 审批的办结数量
        int spbj = sxglService.spbj(Cdate);
        // 一网通办的办结数量
        //int ywtb = sxglService.ywtbbj(Cdate);
        int spsl = sxglService.spsl(Cdate);
        map.put("spbj", spbj);
        //map.put("ywtb",ywtb);
        map.put("spsl", spsl);
        return map;
    }

    @RequestMapping(value = "/executor", method = RequestMethod.GET)
    public Map<String, Object> ScheduledExecutorService() {
        Map<String, Object> map = new HashMap<String, Object>();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);//启用2个线程
        TaskDemo t1 = new TaskDemo();

        // 立即执行，任务消耗3秒，执行结束后等待2秒，【有空余线程时】，再次执行该任务
        pool.scheduleWithFixedDelay(t1, 0, 2, TimeUnit.SECONDS);
        map.put("t1",t1.sum());
        return map;
    }
    /*窗口统计情况
    *
    * */
    @RequestMapping(value = "/cktjsum", method = RequestMethod.GET)
    public Map<String, Object> cktjsum() {
        Map<String, Object> map = new HashMap<String, Object>();
        Date now = new Date();    //创建一个Date对象，获取当前时间
        //指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String Cdate = f.format(now);
        /*排队完毕数*/
        int pdwbsum=pdjhService.pdwbsum(Cdate);
        //排队等待
        int pdddsum=pdjhService.pdddsum(Cdate);
        //排队处理
        int pdclsum=pdjhService.pdclsum(Cdate);
        //空闲窗口

        int kxcksum=pdjhService.kxcksum(Cdate);
        //窗口总数
        int ckzssum=pdjhService.ckzssum(Cdate);
        map.put("pdwbsum",pdwbsum);
        map.put("pdddsum",pdddsum);
        map.put("pdclsum",pdclsum);
        map.put("kxcksum",kxcksum);
        map.put("ckzssum",0);
        return map;
    }

    //获取排队等待数
    @RequestMapping(value = "/getpdddck", method = RequestMethod.GET)
    public Map<String, Object> getpdddck(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page) {
        System.out.println("1111111111111111111111111111111111111111111111111111111111111111111");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = pdjhService.getpdddinfo(year, month, day,page);
        System.out.println("pdddinfor=========" + list);
        map.put("pdddinfor", list);
        return map;

    }


    //下载排队等待窗口
    @RequestMapping(value = "/downloadpddd", method = RequestMethod.GET)
    public void downloadpddd(@RequestParam(value = "year", required = true) String year,
                             @RequestParam(value = "month", required = true) String month,
                             @RequestParam(value = "day", required = true) String day
                            ,HttpServletResponse response) {
        System.out.println("+_____-----------------------------------");
        Map<String, Object> map = new HashMap<String, Object>();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/excel/各窗口办件统计.xlsx");
            //查询数据
            List<Map<String, Object>> list = pdjhService.downloadzpddd(year,month,day);

            //System.out.println(list);
            // 往excel里写入数据
            TemplateExportExcelUtil.exportExcel(file, list, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //获取空闲窗口数
    @RequestMapping(value = "/getckkxck", method = RequestMethod.GET)
    public Map<String, Object> getckkxck(@RequestParam(value = "year", required = true) String year,
                                         @RequestParam(value = "month", required = true) String month,
                                         @RequestParam(value = "day", required = true) String day,
                                         @RequestParam(value = "page", required = true) String page) {
        System.out.println("545645");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = pdjhService .getckkxck(year, month, day, page);
        System.out.println("kxcksl=========" + list);
        map.put("kxcksl", list);
        return map;

    }



    //下载空闲窗口
    @RequestMapping(value = "/downloadkxck", method = RequestMethod.GET)
    public void downloadkxck(@RequestParam(value = "year", required = true) String year,
                             @RequestParam(value = "month", required = true) String month,
                             @RequestParam(value = "day", required = true) String day,
                             @RequestParam(value = "page", required = false) String page,HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/excel/空闲窗口办件统计.xlsx");
            //查询数据
            List<Map<String, Object>> list = pdjhService.downloadkxck(year, month, day, page);

            //System.out.println(list);
            // 往excel里写入数据
            TemplateExportExcelUtil.exportExcel(file, list, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }





}

