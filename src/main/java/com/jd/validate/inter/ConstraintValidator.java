package com.jd.validate.inter;


import com.jd.validate.engine.ValidateResult;

public interface ConstraintValidator {

    /**
     * 注解校验实体需要实现的方法类
     *
     * @param 可以获取校验对象的每个属性值和注解类的属性值
     * @return 返回校验结果集
     */
    ValidateResult exec(ObjectBean bean);

}
