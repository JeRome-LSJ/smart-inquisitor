package com.jd.validate.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;


public class IsZipValidate extends AbstractConstraintValidator {

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
        //邮政编码
        Pattern pattern = Pattern.compile("^[0-9][0-9]{5}$");
        String zip = (String) bean.getAnnotationKeyValue();
        Matcher isZip = pattern.matcher(zip);
        if (!isZip.matches()) {
            return EntityUtils.newValidateResultTrue("邮政编码格式不符！");
        }
        return EntityUtils.newValidateResultFalse();
    }

}