package com.jd.validate.inter;

public interface ObjectBean {

    /**
     * 获取实体中被注解字段的值，传递到各自的校验实现类中
     */
    Object getAnnotationKeyValue();

    /**
     * 根据字段获取实体中的值
     *
     * @param key
     */
    Object getObjectKey(String key);

    /**
     * 根据字段获取注解中的特殊定义值
     *
     * @param key
     */
    Object getAnnotationKey(String key);

    /**
     * 默认获取注解value属性的值
     */
    Object getAnnotationValue();

}
