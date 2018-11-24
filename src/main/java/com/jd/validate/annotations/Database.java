package com.jd.validate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jd.validate.common.Constraint;
import com.jd.validate.impl.ValidateDatabase;

/**
 * 链接数据库的注解类
 * mapper对于MYBATIS中的SQL语句，paramter执行这条语句的入参(对象中获取)
 * fixedValue 执行这条语句的入参(固定值) exceptFixed特殊情况当某字段值为特定值是不校验
 * verifyFixed 特殊情况当某字段值为特定值时才校验
 * isNullValid=true 加上此属性为空判空 默认为TRUE 若为false为空时不校验
 * isExist=true表示数据库中必须存在此值  默认为TRUE 若为false则表示数据库中不能存在此值
 *
 * @Database(mapper="CommonUtils.queryStaffById", paramter={"StaffId:id","StaffName:name"},
 * fixedValue={"StaffId:id","StaffName:name"},isNullValid=true)
 * String name
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(ValidateDatabase.class)
public @interface Database {
    boolean isNullValid() default true;

    boolean isExist() default true;

    String mapper();

    String[] paramter() default "{}";

    String[] fixedValue() default "{}";

    String[] exceptFixed() default "{}";

    String[] verifyFixed() default "{}";

}
