package com.jd.validate.impl;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;

/**
 * 如果注解的属性值不为空为特定值，则注解属性的所有值不能为空
 * 例如：id值如果不为空为特定值，则name、age、sex的值都不能为空
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 *
 * @RealtionNull(specificValue={"1","2"},associationField={"name","age","sex"}) String id
 */
public class ValidateRealtionNotNull extends AbstractConstraintValidator {

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
        Object annotationKey = bean.getAnnotationKey("specificValue");
        if (annotationKey instanceof String[]) {
            String[] listKeys = (String[]) annotationKey;
            for (String key : listKeys) {
                if (key.equals(String.valueOf(bean.getAnnotationKeyValue()))) {
                    String[] annKeys = ObjectUtils.parseStringArray(bean.getAnnotationKey("associationField"));
                    for (String annkey : annKeys) {
                        if (!ObjectUtils.NotNull(bean.getObjectKey(annkey))) {
                            return EntityUtils.newValidateResultTrue("关联校验属性" + annkey + "值为空！");
                        }
                    }
                }
            }
        }
        return EntityUtils.newValidateResultFalse();
    }

}
