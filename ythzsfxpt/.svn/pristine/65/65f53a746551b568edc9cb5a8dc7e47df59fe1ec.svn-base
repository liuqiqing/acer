package com.inspur.controller;

import com.inspur.service.LibLicenseService;
import com.inspur.utils.DoubleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 证照库
 * @author zxp
 * @date 2019年1月9日
 *
 *
 */
@Controller
@RequestMapping("/libLicenseController")
public class LibLicenseController {

    @Autowired
    private LibLicenseService libLicenseService;

    /**
     * 市直占比
     * 区县占比
     */
    @RequestMapping("/szqxzb")
    @ResponseBody
    public Map<String,Object> szqxzb(){
        String szqxzs = libLicenseService.szqxzs();
        String szzb = libLicenseService.szzb();
        String qxzb = libLicenseService.qxzb();

        double sz = Double.parseDouble(szzb);
        double qx = Double.parseDouble(qxzb);
        double szqx = Double.parseDouble(szqxzs);

        String szPercent = DoubleUtils.getDoublePercent2(sz, szqx);
        String qxPercent = DoubleUtils.getDoublePercent2(qx, szqx);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("szPercent",szPercent);
        map.put("qxPercent",qxPercent);

        return map;
    }

    /**
     * 证照颁发情况柱形图
     */
    @RequestMapping("/zzbfqkzxt")
    @ResponseBody
    public List<Map<String, Object>> zzbfqkzxt(){
        List<Map<String, Object>> zzbfqkzxt = libLicenseService.zzbfqkzxt();

        return zzbfqkzxt;
    }

    /**
     * 颁发单位总数
     */
    @RequestMapping("/bfdwzs")
    @ResponseBody
    public Map<String,Object> bfdwzs(){
        String bfdwzs = libLicenseService.bfdwzs();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("bfdwzs",bfdwzs);
        return map;

    }

    /**
     * 个人证照总数
     */
    @RequestMapping("/grzzzs")
    @ResponseBody
    public Map<String,Object> grzzzs(){
        String grzzzs = libLicenseService.grzzzs();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("grzzzs",grzzzs);
        return map;
    }

    /**
     * 教师资格证
     */
    @RequestMapping("/jszgz")
    @ResponseBody
    public Map<String,Object> jszgz(){
        String jszgz = libLicenseService.jszgz();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("jszgz",jszgz);
        return map;
    }

    /**
     * 旅行社经营许可证
     */
    @RequestMapping("/lxsjyxk")
    @ResponseBody
    public Map<String,Object> lxsjyxk(){
        String lxsjyxk = libLicenseService.lxsjyxk();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("lxsjyxk",lxsjyxk);
        return map;
    }
    /**
     * 事业单位法人证书
     */
    @RequestMapping("/sydwfrzs")
    @ResponseBody
    public Map<String,Object> sydwfrzs(){
        String sydwfrzs = libLicenseService.sydwfrzs();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sydwfrzs",sydwfrzs);
        return map;
    }
    /**
     * 残疾人证书
     */
    @RequestMapping("/cjrzs")
    @ResponseBody
    public Map<String,Object> cjrzs(){
        String cjrzs = libLicenseService.cjrzs();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("cjrzs",cjrzs);
        return map;
    }
    /**
     * 个人证照总数
     */
    @RequestMapping("/frzzsl")
    @ResponseBody
    public Map<String,Object> frzzsl(){
        String frzzsl = libLicenseService.frzzsl();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("frzzsl",frzzsl);
        return map;
    }

    /**
     * 证照类型总数
     */
    @RequestMapping("/zzlxzs")
    @ResponseBody
    public Map<String,Object> zzlxzs(){
        String zzlxzs = libLicenseService.zzlxzs();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("zzlxzs",zzlxzs);
        return map;
    }

    /**
     * 证照状态饼图
     */
    @RequestMapping("/zzztPie")
    @ResponseBody
    public List<Map<String,Object>> zzztPie(){
        //证照状态 注销数量
        String zzztzxsl = libLicenseService.zzztzxsl();
        //证照状态 废止数量
        String zzztfzsl = libLicenseService.zzztfzsl();
        //证照状态 签章数量
        String zzztqzsl = libLicenseService.zzztqzsl();
        //证照状态 超期数量
        String zzztcqsl = libLicenseService.zzztcqsl();

        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("name","注销");
        map1.put("value",zzztzxsl);

        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("name","废止");
        map2.put("value",zzztfzsl);

        Map<String,Object> map3 = new HashMap<String, Object>();
        map3.put("name","签章");
        map3.put("value",zzztqzsl);

        Map<String,Object> map4 = new HashMap<String, Object>();
        map4.put("name","超期");
        map4.put("value",zzztcqsl);

        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
        resultList.add(map1);
        resultList.add(map2);
        resultList.add(map3);
        resultList.add(map4);

        return resultList;
    }

    /**
     * 建设工程规划许可证
     */
    @RequestMapping("/jsgcghxkz")
    @ResponseBody
    public Map<String,Object> jsgcghxkz(){
        List<Map<String, Object>> jsgcghxkz = libLicenseService.jsgcghxkz();
        //处理数据后，返回给页面
        List<String> xList = new ArrayList<String>();
        List<String> yList = new ArrayList<String>();

        for(int i=0;i<jsgcghxkz.size();i++){

            if (jsgcghxkz.get(i).get("NF") != null){
                String nf = jsgcghxkz.get(i).get("NF").toString();
                String sl = jsgcghxkz.get(i).get("SL").toString();
                xList.add(nf);
                yList.add(sl);
            }

        }
        System.out.println("xList==========="+xList);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("xList",xList);
        map.put("yList",yList);

        return map;
    }

    /**
     *  企业、个人工商营业执照
     */
    @RequestMapping("/qygrgsyyzz")
    @ResponseBody
    public Map<String,Object> qygrgsyyzz(){
        List<Map<String, Object>> qygrgsyyzz = libLicenseService.qygrgsyyzz();
        //处理数据，返回给页面
        //处理数据后，返回给页面
        List<String> xList = new ArrayList<String>();
        List<String> yList = new ArrayList<String>();

        for(int i=0;i<qygrgsyyzz.size();i++){
            Map<String, Object> map = qygrgsyyzz.get(i);
            String nf = map.get("NF").toString();
            String sl = map.get("SL").toString();

            xList.add(nf);
            yList.add(sl);
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("xList",xList);
        map.put("yList",yList);

        return map;
    }

    @RequestMapping("/bmzzsl")
    @ResponseBody
    public List<Map<String,Object>> bmzzsl(){
        List<Map<String, Object>> bmzzsl = libLicenseService.bmzzsl();
        return bmzzsl;

    }

    //济南市颁发电子证照总数
    @RequestMapping("/jnsdzzz")
    @ResponseBody
    public Map<String,Object> jnsdzzz(){
        String jnsdzzz = libLicenseService.jnsdzzz();
        Map<String,Object> _map = new HashMap<String, Object>();
        _map.put("jnsdzzz",jnsdzzz);

        return _map;
    }

    //市区证照情况
    @RequestMapping("/sqzzqk")
    @ResponseBody
    public List<Map<String,Object>> sqzzqk(){
        List<Map<String, Object>> sqzzqk = libLicenseService.sqzzqk();

        return sqzzqk;
    }



}
