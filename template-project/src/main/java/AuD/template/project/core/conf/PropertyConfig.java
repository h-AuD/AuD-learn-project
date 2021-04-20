package AuD.template.project.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName PropertyConfig
 * @date 2021/4/14 12:32
 * @Version 1.0
 */
@Component
@Data
public class PropertyConfig {
    @Value("${spring.config.value.name}")
    private String name;
    @Value("${spring.config.value.age}")
    private Integer age;
    // 集合配置
    @Value("#{'${spring.config.value.list}'.split(',')}")
    private List<String> list;

}
