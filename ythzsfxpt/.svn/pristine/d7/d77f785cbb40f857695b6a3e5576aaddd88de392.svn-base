package com.inspur.controller;

import com.alibaba.fastjson.JSONObject;
import com.inspur.service.UserAuthorityService;
import com.inspur.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private UserAuthorityService userAuthorityService;

    /**
     * @param account
     * @param pwd     获取bsp系统里面的菜单，然后根据返回的数据，进行数据权限控制。
     */
    @RequestMapping(value = "/userlogin", method = RequestMethod.GET)
    public Map<String, Object> login(@RequestParam(value = "account", required = true) String account, @RequestParam(value = "pwd", required = true) String pwd,
                                     @RequestParam(value = "appCode", required = true) String appCode) {
        String password = Md5Utils.getMD5(pwd);
        //JSONObject object = userAuthorityService.userLogin("spjythzs", "e10adc3949ba59abbe56e057f20f883e", "INSPUR-DZZW-YTHZS", false);
        JSONObject object = userAuthorityService.userLogin(account, password, appCode, false);
        System.out.println("resultUser====" + object);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultUser", object);
        return map;
    }

    /**
     * 获取bsp系统里面的菜单，然后根据返回的数据，进行数据权限控制。
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map<String, Object> userlogin() {
        //String password =  Md5Utils.getMD5(pwd);
        JSONObject object = userAuthorityService.userLogin("spjythzs", "e10adc3949ba59abbe56e057f20f883e", "INSPUR-DZZW-YTHZS", false);
        //JSONObject obj = userAuthorityService.userLogin(account,password,"INSPUR-DZZW-BLSP", false);
        System.out.println("resultUser====" + object);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultUser", object);
        return map;
    }

    @RequestMapping(value = "/userLogout", method = RequestMethod.GET)
    public String userLogout(@RequestParam(value = "userId", required = true) String userId) {
        //String password =  Md5Utils.getMD5(pwd);
        JSONObject object = userAuthorityService.userLogout(userId);
        return "/ythzs/index";
    }

    // 调用第三方接口的测试方法
    @RequestMapping(value = "/testUrl", method = RequestMethod.GET)
    public Map<String, Object> testUrl(@RequestParam(value = "sfzh", required = true) String sfzh) {
        JSONObject jsonResult = null;
        Map<String, Object> map = null;
        try {
            map = new HashMap<String, Object>();
            String url = "http://172.20.3.79:9960/gateway/api/1/gjsfzhcx";
            String httpUrl = url + "?sfzh=" + sfzh;
            jsonResult = exeHttpGetMethod(httpUrl);
            map.put("result", jsonResult);
            System.out.println("jsonResult=========" + jsonResult);
        } catch (Exception e) {
            System.out.println("调用远程接口启动作业失败，请重试！！！" + e);
        }
        return map;
    }

    public static JSONObject exeHttpGetMethod(String getUrl) {
        JSONObject jsonObject = new JSONObject();
        URL url;
        try {
            url = new URL(getUrl);
            URLConnection urlConn = url.openConnection();
            HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.setRequestProperty("Accept-Charset", "utf-8");
            httpUrlConn.setRequestProperty("contentType", "utf-8");
            httpUrlConn.setRequestProperty("appKey", "626437688932696064");
            BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream(), "utf-8"));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            jsonObject = JSONObject.parseObject(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }



}
