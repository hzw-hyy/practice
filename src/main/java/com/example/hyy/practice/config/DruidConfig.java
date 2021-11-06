package com.example.hyy.practice.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yggc
 */
@Configuration
public class DruidConfig {

    /**
     * 配置druid的监控
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }


    /**
     * 1、配置一个管理后台的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>(16);
        //控制台管理员用户
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        //IP白名单(允许谁登录)
        initParams.put("allow", "");
        bean.setInitParameters(initParams);
        return bean;
    }


    /**
     * 2、配置一个监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>(16);
        //忽略拦截规则(不拦截谁)
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        //过滤规则(拦截所有请求)
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}