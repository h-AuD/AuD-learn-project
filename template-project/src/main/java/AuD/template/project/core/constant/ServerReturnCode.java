package AuD.template.project.core.constant;

/**
 * Description: 返回码列表
 *
 * @author AuD/胡钊
 * @ClassName ServerReturnCode
 * @date 2021/1/19 11:09
 * @Version 1.0
 */
public enum ServerReturnCode {

    /**
     * 2030 === 参数错误
     * ---> 属于统称code,非法参数也可以使用该code
     */
    PARAMETER_ERROR(2030,"parameter is error,please check param");

    private Integer code;
    private String message;

    ServerReturnCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    /* getter */
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
