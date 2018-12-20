package com.jd.validate.impl;


import com.jd.validate.common.ObjectUtils;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;

/**
 * 如果注解的属性值为空，则注解属性的所有值不能为空
 * 例如：id值如果为空，则name、age、sex的值都不能为空
 *
 * @RealtionNull({"name","age","sex"}) String id
 */
public class ValidateRealtionNull extends AbstractConstraintValidator {

    @Override
    public ValidateResult exec(ObjectBean bean) {
        if (ObjectUtils.isNull(bean.getAnnotationKeyValue())) {
            String[] annKeys = ObjectUtils.parseStringArray(bean.getAnnotationValue());
            for (String key : annKeys) {
                if (ObjectUtils.isNull(bean.getObjectKey(key))) {
                    return EntityUtils.newValidateResultTrue("关联校验属性值为空！");
                }
            }
        }
        return EntityUtils.newValidateResultFalse();
    }

}
