package com.AuD.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description: eureka 服务注册中心
 *
 * @author AuD/胡钊
 * @ClassName EurekaRegisterServer9091
 * @date 2021/11/16 15:28
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaRegisterServer9091 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegisterServer9091.class,args);
    }

}
