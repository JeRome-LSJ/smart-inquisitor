package com.jd.validate.common;

import com.jd.validate.inter.ConstraintValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * 给组件添加校验类的映射
 * 摒弃XML配置等配置文件
 *
 * @author 李启坤
 */
@Documented
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface Constraint {
    Class<? extends ConstraintValidator> value();
}
