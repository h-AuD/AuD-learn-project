package AuD.template.project.core.exception;


import AuD.component.common.server.DefineServerException;

/**
 * Description: 自定义业务场景异常
 *
 * @author AuD/胡钊
 * @ClassName BusinessException
 * @date 2021/3/22 12:43
 * @Version 1.0
 */
public class BusinessException extends DefineServerException {

    public BusinessException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
