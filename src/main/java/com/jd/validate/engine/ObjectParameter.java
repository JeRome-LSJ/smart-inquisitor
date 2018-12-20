package com.jd.validate.engine;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.jd.validate.common.ObjectUtils;
import com.jd.validate.common.ValidateConstant;
import com.jd.validate.inter.ObjectBean;

public class ObjectParameter implements ObjectBean {
    /**
     * 承接校验实例的对象，在迭代校验的时候切换对象
     */
    Object objectParameter = null;
    /**
     * 标志注解的实体属性
     */
    String annotationKey = null;
    /**
     * 标志注解的实体属性值
     */
    Object annotationKeyValue = null;
    /**
     * 将注解解析为MAP对象存储，可以获取注解本身的属性值
     */
    HashMap<String, Object> annotationObject = null;
    /**
     * 层级存储对象引用，方便在任何地方获取任意层级的对象属性值
     */
    HashMap<String, Object> hierarchyObject = null;

    /**
     * 初始化对象，同时初始化层级对象和注解存储对象
     */
    public ObjectParameter(Object bean) {
        if (bean == null) {
            throw new RuntimeException("Error validate.....validate bean is null！");
        }
        this.hierarchyObject = EntityUtils.newHashMap();
        this.hierarchyObject.put(bean.getClass().getSimpleName(), bean);
        this.annotationObject = EntityUtils.newHashMap();
    }

    /**
     * 获取当前校验对象
     */
    public Object getObjectParameter() {
        return objectParameter;
    }

    /**
     * 重新赋值当前校验对象
     */
    public void setObjectParameter(Object objectParameter) {
        this.objectParameter = objectParameter;
    }

    /**
     * 获取注解标注的实体属性值
     */
    @Override
    public Object getAnnotationKeyValue() {
        return annotationKeyValue;
    }

    /**
     * 赋值注解标注的属性
     */
    public void setAnnotationKeyValue(String annotationKeyValue) {
        this.annotationKeyValue = getObjectKey(annotationKeyValue);
    }

    /**
     * 通过反射获取对象的属性值
     */
    @Override
    public Object getObjectKey(String key) {
        if (key == null || key.length() == 0) {
            return null;
        }
        Object value = null;
        try {
            Method method = objectParameter.getClass().getMethod(ValidateConstant._GETKEY_.concat(key.substring(ValidateConstant._LENGTH_ZERO_, ValidateConstant._LENGTH_ONE_).toUpperCase().concat(key.substring(ValidateConstant._LENGTH_ONE_))));
            value = method.invoke(objectParameter);
        } catch (Exception e) {
            return null;
        }
        return value;
    }

    /**
     * 添加注解自身的属性和属性值
     */
    public void setAnnotationObject(String annontationKey, Object annontationValue) {
        annotationObject.put(annontationKey, annontationValue);
    }

    /**
     * 根据不同的KEY获取注解自身的属性定义
     */
    @Override
    public Object getAnnotationKey(String key) {
        return annotationObject.get(key);
    }


    public String getAnnotationKey() {
        return annotationKey;
    }


    public void setAnnotationKey(String annotationKey) {
        this.annotationKey = annotationKey;
    }

    /**
     * 获取默认的注解属性VLAUE的值
     */
    @Override
    public Object getAnnotationValue() {
        return annotationObject.get("value");
    }

    /**
     * 增加层级对象的引用关系
     */
    public void addHierarchyObject(Object bean) {
        if (ObjectUtils.isNotNull(bean) && ObjectUtils.isNotNull(hierarchyObject)) {
            this.hierarchyObject.put(bean.getClass().getSimpleName(), bean);
        } else {
            throw new RuntimeException("Error validate，method addHierarchyObject error！");
        }
    }
}
