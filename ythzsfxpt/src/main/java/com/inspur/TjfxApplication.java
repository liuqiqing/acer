package com.inspur;


import com.github.pagehelper.PageHelper;
import com.inspur.service.PdjhService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;


@Configuration
@MapperScan("com.inspur.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:config/service-consumerContext.xml"})
//@EnableScheduling   // 2.开启定时任务
public class TjfxApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TjfxApplication.class, args);
    }

    /**
     * 工程打成war需要继承SpringBootServletInitializer，重写configure方法
     *
     * @date 2018年12月7日
     * @author zxp
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TjfxApplication.class);
    }
    // 分页插件配置
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper=new PageHelper();
        Properties properties=new Properties();
        properties.setProperty("offsetPageNum","true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }




}
