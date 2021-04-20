package AuD.template.project.controller;


import AuD.component.common.server.ServerResultHandle;
import AuD.template.project.core.constant.ServerReturnCode;
import AuD.template.project.core.conf.PropertyConfig;
import AuD.template.project.service.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Description: TEST 前端控制器
 * - 仅仅用于测试function。eg.使用postman测试接口,可以使用该controller,不要用这个Controller干其他的事
 *
 * @author AuD/胡钊
 * @ClassName TestController
 * @date 2021/1/21 10:57
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/template")
@Slf4j
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private PropertyConfig propertyConfig;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ServerResultHandle testGet(){
        log.info("{},{},{}",propertyConfig.getName(),propertyConfig.getAge(),propertyConfig.getList());
        return ServerResultHandle.of(ServerReturnCode.PARAMETER_ERROR.getCode(), ServerReturnCode.PARAMETER_ERROR.getMessage());
    }

    @GetMapping(value = "/error/sql")
    public ServerResultHandle testExecuteErrorSql(){
        return templateService.doSqlError();
    }




}
