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

    /**
     * 一个简单的RPC服务call,即通过IP+port. <br>
     * 缺陷:  <br>
     * 1.假如stock server有多个节点,那么通过IP call 显示的很麻烦: 需要维护一个IP列表 & IP发送变化,相应的代码需要做调整,耦合性比较强. <br>
     * - 可以通过配置Nginx来解决上述问题. <br>
     * - 但是对于同一个系统而言(某一个系统更具业务差分多个model),配置Nginx即麻烦又显得没有必要. <br>
     * - eg.如果服务比较多(成百上千),nginx.config文件会很庞大,这样就无形的增加维护成本.
     * @return
     */
    @GetMapping(value = "/do/general")
    public String handleOrder(){
        // == 字符拼接 "http://localhost:9011/stock/do"
        final String url = String.format(URL, "localhost:9011", "/stock/do");
        String result = restTemplateSimple.getForObject(url, String.class);
        return "下单success & call stock_server result:"+result;
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/do/using_sn")
    public String handleOrderUsingServerName(){
        // == 字符拼接 "http://eureka-provider-stock-service/stock/do"
        final String url = String.format(URL, "eureka-provider-stock-service", "/stock/do");
        String result = restTemplate.getForObject(url, String.class);
        String errorMsg = "";
        try {
            // ==== 使用restTemplateSimple通过服务名称来call API会出现错误,因为restTemplateSimple不能通过服务名称来获取IP
            errorMsg = restTemplateSimple.getForObject(url, String.class);
            log.info("restTemplateSimple execute result:{} by server name",errorMsg);
        }catch (Exception e){
            e.printStackTrace();
            log.error("execute restTemplateSimple occur exception,and error info:"+e.getMessage());
        }
        return "下单success & call stock_server result:"+result;
    }

}
