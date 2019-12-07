package com.inspur.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inspur.service.IndexService;
import com.inspur.service.ShareIndexService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/indexController")
public class IndexController {

    @Autowired
    IndexService indexService;

    @Resource
    ShareIndexService shareIndexService;

    //今日受理办结数量
    @RequestMapping("/jrslbjsl")
    @ResponseBody
    public Object jrslbjsl() {
        List<Map<String, Object>> list = indexService.jrslbjsl();
        int[] itemsjzl = new int[6];
        int[] organsjzl = new int[6];
        int[] projectzl = new int[6];
        int[] itemnums = new int[list.size()];
        int[] itemnumsed = new int[list.size()];
        int[] organnums = new int[list.size()];
        int[] organnumsed = new int[list.size()];
        int[] projectnums = new int[list.size()];
        int[] projectnumsed = new int[list.size()];
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                itemnums[i] = Integer.parseInt(map.get("itemnums").toString());
                itemnumsed[i] = Integer.parseInt(map.get("itemnumsed").toString());
                organnums[i] = Integer.parseInt(map.get("organnums").toString());
                organnumsed[i] = Integer.parseInt(map.get("organnumsed").toString());
                projectnums[i] = Integer.parseInt(map.get("pronums").toString());
                projectnumsed[i] = Integer.parseInt(map.get("pronumsed").toString());
            }
            itemsjzl[0] = itemnums[0];
            itemsjzl[1] = itemnumsed[0];
            itemsjzl[2] = itemnums[1];
            itemsjzl[3] = itemnumsed[1];
            itemsjzl[4] = itemnums[2];
            itemsjzl[5] = itemnumsed[2];

            organsjzl[0] = organnums[0];
            organsjzl[1] = organnumsed[0];
            organsjzl[2] = organnums[1];
            organsjzl[3] = organnumsed[1];
            organsjzl[4] = organnums[2];
            organsjzl[5] = organnumsed[2];

            projectzl[0] = projectnums[0];
            projectzl[1] = projectnumsed[0];
            projectzl[2] = projectnums[1];
            projectzl[3] = projectnumsed[1];
            projectzl[4] = projectnums[2];
            projectzl[5] = projectnumsed[2];
        }
        Map<String, Object> jrslbjslMap = new HashMap<String, Object>();
        jrslbjslMap.put("jrslsl", projectzl[0]);
        jrslbjslMap.put("jrbjsl", projectzl[1]);
        return jrslbjslMap;
    }

    //今日服务接口调用次数
    @RequestMapping("/jrfwjkdycs")
    @ResponseBody
    public Object jrfwjkdycs() {
        List<Map<String, Object>> list = indexService.jrfwjkdycs();
        Map<String, Object> jrfwjkdycsMap = new HashMap<String, Object>();
        jrfwjkdycsMap.put("jrfwjkdycs", list.get(0).get("total"));
        return jrfwjkdycsMap;
    }


    /**
     * 事项网办深度
     */
    @RequestMapping("/onlineConduct")
    @ResponseBody
    public Object onlineConduct() {
        Map<String, Object> map = new HashMap<String, Object>();
        String online_status = null;
        int offline_count = 0;
        List<Map<String, Object>> listOnlineConduct = indexService.onlineConduct();
        for (Map<String, Object> mapTemp : listOnlineConduct) {
            if (mapTemp.get("ONLINE_STATUS") != null) {
                online_status = mapTemp.get("ONLINE_STATUS").toString();
            }
            if (online_status != null && online_status.equals("0")) {
                //线上事项数量
                map.put("count_online", mapTemp.get("count_is_online"));
            }
            if (online_status != null && online_status.equals("1")) {
                //线下事项数量
                offline_count = Integer.parseInt(mapTemp.get("count_is_online").toString());

            }
            if (online_status != null && online_status.equals("2")) {
                //线下事项数量
                offline_count += Integer.parseInt(mapTemp.get("count_is_online").toString());
            }
        }

        map.put("count_offline", offline_count);
        return map;
    }

    /**
     * 共享交换数据提供部门数:文件，接口，库表
     */
    @RequestMapping("/countOrg")
    @ResponseBody
    public Object countOrg() {
        Map<String, Object> map = new HashMap<String, Object>();

        int countServiceOrg = 0;
        int countDbTableOrg = 0;
        int countFileOrg = 0;

        //提供接口的单位
        List<Map<String, Object>> listServiceOrg = shareIndexService.getListServiceOrg();
        String org_code;
        List<String> listService = new ArrayList<String>();
        for (Map<String, Object> mapService : listServiceOrg) {
            org_code = mapService.get("org_code").toString();
            listService.add(org_code);
        }
        countServiceOrg = listService.size();
        map.put("countServiceOrg", countServiceOrg);

        //提供库表和文件的单位
        List<Map<String, Object>> listNoServiceOrg = indexService.getListNoServiceOrg();
        List<String> listNoService = new ArrayList<String>();
        for (Map<String, Object> mapTwo : listNoServiceOrg) {
            if (mapTwo.get("source_type").equals("数据库")) {
                countDbTableOrg = Integer.parseInt(mapTwo.get("count_org").toString());
            }
            if (mapTwo.get("source_type").equals("电子文件")) {
                countFileOrg = Integer.parseInt(mapTwo.get("count_org").toString());
            }
        }
        map.put("countFileOrg", countFileOrg);
        map.put("countDbTableOrg", countDbTableOrg);
        return map;
    }

    /**
     * 共享资源部门排名
     *
     * @return
     */
    @RequestMapping("/hotOrg")
    @ResponseBody
    public Object hotOrg() {
        Map<String, Object> map = new HashMap<String, Object>();

        List<Map<String, Object>> listHotOrg = shareIndexService.getHotOrg();
        List<String> xAxisData = new ArrayList<String>();
        List<String> seriesData = new ArrayList<String>();

        for (int i = 0; i < listHotOrg.size(); i++) {
            String organ_name = listHotOrg.get(i).get("organ_name").toString();
            String count_cata = listHotOrg.get(i).get("count_cata").toString();
            xAxisData.add(organ_name);
            seriesData.add(count_cata);
        }

        map.put("xAxisData", xAxisData);
        map.put("seriesData", seriesData);

        return map;
    }

}
