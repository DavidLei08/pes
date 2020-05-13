package com.wang.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean 第三步
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /**
         * anon:无需认证就可以访问
         * authc 必须认证才能访问
         * user 必须拥有记住我才能使用
         * perms 拥有对某个资源的权限才能访问
         * role 拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权
        filterMap.put("/","authc");
        filterMap.put("/index","authc");
        filterMap.put("/student","authc");

//        filterMap.put("/user/**","perms[admin]");
        filterMap.put("/static/**","anon");

        filterMap.put("/css/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/fonts/**","anon");
        filterMap.put("/font/**","anon");
        filterMap.put("/images/**","anon");
        filterMap.put("/lib/**","anon");
        filterMap.put("/logout","logout");

        bean.setFilterChainDefinitionMap(filterMap);

        //登录拦截
        bean.setLoginUrl("/toLogin");

        return bean;
    }

    //DefaultWebSecurityManager ->第二步
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联 UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm 对象，需要自定义类 -> 第一步
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return  new UserRealm();
    }

    //整合shiroDialect
    @Bean
    public ShiroDialect getShiroDialect(){
        return  new ShiroDialect();
    }
}
