package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.ValidateSize;

/**
 * 属性最大最小值校验
 * 例如：必须为数字  最小长度1 最大长度10
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 * isNumber=true 加上此属性为数字判段 默认为false 若为false时不校验
 * isChinese=true 加上此属性为汉字判段 默认为false 若为false时不校验
 *
 * @Size(max=10,min=1,isNumber=true,isNullValid=true)
 * Long testLong;
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(ValidateSize.class)
public @interface Size {
    boolean isNullValid() default true;

    boolean isNumber() default false;

    boolean isChinese() default false;

    long min() default 0;

    long max() default Long.MAX_VALUE;

}
