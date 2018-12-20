package com.jd.validate.engine;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.jd.validate.annotations.Iteration;
import com.jd.validate.common.Constraint;
import com.jd.validate.common.ObjectUtils;
import com.jd.validate.inter.AbstractConstraintValidator;

public class Validator {

    public static ValidateResult validate(Object bean) throws Exception {
        //初始化对象，传递到各个子接口中
        ObjectParameter objectParam = EntityUtils.newObjectParameter(bean);
        //迭代校验
        return iterationValidate(bean, objectParam, bean);

    }

    /**
     * 循环迭代校验实体对象
     */
    private static ValidateResult iterationValidate(Object bean, ObjectParameter objectParam, Object parentObject) throws Exception {
        //设置校验的实体对象
        objectParam.setObjectParameter(bean);
        //如果校验对象是空，直接跳过校验
        if (ObjectUtils.isNull(bean)) {
            return EntityUtils.newValidateResultFalse();
        }
        //这里需要添加LIST的校验
        if (bean instanceof List<?>) {
            List<?> checkListBean = (List<?>) bean;
            for (Object listBean : checkListBean) {
                //如果属性值不为空，就需要进入到下一层对象进行校验
                ValidateResult iterationValidate = iterationValidate(listBean, objectParam, bean);
                //如果返回校验TRUE就直接返回就OK
                if (iterationValidate.getValidateCheckResult()) {
                    return iterationValidate;
                }
            }

        }
        //创建一个参数对象用来容纳实体Bean的属性值
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            //禁用属性权限的校验
            field.setAccessible(true);
            //设置注解的实体属性KE
            objectParam.setAnnotationKey(field.getName());
            //设置注解的实体属性值
            objectParam.setAnnotationKeyValue(field.getName());
            //先判断属性是否有迭代注解
            Iteration iteration = field.getAnnotation(Iteration.class);
            //如果存在迭代属性
            if (ObjectUtils.isNotNull(iteration)) {
                //判断注解对象和迭代注解的属性值，如果校验拦截，返回TRUE
                if (iteration.NullValidate() && ObjectUtils.isNull(objectParam.getAnnotationKeyValue())) {
                    return EntityUtils.newValidateResultTrue("迭代属性值校验为空，属性 ：{ ".concat(objectParam.getAnnotationKey()).concat(" } ! "));
                }
                //如果属性值为空不校验，且属性值为空，直接跳过这个属性校验即可
                if (ObjectUtils.isNull(objectParam.getAnnotationKeyValue())) {
                    continue;
                }
                objectParam.addHierarchyObject(bean);

                //如果属性值不为空，就需要进入到下一层对象进行校验
                ValidateResult iterationValidate = iterationValidate(objectParam.getAnnotationKeyValue(), objectParam, bean);
                //如果返回校验TRUE就直接返回就OK
                if (iterationValidate.getValidateCheckResult()) {
                    return iterationValidate;
                }
            }
            //获取属性的注解
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                //获取注解自身的属性值
                Class<? extends Annotation> annotationType = annotation.annotationType();
                Method[] methods = annotationType.getDeclaredMethods();
                for (Method method : methods) {
                    //将注解的自身属性和属性值传递到各个实现类中
                    objectParam.setAnnotationObject(method.getName(), method.invoke(annotation));
                }
                //根据注解了获取注解实现类名称
                Constraint constraintAnnotation = annotationType.getAnnotation(Constraint.class);
                if (constraintAnnotation != null) {
                    Class<? extends AbstractConstraintValidator> value = constraintAnnotation.value();
                    //反射注解实现类
                    AbstractConstraintValidator newInstance = value.newInstance();
                    //调用各自的实现类自行匹配校验规则，返回估计参数即可
                    ValidateResult execResult = newInstance.exec(objectParam);
                    if (execResult != null && execResult.getValidateCheckResult()) {
                        execResult.setValidateCheckMsg("属性 { ".concat(objectParam.getAnnotationKey()).concat(" } ! ").concat(execResult.getValidateCheckMsg()));
                        return execResult;
                    }
                }
            }
        }
        //将校验对象设置迭代之外
        objectParam.setObjectParameter(parentObject);
        //什么都不做，默认校验通过
        return EntityUtils.newValidateResultFalse();
    }

}
