package com.jikaigg.ui;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.security.cert.X509Certificate;

/**
 * ClassPathXmlApplicationContext     ：可以加载类路径下的配置文件,要求配置文件必须在类路径下，不在的加载不了
 * FileSystemXmlApplicationContext    ：可以加载磁盘任意路径下的配置文件，前提是要有访问权限
 * AnnotationConfigApplicationContext ：用于读取注解创建容器
 *
 * 核心容器的两个接口
 *  ApplicationContext:在构建核心容器是创建对象采取的策略是立即加载的方式，一读取完配置文件，就创建配置文件中配置的对象
 *  BeanFactory：在构建核心容器是创建对象采取的策略是延迟加载的方式，什么时候根据id获取对象，什么时候创建对象。
 */
public class Client {
    /**
     * 获取spring的Ioc核心容器对象，并根据id获取对象
     *
     */
    public static void main(String[] args) {
        /*//第一种加载方式
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao ad = ac.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(ad);*/

        /*// 第二种加载配置文件的方式
        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\jikaigg\\Desktop\\bean.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao ad = ac.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(ad);*/


        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService as = (AccountService) factory.getBean("accountService");
        AccountDao ad = factory.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(ad);

    }
}
