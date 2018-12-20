package com.jd.validate.impl;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 属性最大最小值校验
 */
public class ValidateSize extends AbstractConstraintValidator {

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
        boolean isNumber = ObjectUtils.parseBoolean(bean.getAnnotationKey(ValidateConstant.ISNUMBER));
        if (isNumber) {
            Pattern pattern = Pattern.compile("^[0-9]*$");
            String num = (String) bean.getAnnotationKeyValue();
            Matcher isNum = pattern.matcher(num);
            if (!isNum.matches()) {
                return EntityUtils.newValidateResultTrue("不是数字！");
            }
        }
        boolean isChinese = ObjectUtils.parseBoolean(bean.getAnnotationKey(ValidateConstant.ISCHINESE));
        if (isChinese) {
            String str = (String) bean.getAnnotationKeyValue();
            Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]{0,}$");
            Matcher isCHN = pattern.matcher(str);
            if (!isCHN.matches()) {
                return EntityUtils.newValidateResultTrue("不是汉字！");
            }
        }
        long max = ObjectUtils.parseLong(bean.getAnnotationKey(ValidateConstant.MAX));
        long min = ObjectUtils.parseLong(bean.getAnnotationKey(ValidateConstant.MIN));
        Object annotationValue = bean.getAnnotationKeyValue();
        if (annotationValue instanceof String) {
            int annotationSize = String.valueOf(annotationValue).trim().length();
            if (annotationSize < min || annotationSize > max) {
                return EntityUtils.newValidateResultTrue("属性值不在规定长度范围内！");
            }
        }
        if (annotationValue instanceof Integer) {
            if (((Integer) annotationValue).intValue() < min || ((Integer) annotationValue).intValue() > max) {
                return EntityUtils.newValidateResultTrue("属性值不在规定长度范围内！");
            }
        }
        if (annotationValue instanceof Long) {
            if (((Long) annotationValue).longValue() < min || ((Long) annotationValue).longValue() > max) {
                return EntityUtils.newValidateResultTrue("属性值不在规定长度范围内！");
            }
        }
        if (annotationValue instanceof Double) {
            if (((Double) annotationValue).doubleValue() < min || ((Double) annotationValue).doubleValue() > max) {
                return EntityUtils.newValidateResultTrue("属性值不在规定长度范围内！");
            }
        }
        if (annotationValue instanceof List<?>) {
            if (((List<?>) annotationValue).size() < min || ((List<?>) annotationValue).size() > max) {
                return EntityUtils.newValidateResultTrue("属性值不在规定长度范围内！");
            }
        }
        if (annotationValue instanceof String[]) {
            if (((String[]) annotationValue).length < min || ((String[]) annotationValue).length > max) {
                return EntityUtils.newValidateResultTrue("属性值不在规定长度范围内！");
            }
        }
        return EntityUtils.newValidateResultFalse();
    }

}
