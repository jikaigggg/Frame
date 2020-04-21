package com.jikaigg.service.impl;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户业务层实现类
 * 曾经XML的配置：<bean id="accountService" class="com.jikaigg.service.impl.AccountServiceImpl"></bean>
 * <p>
 * 用于创建对象的注解
 * 他们的作用就和在XML中编写一个bean标签实现的功能是一样的
 *
 * @Component 作用：用于把当前类对象存入spring容器
 * 属性：value，用于指定bean的id；当不写是默认值是当前类名且首字母改小写
 * @Controller ：一般用于表现层
 * @Service ：一般用于业务层
 * @Repository ：一般用于持久层
 * =====以上三个注解他们的作用和属性与Component是一摸一样，他们三个是spring框架为我们提供明确的三层使用的注解，使三层对象更加清晰=====
 * <p>
 * 用于注入数据的注解
 * 他们的作用就和在XML中配置文件中的bean标签中的property标签的作用是一样的
 * @Autowired 作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 * 如果IOC容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
 * 位置：可以是成员，也可以是方法
 * @Qualifier 作用：在按照类型注入基础上上在名称注入，给类成员注入时不能单独使用，但是在给方法参数注入时可以
 * 属性：value用于指定注入bean的id
 * 位置：不能独立使用，需要和@Autowired组合使用
 * @Resource 作用：直接按照bean的id注入，可以独立使用
 * 属性：
 * name用于指定bean的id
 * =====以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用以上注解注入=====
 * =====另外，集合类型的注入只能荣国XML的方式来实现=====
 * @Value 作用：用于注入基本类型和String类型的数据
 * 属性：value用于指定数据的值，可以使用spring中的spEL（也就是spring的EL表达式）
 * spEL的写法：${表达式}
 * <p>
 * 用于改变作用范围的注解
 * 他们的作用就和在bean标签中使用scope标签属性是一样的
 * @Scope 作用：用于指定bean的作用范围
 * 属性：value指定范围的取值，常用取值：singleton(默认),prototype
 * <p>
 * <p>
 * 和生命周期相关的注解
 * 他们的作用就和在bean标签中使用init-method和destory-method标签的作用是一样的
 * @PreDestory 作用：用于指定销毁方法
 * @PostConsruct 作用：用于指定初始化方法
 */
@Service
public class AccountServiceImpl implements AccountService {
    /*    @Autowired
        @Qualifier("accountDaoImpl2")*/
    @Resource(name = "accountDaoImpl2")
    private AccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("chushihua");
    }

    @PreDestroy
    public void destory() {
        System.out.println("destory");
    }
}
