package com.jd.validate.impl;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.ConstraintValidator;
import com.jd.validate.inter.ObjectBean;


public class IsNotNullValidate implements ConstraintValidator {

    public ValidateResult exec(ObjectBean bean) {
        if (ObjectUtils.NotNull(bean.getAnnotationKeyValue())) {
            return EntityUtils.newValidateResultFalse();
        } else {
            return EntityUtils.newValidateResultTrue("校验值为空！");
        }
    }

}
