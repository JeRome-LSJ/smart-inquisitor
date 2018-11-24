package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.ValidateEnumKey;

/**
 * 注解的属性值必须在注解值的枚举范围内
 * 例如：注解标识ID值必须在AA、BB、CC三个值中的一个
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 *
 * @EnumKey(valueRange={"1","2","3"},isNullValid=true)
 * String ID
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(ValidateEnumKey.class)
public @interface EnumKey {

    boolean isNullValid() default true;

    String[] valueRange() default "{}";
}
