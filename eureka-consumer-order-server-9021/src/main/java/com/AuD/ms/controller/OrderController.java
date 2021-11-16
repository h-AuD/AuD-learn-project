package com.AuD.ms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName OrderController
 * @date 2021/11/16 16:15
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {

    /**
     * {@link LoadBalanced}这个注解的作用就是将 RestTemplate 具有eureka client负载均衡功能,即可以通过服务名称来call server.
     * @param builder
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    /**
     * 简单的 RestTemplate,不具备客户端负载均衡功能
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate restTemplateSimple(RestTemplateBuilder builder){
        return builder.build();
    }


    @Autowired
    private RestTemplate restTemplateSimple;

    @Autowired
    private RestTemplate restTemplate;

    private final static String URL = "http://%s%s";

    @GetMapping(value = "/do/general")
    public String handleOrder(){
        // == 字符拼接 "http://localhost:9011/stock/do"
        final String url = String.format(URL, "localhost:9011", "/stock/do");
        String result = restTemplateSimple.getForObject(url, String.class);
        return "下单success & call stock_server result:"+result;
    }


    @GetMapping(value = "/do/using_sn")
    public String handleOrderUsingServerName(){
        // == 字符拼接 "http://eureka-provider-stock-service/stock/do"
        final String url = String.format(URL, "eureka-provider-stock-service", "/stock/do");
        String result = restTemplate.getForObject(url, String.class);
        String errorMsg;
        try {
            // ==== 使用restTemplateSimple通过服务名称来call API会出现错误,因为restTemplateSimple不能通过服务名称来获取IP
            errorMsg = restTemplateSimple.getForObject(url, String.class);
            log.info("restTemplateSimple execute result:{} by server name");
        }catch (Exception e){
            e.printStackTrace();
            log.error("execute restTemplateSimple occur exception,and error info:"+e.getMessage());
        }
        return "下单success & call stock_server result:"+result;
    }

}
