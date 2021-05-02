package AuD.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName SingletonEurekaServer
 * @date 2021/4/23 12:19
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer1001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1001.class,args);
    }

}
