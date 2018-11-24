package com.jd.validate.impl;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.ConstraintValidator;
import com.jd.validate.inter.ObjectBean;

public class ValidateEnumKey implements ConstraintValidator {

    public ValidateResult exec(ObjectBean bean) {
        boolean isNullValid = ObjectUtils.parseBoolean(bean.getAnnotationKey(ValidateConstant.ISNULLVALID));
        if (isNullValid) {
            if (ObjectUtils.isNull(bean.getAnnotationKeyValue())) {
                return EntityUtils.newValidateResultTrue("属性值为空异常！");
            }
        } else {
            if (ObjectUtils.isNull(bean.getAnnotationKeyValue())) {
                return EntityUtils.newValidateResultFalse();
            }
        }
        //Object annotationKey = bean.getAnnotationValue();
        Object annotationKey = bean.getAnnotationKey("valueRange");
        if (annotationKey instanceof String[]) {
            String[] listKeys = (String[]) annotationKey;
            for (String key : listKeys) {
                if (key.equals(String.valueOf(bean.getAnnotationKeyValue()))) {
                    return EntityUtils.newValidateResultFalse();
                } else {
                    continue;
                }
            }
            return EntityUtils.newValidateResultTrue("对象属性没有在规定取值范围中！");
        }
        return EntityUtils.newValidateResultTrue("校验注解传入的属性异常！");
    }
}
