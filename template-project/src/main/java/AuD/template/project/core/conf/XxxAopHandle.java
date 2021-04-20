package AuD.template.project.core.conf;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 *
 * @author AuD/胡钊
 * @ClassName SqlExceptionHandle
 * @date 2021/4/16 19:25
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class XxxAopHandle {

    @Pointcut("")
    public void pointCut(){}

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        //
        final String name = joinPoint.getSignature().toLongString();
        final List<Object> asList = Arrays.asList(joinPoint.getArgs());
        log.error("方法:{},参数:{},发生错误,信息 ===>{}",name,asList,e.getMessage());
    }
}
