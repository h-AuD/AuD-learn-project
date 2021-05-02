package AuD.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName AccountEurekaClient
 * @date 2021/4/25 16:23
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientConsumer1002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumer1002.class,args);
    }

}
