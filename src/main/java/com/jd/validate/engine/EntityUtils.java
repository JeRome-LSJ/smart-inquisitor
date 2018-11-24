package com.jd.validate.engine;

import java.util.HashMap;

public class EntityUtils {

    public static HashMap<String, Object> newHashMap() {
        return new HashMap<String, Object>();
    }

    public static ObjectParameter newObjectParameter(Object bean) {
        return new ObjectParameter(bean);
    }

    public static ValidateResult newValidateResult() {
        return new ValidateResult();
    }

    public static ValidateResult newValidateResult(boolean validateCheckResult, String validateCheckMsg) {
        return new ValidateResult(validateCheckResult, validateCheckMsg, null);
    }

    public static ValidateResult newValidateResult(boolean validateCheckResult, String validateCheckMsg, Exception validateCheckError) {
        return new ValidateResult(validateCheckResult, validateCheckMsg, validateCheckError);
    }

    public static ValidateResult newValidateResultTrue() {
        return new ValidateResult(true, "对象校验不通过，请处理！", null);
    }

    public static ValidateResult newValidateResultFalse() {
        return new ValidateResult(false, null, null);
    }

    public static ValidateResult newValidateResultTrue(String validateCheckMsg) {
        return new ValidateResult(true, validateCheckMsg, null);
    }

}
