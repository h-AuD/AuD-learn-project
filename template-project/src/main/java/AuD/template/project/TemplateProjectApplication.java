package AuD.template.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@MapperScan("AuD.template.project.mapper")
@ServletComponentScan
public class TemplateProjectApplication {

    /**===================================================================================
     * {@link ServletComponentScan} 注解说明:
     *
     **==================================================================================*/

    public static void main(String[] args) {
        SpringApplication.run(TemplateProjectApplication.class, args);
    }

}
