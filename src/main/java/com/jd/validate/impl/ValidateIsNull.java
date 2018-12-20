package com.jd.validate.impl;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;

public class ValidateIsNull extends AbstractConstraintValidator {

    @Override
    public ValidateResult exec(ObjectBean bean) {
        if (ObjectUtils.isNotNull(bean.getAnnotationKeyValue())) {
            return EntityUtils.newValidateResultTrue("校验值不为空！");
        } else {
            return EntityUtils.newValidateResultFalse();
        }
    }

}
