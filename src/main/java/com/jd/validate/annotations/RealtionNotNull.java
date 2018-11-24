package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.ValidateRealtionNotNull;

/**
 * 如果注解的属性值不为空为特定值，则注解属性的所有值都不能为空
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 * 例如：id值如果不为空为特定值，则name、age、sex的值都不能为空
 *
 * @RealtionNotNull(specificValue={"1","2"},associationField={"name","age","sex"})
 * String id
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(ValidateRealtionNotNull.class)
public @interface RealtionNotNull {
    boolean isNullValid() default true;

    String[] specificValue() default "{}";

    String[] associationField() default "{}";
}
