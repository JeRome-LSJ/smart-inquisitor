package com.jd.validate.impl;


import com.jd.validate.engine.ValidateResult;
import com.jd.validate.inter.AbstractConstraintValidator;
import com.jd.validate.inter.ObjectBean;

public class ValidateDatabase extends AbstractConstraintValidator {


    /**
     * 注解校验实体需要实现的方法类
     *
     * @param bean@return 返回校验结果集
     */
    @Override
    public ValidateResult exec(ObjectBean bean) {

        return null;
    }
}
