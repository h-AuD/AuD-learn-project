package AuD.eureka.client.controller;

import AuD.component.common.server.ServerResultHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName AccountController
 * @date 2021/4/25 16:26
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @GetMapping(value = "/demo")
    public ServerResultHandle getBasicInfo(){
        return ServerResultHandle.of(0,"SUCCESS");
    }

}
