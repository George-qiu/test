package com.kewei.plcsys.config;

//
//import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DruidMonitorConfig {
//
//    /**
//     * 配置Druid的监控统计功能
//     * 统计URL访问的数据，以及SQL执行的数据
//     * 在StatViewServlet配置类中的ps、poolingCount、connectionProperty三个属性是固定不变的
//     */
//    @Bean
//    public ServletRegistrationBean<?> druidServlet() {
//        ServletRegistrationBean<?> servletRegistrationBean = new ServletRegistrationBean<>(
//                new DruidStatProperties.StatViewServlet(), "/druid/*");
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "password");
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        //ps:统计用信息的基础名称，_sql是表示sql监控
//        servletRegistrationBean.addInitParameter("principalSessionName", "custom_session_name");
//        //监控单个url调用参数的配置,针对一些参数特殊的url配置，可在此配置
//        servletRegistrationBean.addInitParameter("profileEnable", "true");
//        return servletRegistrationBean;
//    }
//    /**
//     * 配置Druid的监控统计功能
//     * 统计URL访问的数据，以及SQL执行的数据
//     * 在WebStatFilter配置类中的exclusions属性可以配置哪些情况下不进行拦截，比如静态资源
//     */
//    @Bean
//    public FilterRegistrationBean<?> druidFilter() {
//        FilterRegistrationBean<?> filterRegistrationBean = new FilterRegistrationBean<>(
//                new DruidStatProperties.WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions",
//                "*.js,*.css,*.html,*.jpg,*.png,*.gif,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//}
