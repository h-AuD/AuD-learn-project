package com.AuD.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Description:
 *
 * Note:    <br>
 * 1.this controller 设计不符合规范的,这里仅仅为了方便测试而已.
 *
 * @author AuD/胡钊
 * @ClassName EurekaOrderController
 * @date 2021/11/22 18:29
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/order")
public class EurekaOrderController {

    /**
     * 简单的{@link RestTemplate},用于测试HTTP调用,eg.{@link RestTemplate#getForObject(java.net.URI, java.lang.Class)}
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate simpleRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    /**
     * 具有负载均衡功能的http_client ===> 负载均衡参见{@link LoadBalanced}
     * @param builder
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        // ==== 设置连接超时时间为2s,可以用于测试 "熔断 & 降级"
        return builder.setConnectTimeout(Duration.ofSeconds(2)).build();
    }

    /*==================================== 分割线 ============================================*/


    @Autowired
    private RestTemplate simpleRestTemplate;


    @Autowired
    private RestTemplate restTemplate;

    /** 服务发现客户端 */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 测试服务调用,使用simpleRestTemplate. <br>
     * call 第三方 API,通常使用"RestTemplate",即IP:port/uri ==== 一般需要try...catch...(不能保证API一定是没有问题的).   <br>
     * Note:    <br>
     * 1.服务A有N台机器(也就说说有N个IP),那么调用服务A需要配置N个Ip,以及设置IP选择算法等等.=== 岂不是很麻烦,索引需要微服务.  <br>
     * - 貌似不对吧,可以通过Nginx配置域名来实现,直接通过域名来调用API,微信平台提供API. <br>
     * --> 是的,Nginx的确是可以解决上述尴尬问题,但是这样的话,如果服务比较多,配置文件(nginx.config)难以维护.
     *
     * @return
     */
    @GetMapping(value = "/do_no_loadBalanced")
    public String orderHandleByNoLoadBalanced(){
        String result = "";
        try {
            result = simpleRestTemplate.getForObject("http://localhost:9001/stock/do", String.class);
        }catch (Exception e){
            log.error("call server occur exception,error_info:{}",e.getMessage());
            result = "call_API_fail";
        }
        return result;
    }

    /**
     * 测试服务调用,使用具有负载均衡的restTemplate.通过服务名来调用API,eg:http://server_name/path   <br>
     * @return
     */
    @GetMapping(value = "/do_loadBalanced")
    public String orderHandleByLoadBalanced(){
        String result = "";
        try {
            result = restTemplate.getForObject("http://eureka-stock-server/stock/do", String.class);
        }catch (Exception e){
            log.error("call server occur exception,error_info:{}",e.getMessage());
            result = "call_API_fail";
        }
        return result;
    }


}
