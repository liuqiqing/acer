package com.inspur.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author BEAN_BAG
 * @email 1104425440@qq.com
 * @data 2019年1月26日
 * @description mybatis多数据源配置
 *
 */
@Configuration
@MapperScan(basePackages = "com.inspur.dao.pdjh",
            sqlSessionTemplateRef  = "pdjh_sqlSessionTemplate")
public class MyBatisDataSource_pdjh {

    @Autowired
    @Qualifier("pdjh_dataSource")
    private DataSource pdjhDataSource;


    @Bean(name = "pdjh_sqlSessionFactory")
    public SqlSessionFactory dvDbGdpSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(pdjhDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/pdjh/PdjhMapper.xml"));
        //整合mybatis的分页插件pageHelper
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "oracle");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","pageNum=pageNumKey;pageSize=pageSizeKey;");
        interceptor.setProperties(properties);
        bean.setPlugins(new Interceptor[] {interceptor});

        return bean.getObject();
    }

    @Bean(name = "pdjh_transactionManager")
    public DataSourceTransactionManager dvDbGdpTransactionManager() {
        return new DataSourceTransactionManager(pdjhDataSource);
    }

    @Bean(name = "pdjh_sqlSessionTemplate")
    public SqlSessionTemplate sxglSqlSessionTemplate(@Qualifier("pdjh_sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
