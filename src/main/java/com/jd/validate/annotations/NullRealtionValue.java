package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.ValidateNullRealtionValue;

/**
 * 如果注解的属性值为空，则注解属性的所有值都不能为某个特定值(默认judge=false)或者必须为某个值(judge=true)
 * 例如：id值如果为空，则name、age、sex的值都不能为空
 *
 * @RealtionNull(judgeValue={"name:aa","age:20","sex:3"},judge=true)
 * String id
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(ValidateNullRealtionValue.class)
public @interface NullRealtionValue {
    boolean judge() default false;

    String[] judgeValue() default "{}";
}
