package com.inspur.controller;


import com.inspur.service.BlspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 并联审批controller
 *
 * @author ly
 * @date 2018年12月5日
 */
@RestController
@RequestMapping("/blspController")
public class BlspController {
    @Autowired
    private BlspService blspService;

    /**
     * 测试并联审批能不能获取数据
     */
    @RequestMapping("/blspss")
    @ResponseBody
    public Map<String, Object> blspss() {
        Map<String, Object> map = new HashMap<String, Object>();
        int sxzlsl = blspService.getSum();
        System.out.println(sxzlsl);
        map.put("blsp", sxzlsl);
        return map;
    }

    /**
     * 获取项目数量
     */
    @RequestMapping(value = "/getprojectsum", method = RequestMethod.GET)
    public Map<String, Object> getprojectsum() {
        Map<String, Object> map = new HashMap<String, Object>();
        // 项目数量
        int projectsum = blspService.getprojectsum();
        //  市本级项目数量
        int getjnssum = blspService.getjnssum();
        // 区县数量
        int getqxsum = blspService.getqxsum();
        // 获取社会投资建设项目数量
        int shtz = blspService.getshtz();
        // 获取公共投资建设项目数量
        int ggjs = blspService.getggjs();
        //  资金数额
        List<Map<String, Object>> zjs = blspService.getzjsum();
        double total = 0.00;
        // 总投资额
        for (int i = 0; i < zjs.size(); i++) {
            total += Double.parseDouble(zjs.get(i).get("TOTAL_INVESTMENT").toString());
        }
        System.out.println(total);
        // 项目数量
        map.put("sum", projectsum);
        // 市本级项目数
        map.put("jnssum", getjnssum);
        // 区县项目数
        map.put("qxsum", getqxsum);
        // 总投资额
        map.put("total", total);
        // 社会投资
        map.put("ggjs", ggjs);
        // 公共投资
        map.put("shtz", shtz);
        return map;
    }

    /**
     * 获取项目类别/项目类型
     */
    @RequestMapping(value = "/getprojectlb", method = RequestMethod.GET)
    public Map<String, Object> getprojectlb() {
        Map<String, Object> map = new HashMap<String, Object>();
        // 项目类别
        List<Map<String, Object>> list = blspService.getxmlb();
        //项目类型
        List<Map<String, Object>> lists = blspService.getxmlx();
        // 项目资金分布
        List<Map<String, Object>> listzj = blspService.getxmzjfb();
        System.out.println(list);
        map.put("xmszj", list);
        System.out.println(list);
        System.out.println(lists);
        System.out.println(listzj);
        map.put("xmlb", list);
        map.put("xmlx", lists);
        map.put("zjfb", listzj);
        return map;
    }

    /**
     * 各区县项目数量
     */
    @RequestMapping(value = "/getqhxmsl", method = RequestMethod.GET)
    public Map<String, Object> getqhxmsl() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = blspService.getqhxmsl();
        System.out.println(list);
        map.put("qhxmsl", list);
        return map;
    }

    /**
     * 项目申报情况统计
     */
    @RequestMapping(value = "/getsbqktj", method = RequestMethod.GET)
    public Map<String, Object> getsbqktj() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = blspService.getsbqktj();
        map.put("sbqk", list);
        return map;
    }

    /**
     * 业务状态统计
     */
    @RequestMapping(value = "/getywzttj", method = RequestMethod.GET)
    public Map<String, Object> getywzttj(@RequestParam(value = "stageid", required = true) String stageid) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = blspService.getywzttj(stageid);
        map.put("ywzttj", list);
        return map;
    }

    /**
     * 每月联办业务受理数
     */
    @RequestMapping(value = "/getlbywsls", method = RequestMethod.GET)
    public Map<String, Object> getlbywsls() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = blspService.getlbywsls();
        map.put("lbywsls", list);
        return map;
    }

    /**
     * 每月联办业务受理数
     */
    @RequestMapping(value = "/getprojectlist", method = RequestMethod.GET)
    public Map<String, Object> getprojectlist() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = blspService.getproject();
        map.put("projectlist", list);
        return map;
    }

}
