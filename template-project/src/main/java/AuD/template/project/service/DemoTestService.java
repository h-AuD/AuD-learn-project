package AuD.template.project.service;

import AuD.component.common.server.ServerResultHandle;
import AuD.template.project.mapper.UserBasicInfoMapper;
import AuD.template.project.model.entity.UserBasicInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName TemplateService
 * @date 2021/4/16 19:46
 * @Version 1.0
 */
@Slf4j
@Service
public class DemoTestService {

    @Autowired
    private UserBasicInfoMapper userBasicInfoMapper;


    public ServerResultHandle doHandle(){
        List<UserBasicInfo> result = new ArrayList<>();
        userBasicInfoMapper.getAllInfo((resultContext -> {
            DefaultResultContext<UserBasicInfo> defaultResultContext = (DefaultResultContext<UserBasicInfo>) resultContext;
            result.add(defaultResultContext.getResultObject());
            log.info("{}",defaultResultContext.getResultCount());
        }));
        return ServerResultHandle.success().data(result);
    }

    public ServerResultHandle doSqlError(){
        userBasicInfoMapper.errorSqlDML(null);
        return ServerResultHandle.success();
    }

}
