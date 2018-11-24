package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.ValidateRealtionNull;

/**
 * 如果注解的属性值为空，则注解属性的所有值都不能为空
 * 例如：id值如果为空，则name、age、sex的值都不能为空
 *
 * @RealtionNull({"name","age","sex"})
 * String id
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(ValidateRealtionNull.class)
public @interface RealtionNull {
    String[] value() default "{}";
}
