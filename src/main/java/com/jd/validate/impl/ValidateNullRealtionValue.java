package com.jd.validate.impl;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.engine.EntityUtils;
import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.ConstraintValidator;
import com.jd.validate.inter.ObjectBean;

/**
 * 如果注解的属性值为空，则注解属性的所有值不能为空
 * 例如：id值如果为空，则name、age、sex的值都不能为空
 *
 * @RealtionNull({"name","age","sex"})
 * String id
 */
public class ValidateNullRealtionValue implements ConstraintValidator {

    public ValidateResult exec(ObjectBean bean) {
        if (!ObjectUtils.NotNull(bean.getAnnotationKeyValue())) {
            boolean judge = ObjectUtils.parseBoolean(bean.getAnnotationKey(ValidateConstant.JUDGE));
            Object judgeValue = bean.getAnnotationKey("judgeValue");
            if (judgeValue instanceof String[]) {
                String[] listKeys = (String[]) judgeValue;
                if (judge) {
                    for (String key : listKeys) {
                        String[] sourceStrArray = key.split(":");
                        String sourceValue = (String) bean.getObjectKey(sourceStrArray[0]);
                        if (!sourceValue.equals(sourceStrArray[1])) {
                            return EntityUtils.newValidateResultTrue("关联校验属性" + sourceStrArray[0] + "值不符合要求！");
                        }
                    }
                } else {
                    for (String key : listKeys) {
                        String[] sourceStrArray = key.split(":");
                        String sourceValue = (String) bean.getObjectKey(sourceStrArray[0]);
                        if (sourceValue.equals(sourceStrArray[1])) {
                            return EntityUtils.newValidateResultTrue("关联校验属性" + sourceStrArray[0] + "值不符合要求！");
                        }
                    }
                }
            }
        }
        return EntityUtils.newValidateResultFalse();
    }

}
