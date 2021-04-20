package AuD.template.project.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName User
 * @date 2021/4/13 17:42
 * @Version 1.0
 */
@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private LocalDateTime ctime;

}
