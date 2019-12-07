package com.inspur.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

	@Bean(name = "dv_db_gdp_dataSource")
    // @Qualifier("xxx")指定注入的Bean的名字。
    @Qualifier("dv_db_gdp_dataSource")
    // 对于每一个DataSource，我们都必须通过@ConfigurationProperties(prefix = "xxx")指定配置项的前缀
        @ConfigurationProperties(prefix="spring.datasource.dv-db-gdp")
    @Primary
    public DataSource dvDbGdpDataSource() {
        System.out.println("dv_db_gdp db built");
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "dv_db_gop_dataSource")
	@Qualifier("dv_db_gop_dataSource")
    @ConfigurationProperties(prefix ="spring.datasource.dv-db-gop")
    public DataSource secondDataSource() {
		System.out.println("gop db built");
        return DataSourceBuilder.create().build();
    }
    
	//一网通办连接 172.20.0.70
    @Bean(name = "ywtb_dataSource")
    @Qualifier("ywtb_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.ywtb")
    public DataSource ywtbDataSource() {
        System.out.println("ywtb db built");
        return DataSourceBuilder.create().build();
    }
    
    //事项管理库连接 172.20.0.5
    @Bean(name = "sxgl_dataSource")
    @Qualifier("sxgl_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.sxgl")
    public DataSource sxglDataSource() {
        System.out.println("sxgl db built");
        return DataSourceBuilder.create().build();
    }
    
    //审批用户数据库连接 172.20.0.17
    @Bean(name = "spyh_dataSource")
    @Qualifier("spyh_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.spyh")
    public DataSource spyhDataSource() {
        System.out.println("spyh db built");
        return DataSourceBuilder.create().build();
    }
    
    //电子监察数据库连接 172.20.0.4
    @Bean(name = "dzjc_dataSource")
    @Qualifier("dzjc_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.dzjc")
    public DataSource dzjcDataSource() {
        System.out.println("dzjc db built");
        return DataSourceBuilder.create().build();
    }
    
    //电子证照172.20.0.10
    @Bean(name = "dzzz_dataSource")
    @Qualifier("dzzz_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.dzzz")
    public DataSource dzzzDataSource() {
        System.out.println("dzzz db built");
        return DataSourceBuilder.create().build();
    }

    //并联审批 172.20.1.21
    @Bean(name = "blsp_dataSource")
    @Qualifier("blsp_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.blsp")
    public DataSource blspDataSource() {
        System.out.println("blsp db built");
        return DataSourceBuilder.create().build();
    }

    //排队叫号 172.20.0.19
    @Bean(name = "pdjh_dataSource")
    @Qualifier("pdjh_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.pdjh")
    public DataSource pdjhDataSource() {
        System.out.println("pdjh db built");
        return DataSourceBuilder.create().build();
    }
    //一窗受理
    @Bean(name = "tysl_dataSource")
    @Qualifier("tysl_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.tysl")
    public DataSource tyslDataSource() {
        System.out.println("tysl db built");
        return DataSourceBuilder.create().build();
    }

    // 短信评价
    @Bean(name = "dtgl_dataSource")
    @Qualifier("dtgl_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.dtgl")
    public DataSource dtglDataSource() {
        System.out.println("dtgl db built");
        return DataSourceBuilder.create().build();
    }

    // 省一窗库
    @Bean(name = "syck_dataSource")
    @Qualifier("syck_dataSource")
    @ConfigurationProperties(prefix="spring.datasource.syck")
    public DataSource syckDataSource() {
        System.out.println("syck db built");
        return DataSourceBuilder.create().build();
    }


    
    @Bean(name = "dv_db_gdp_jdbcTemplate")
    @Primary
	public JdbcTemplate dvDbGdpjdbcTemplate(@Qualifier("dv_db_gdp_dataSource") DataSource dataSource) {
        System.out.println("dv_db_gdp_dataSource======");
		return new JdbcTemplate(dataSource);
	}
    
    @Bean(name = "dv_db_gop_jdbcTemplate")
    public JdbcTemplate dv_db_gop_jdbcTemplate(@Qualifier("dv_db_gop_dataSource") DataSource dataSource) {
        System.out.println("dv_db_gop_dataSource======");
    	return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "ywtb_jdbcTemplate")
	public JdbcTemplate ywtbJdbcTemplate(@Qualifier("ywtb_dataSource") DataSource dataSource) {
        System.out.println("ywtb_dataSource======");
		return new JdbcTemplate(dataSource);
	}
    
    @Bean(name = "sxgl_jdbcTemplate")
	public JdbcTemplate sxglJdbcTemplate(@Qualifier("sxgl_dataSource") DataSource dataSource) {
        System.out.println("sxgl_dataSource======");
		return new JdbcTemplate(dataSource);
	}
    
    @Bean(name = "spyh_jdbcTemplate")
	public JdbcTemplate spyhJdbcTemplate(@Qualifier("spyh_dataSource") DataSource dataSource) {
        System.out.println("spyh_dataSource======");
		return new JdbcTemplate(dataSource);
	}
    
    @Bean(name = "dzjc_jdbcTemplate")
	public JdbcTemplate dzjcJdbcTemplate(@Qualifier("dzjc_dataSource") DataSource dataSource) {
        System.out.println("dzjc_dataSource======");
		return new JdbcTemplate(dataSource);
	}
    

    @Bean(name = "dzzz_jdbcTemplate")
    public JdbcTemplate dzzzJdbcTemplate(@Qualifier("dzzz_dataSource") DataSource dataSource) {
        System.out.println("dzzz_dataSource======");
        return new JdbcTemplate(dataSource);
    }
    //并联审批
    @Bean(name = "blsp_jdbcTemplate")
    public JdbcTemplate blspJdbcTemplate(@Qualifier("blsp_dataSource") DataSource dataSource) {
        System.out.println("blsp_dataSource======");
        return new JdbcTemplate(dataSource);
    }

    //排队叫号
    @Bean(name = "pdjh_jdbcTemplate")
    public JdbcTemplate pdjhJdbcTemplate(@Qualifier("pdjh_dataSource") DataSource dataSource) {
        System.out.println("pdjh_dataSource======");
        return new JdbcTemplate(dataSource);
    }

    //一窗受理
    @Bean(name = "tysl_jdbcTemplate")
    public JdbcTemplate tyslJdbcTemplate(@Qualifier("tysl_dataSource") DataSource dataSource) {
        System.out.println("tysl_dataSource======");
        return new JdbcTemplate(dataSource);
    }

    // 短信评价库
    @Bean(name = "dtgl_jdbcTemplate")
    public JdbcTemplate dtglJdbcTemplate(@Qualifier("dtgl_dataSource") DataSource dataSource) {
        System.out.println("dtgl_dataSource======");
        return new JdbcTemplate(dataSource);
    }
    // 省一窗库
    @Bean(name = "syck_jdbcTemplate")
    public JdbcTemplate syckJdbcTemplate(@Qualifier("syck_dataSource") DataSource dataSource) {
        System.out.println("syck_dataSource======");
        return new JdbcTemplate(dataSource);
    }
    
}
