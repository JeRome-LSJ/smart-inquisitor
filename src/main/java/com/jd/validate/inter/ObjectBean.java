package com.jd.validate.inter;

/**
 * @author PoolInSky
 */
public interface ObjectBean {

    /**
     * 获取实体中被注解字段的值，传递到各自的校验实现类中
     * @return Object
     */
    Object getAnnotationKeyValue();

    /**
     * 根据字段获取实体中的值
     * @param key String
     * @return Object
     */
    Object getObjectKey(String key);

    /**
     * 根据字段获取注解中的特殊定义值
     * @param key String
     * @return Object
     */
    Object getAnnotationKey(String key);

    /**
     * 默认获取注解value属性的值
     * @return Object
     */
    Object getAnnotationValue();

}
