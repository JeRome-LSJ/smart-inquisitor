package com.jd.validate.engine;

/**
 * 校验类返回参数
 * 如果结果TRUE，需要查看ValidateCheckMsg，校验的异常信息
 * 或者特殊处理异常
 */
public class ValidateResult {
    boolean ValidateCheckResult;
    String ValidateCheckMsg;
    Exception ValidateCheckError;

    public ValidateResult() {
        super();
    }

    public ValidateResult(boolean validateCheckResult, String validateCheckMsg, Exception validateCheckError) {
        super();
        ValidateCheckResult = validateCheckResult;
        ValidateCheckMsg = validateCheckMsg;
        ValidateCheckError = validateCheckError;
    }

    public boolean getValidateCheckResult() {
        return ValidateCheckResult;
    }

    public void setValidateCheckResult(boolean validateCheckResult) {
        ValidateCheckResult = validateCheckResult;
    }

    public String getValidateCheckMsg() {
        return ValidateCheckMsg;
    }

    public void setValidateCheckMsg(String validateCheckMsg) {
        ValidateCheckMsg = validateCheckMsg;
    }

    public Exception getValidateCheckError() {
        return ValidateCheckError;
    }

    public void setValidateCheckError(Exception validateCheckError) {
        ValidateCheckError = validateCheckError;
    }
}
