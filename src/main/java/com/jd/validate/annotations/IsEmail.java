package com.jd.validate.annotations;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.IsEmailValidate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的属性值必须为邮箱类型
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 * 例如：注解标识IsEmail值
 *
 * @IsEmail
 * String IsEmail
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(IsEmailValidate.class)
public @interface IsEmail {
    boolean isNullValid() default true;

}
