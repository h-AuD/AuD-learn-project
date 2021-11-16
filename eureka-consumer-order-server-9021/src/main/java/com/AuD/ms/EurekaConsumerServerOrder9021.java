package com.AuD.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName EurekaConsumerServerOrder9021
 * @date 2021/11/16 16:14
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerServerOrder9021 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerServerOrder9021.class,args);
    }

}
