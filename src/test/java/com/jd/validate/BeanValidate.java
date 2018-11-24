package com.jd.validate;

import com.jd.validate.engine.ValidateResult;
import com.jd.validate.engine.Validator;

public class BeanValidate {

    public static void main(String[] args) throws Exception {

        BeanEntity beanEntity = new BeanEntity();
        // beanEntity.setId("1");
        beanEntity.setName("1");
        beanEntity.setSex("南");


        ValidateResult validateResult = Validator.validate(beanEntity);

        System.out.println("getValidateCheckResult:"+validateResult.getValidateCheckResult());
        System.out.println("getValidateCheckMsg:"+validateResult.getValidateCheckMsg());
        System.out.println("getValidateCheckError:"+validateResult.getValidateCheckError());

    }

}
