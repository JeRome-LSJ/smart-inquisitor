package com.jd.validate.engine;

/**
 * 校验类返回参数
 * 如果结果TRUE，需要查看ValidateCheckMsg，校验的异常信息
 * 或者特殊处理异常
 * @author PoolInSky
 */
public class ValidateResult {
    private boolean validateCheckResult;
    private String validateCheckMsg;
    private Exception validateCheckError;

    public ValidateResult() {
        super();
    }

    public ValidateResult(boolean validateCheckResult, String validateCheckMsg, Exception validateCheckError) {
        super();
        this.validateCheckResult = validateCheckResult;
        this.validateCheckMsg = validateCheckMsg;
        this.validateCheckError = validateCheckError;
    }

    public boolean getValidateCheckResult() {
        return validateCheckResult;
    }

    public void setValidateCheckResult(boolean validateCheckResult) {
        this.validateCheckResult = validateCheckResult;
    }

    public String getValidateCheckMsg() {
        return validateCheckMsg;
    }

    public void setValidateCheckMsg(String validateCheckMsg) {
        this.validateCheckMsg = validateCheckMsg;
    }

    public Exception getValidateCheckError() {
        return validateCheckError;
    }

    public void setValidateCheckError(Exception validateCheckError) {
        this.validateCheckError = validateCheckError;
    }
}
