package com.AuD.ms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 简单的库存扣除API. <br>
 *
 * Note:    <br>
 * 1.this controller 设计不符合规范的,这里仅仅为了方便测试而已.
 *
 * @author AuD/胡钊
 * @ClassName EurekaStockController
 * @date 2021/11/16 15:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/stock")
@Slf4j
public class EurekaStockController implements InitializingBean {

    /**
     * 用于测试eureka客户端负载均衡.可以借助idea的dashboard启动多个this server(仅仅修改下port),serverName也是如此.
     */
    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String serverName;

    /**
     * 设计API响应结果,包含服务名+端口,仅仅为了方便观察结果.
     */
    private String result;

    @GetMapping(value = "/do")
    public String doStock(){
        log.info("================ 库存-1 ==============");
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        result = "库存扣减success === this server from "+serverName+":"+port;
    }
}
