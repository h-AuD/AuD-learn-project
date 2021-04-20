package AuD.template.project.mapper;


import AuD.template.project.model.entity.UserBasicInfo;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Repository;


/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName UserMapper
 * @date 2021/4/13 17:43
 * @Version 1.0
 */
@Repository
public interface UserBasicInfoMapper {

    public void getAllInfo(ResultHandler<UserBasicInfo> resultHandler);

    public int errorSqlDML(UserBasicInfo userBasicInfo);

}
