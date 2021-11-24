package com.AuD.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: eureka client(服务提供者). <br>
 * Note:    <br>
 * 1.这里所谓的"服务提供者"或者"服务消费者"仅仅只是个相对概念而已.  <br>
 * - eg. order-server 需要 call stock-server,这里order便是个"服务消费者",stock则是"服务提供者",但是实际上,这二者可能互相调用.    <br>
 * @author AuD/胡钊
 * @ClassName EurekaClientProviderStock9001
 * @date 2021/11/22 18:15
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientProviderStock9001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderStock9001.class,args);
    }

}
