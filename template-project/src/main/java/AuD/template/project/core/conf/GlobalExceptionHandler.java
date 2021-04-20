package AuD.template.project.core.conf;

import AuD.template.project.core.exception.BusinessException;
import com.AuD.common.functions.server.ServerResultHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.LocalDateTime;


/**
 * Description: 全局异常处理 === {@link RestControllerAdvice}
 *
 * @author AuD/胡钊
 * @ClassName GlobalExceptionHandler
 * @date 2021/4/16 10:13
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private String format = "{}:异常信息:{}";



    /**
     * 处理自定义异常
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ServerResultHandle handleDefineException(BusinessException e){
        log.error(format,LocalDateTime.now(),e.getMessage());
        return ServerResultHandle.defineError(e);
    }

    /**
     * 此处可以不需要对SQL异常处理  === 可以使用AOP处理,比如处理Mapper中的
     * 因为SQL异常一般发生在DAO层(即Mapper),其实不需要给前端返回,
     * 如果真的想要告诉caller发生错误,返回一个500就行了。
     *
     * @param e
     * @return
     */
    //@ExceptionHandler(SQLException.class)
    public ServerResultHandle handleSqlException(SQLException e){
        log.error(format,LocalDateTime.now(),e.getMessage());
        return ServerResultHandle.internalError();
    }

    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ServerResultHandle handleException(Exception e){
        if(!(e instanceof BadSqlGrammarException)){
            // sql 异常不输出日志,因为已经交给Aop处理
            log.error(format,LocalDateTime.now(),e.getMessage());
        }
        return ServerResultHandle.internalError();
    }



}
