package com.jd.validate.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.ConstraintValidator;
import com.jd.validate.inter.ObjectBean;


public class IsDateValidate implements ConstraintValidator {

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
        String longTerm = (String) bean.getAnnotationKey("longTerm");
        String longTermValue = (String) bean.getAnnotationKeyValue();
        if (longTerm.equals(longTermValue)) {
            return EntityUtils.newValidateResultFalse();
        }
        String dateformat = (String) bean.getAnnotationKey("dateType");
        SimpleDateFormat formatter = new SimpleDateFormat(dateformat);
        //判断日期时间解析是否为不严格的,true为不严格 false
        formatter.setLenient(false);

        try {
            formatter.parse((String) bean.getAnnotationKeyValue());
            return EntityUtils.newValidateResultFalse();
        } catch (ParseException e) {
            return EntityUtils.newValidateResultTrue("日期格式不符合！");
        }
    }

}