package com.jd.validate.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;


public class IsEmailValidate extends AbstractConstraintValidator {

    @Override
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
        //Email
        Pattern pattern = Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        String email = (String) bean.getAnnotationKeyValue();
        Matcher isEmail = pattern.matcher(email);
        if (!isEmail.matches()) {
            return EntityUtils.newValidateResultTrue("邮箱格式不符！");
        }
        return EntityUtils.newValidateResultFalse();
    }

}