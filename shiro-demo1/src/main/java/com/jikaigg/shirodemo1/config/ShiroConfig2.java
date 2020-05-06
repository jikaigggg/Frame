package com.jikaigg.shirodemo1.config;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 */
@Configuration
public class ShiroConfig2 {


    /**
     *  Shiro自带的过滤器，可以在这里配置拦截页面
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Autowired DefaultWebSecurityManager securityManager){

        // 1. 初始化一个ShiroFilter工程类
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 2. 我们知道Shiro是通过SecurityManager来管理整个认证和授权流程的，这个SecurityManager可以在下面初始化
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 3. 上面我们讲过，有的页面不需登录任何人可以直接访问，有的需要登录才能访问，有的不仅要登录还需要相关权限才能访问
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 4. Shiro过滤器常用的有如下几种
        // 4.1. anon 任何人都能访问，如登录页面
        filterMap.put("/api/user/login", "anon");
        // 4.2. authc 需要登录才能访问，如系统内的全体通知页面
        filterMap.put("/api/user/notics", "authc");
        // 4.3. roles 需要相应的角色才能访问
        filterMap.put("/api/user/getUser", "roles[admin]");
        // 5. 让ShiroFilter按这个规则拦截
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        // 6. 用户没登录被拦截后，当然需要调转到登录页了，这里配置登录页
        shiroFilterFactoryBean.setLoginUrl("/api/user/login");
        return shiroFilterFactoryBean;
    }

    /**
     * SecurityManager管理认证、授权整个流程
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Autowired UserRealm userRealm){

        // 7. 新建一个SecurityManager供ShiroFilterFactoryBean使用
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 8. SecurityManager既然管理认证等信息，那他就需要一个类来帮他查数据库吧。这就是Realm类
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 自定义Realm，当SecurityBean需要来查询相关权限信息时，需要有Realm代劳
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    /**
     * 为了方便观看，我将UserRealm类的实现写在这里了
     */
    class UserRealm extends AuthorizingRealm {

        // 9. 前面被authc拦截后，需要认证，SecurityBean会调用这里进行认证
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            System.out.println("执行认证逻辑");
            UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

            // 9.1. 为了方便演示，我这里写死了用户admin-name密码admin-pwd才能登录
            if (token.getUsername() == null || !token.getUsername().equals("admin-name")){
                return null;
            }

            return new SimpleAuthenticationInfo("", "admin-pwd", "");
        }

        // 10. 前面被roles拦截后，需要授权才能登录，SecurityManager需要调用这里进行权限查询
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            System.out.println("执行授权逻辑");

            // 10.1. 为了方便演示，这里直接写死返回了admin角色，所有能登录的角色都是admin了
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("admin");
            return info;
        }
    }
}

