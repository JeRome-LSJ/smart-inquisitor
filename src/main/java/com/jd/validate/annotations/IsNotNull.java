package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.IsNotNullValidate;

/**
 * 注解的属性值必须不为空和空字符串
 * 例如：注解标识ID值必须不为空和空字符串
 *
 * @IsNull
 * String ID
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(IsNotNullValidate.class)
public @interface IsNotNull {

}
