package com.AuD.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: eureka client(服务提供者). <br>
 * Note:    <br>
 * 1.这里所谓的"服务提供者"或者"服务消费者"仅仅只是个相对概念而已.  <br>
 * - eg. order-server 需要 call stock-server,这里order便是个"服务消费者",stock则是"服务提供者",但是实际上,这二者可能互相调用.    <br>
 *
 * @author AuD/胡钊
 * @ClassName EurekaProviderServerStock9011
 * @date 2021/11/16 15:42
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProviderServerStock9011 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderServerStock9011.class,args);
    }

}
