package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.ValidateNotNull;

/**
 * 注解的属性值不能为空
 * 例如：注解标识ID值不能为空
 *
 * @NotNull
 * String ID
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(ValidateNotNull.class)
public @interface NotNull {

}
