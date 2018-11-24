package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.IsZipValidate;

/**
 * 注解的属性值必须为邮政编码
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 * 例如：注解标识字段必须是合法的邮政编码
 *
 * @Iszip
 * String zip
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(IsZipValidate.class)
public @interface IsZip {
    boolean isNullValid() default true;

}
