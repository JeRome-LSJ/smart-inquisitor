package com.jd.validate.inter;

import com.jd.validate.engine.ValidateResult;

/**
 * @author PoolInSky
 */
public abstract class AbstractConstraintValidator {

    /**
     * 注解校验实体需要实现的方法类
     * @param bean ObjectBean 可以获取校验对象的每个属性值和注解类的属性值
     * @return ValidateResult 返回校验结果集
     */
    public abstract ValidateResult exec(ObjectBean bean);

}
