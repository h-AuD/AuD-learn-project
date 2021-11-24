package com.AuD.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName EurekaClientConsumerOrder9002
 * @date 2021/11/22 18:28
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientConsumerOrder9002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumerOrder9002.class,args);
    }

}
