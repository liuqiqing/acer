package com.inspur.utils;

import com.inspur.service.UserAuthorityService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OderToMemberTest {



    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config/service-consumerContext.xml");

        UserAuthorityService userAuthorityService = applicationContext.getBean(UserAuthorityService.class);
        String pwd = Md5Utils.getMD5("langchao888@");
        //jnszwfwzx
        //dad1f2726a542b7c1548b1d42c7242c8
        //blspadmin
        String resultUser = userAuthorityService.userLogin("blspadmin","e10adc3949ba59abbe56e057f20f883e","INSPUR-DZZW-BLSP",false).toString();
        System.out.println("调用服务后的返回结果"+resultUser);
    }
}
