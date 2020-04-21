package com.jikaigg.consumer.controller;

import com.jikaigg.consumer.client.UserClient;
import com.jikaigg.consumer.pojo.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
//    @Autowired
//    private RestTemplate restTemplate;

    /*@Autowired
    private DiscoveryClient discoveryClient;*/

/*    @Autowired
    private RibbonLoadBalancerClient client;*/

    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        //根据服务id获取事例
        //List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从事例中取出ip和端口
        //ServiceInstance instance = instances.get(0);
        //负载均衡算法（随机、轮询、哈希）

/*        //根据服务id获取事例,已经实现了负载均衡,默认是轮询
        ServiceInstance instance = client.choose("user-service");

        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        System.out.println(url);*/
//        String url = "http://user-service/user/"+id;
//        return restTemplate.getForObject(url, User.class);
        return userClient.queryById(id);
    }
}
