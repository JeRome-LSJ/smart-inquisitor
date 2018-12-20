package com.jd.validate.impl;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;


public class IsNotNullValidate extends AbstractConstraintValidator {

    @Override
    public ValidateResult exec(ObjectBean bean) {
        if (ObjectUtils.NotNull(bean.getAnnotationKeyValue())) {
            return EntityUtils.newValidateResultFalse();
        } else {
            return EntityUtils.newValidateResultTrue("校验值为空！");
        }
    }

}
