package com.AuD.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description: eureka 服务注册中心(port:8081),this使用的是Netflix开源的组件(eureka). <br>
 * Note:    <br>
 * 1.2018年,Netflix(eureka)宣布停止维护.关于这点可参考GitHub(官宣):https://github.com/Netflix/eureka/wiki,如下摘自GitHub:  <br>
 * Eureka 2.0 (Discontinued) -- eureka2.0已停止维护  <br>
 * The existing open source work on eureka 2.0 is discontinued. <br>
 * The code base and artifacts that were released as part of the existing repository of work on the 2.x branch is considered use at your own risk.  <br>
 *
 * Eureka 1.x is a core part of Netflix's service discovery system and is still an active project.  <br>
 *
 * 2.spring cloud版本说明(版本分水岭:Hoxton & 2020.0.0):  <br>
 * - 自从eureka停止维护后,spring cloud便开始寻找/自研相关替代品.   <br>
 * - Hoxton版本之后的版本命名发生了变化,变成"2020.0.0"(即发布时间未参考点),并且2020.x(自2020.0.0)移除了Netflix大量组件,目前仅保留eureka.    <br>
 * - 并且2020.x版本依赖spring boot 2.4.x或2.5.x,而Hoxton支持2.2.x和2.3.x(高于此版本的applicatio运行报错).
 * --> 综上:在学习/研究spring cloud过程中,请分别以"Hoxton.SR12"和 "2020.0.4"(目前/2021年11月22日最新稳定版)2个版本为基础开发.  <br>
 *
 * @author AuD/胡钊
 * @ClassName EurekaServerRegister8081
 * @date 2021/11/22 17:25
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerRegister8081 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaServerRegister8081.class,args);
    }


}
