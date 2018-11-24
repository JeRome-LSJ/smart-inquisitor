package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.IsDateValidate;

/**
 * 注解的属性值必须为规定的日期类型
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 * longTerm="长期" 如果长期不校验
 * 例如：注解标识time值必须为yyyymmdd hh24:mi:ss格式
 *
 * @IsDate("yyyymmdd hh24:mi:ss")
 * String time
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(IsDateValidate.class)
public @interface IsDate {
    boolean isNullValid() default true;

    String longTerm() default "";

    String dateType() default "yyyyMMdd HH:mm:ss";

}
