package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的属性值可以迭代进注解校验
 * 例如：注解标识ExampleBean实体也进行校验，如果NullValidate=false代表ExampleBean为空不进行校验
 *
 * @Iteration(NullValidate=true)
 * Bean ExampleBean
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Iteration {
    boolean NullValidate() default false;
}
