package com.jd.validate;

import com.jd.validate.annotations.EnumKey;
import com.jd.validate.annotations.IsNotNull;
import com.jd.validate.annotations.Iteration;
import com.jd.validate.annotations.Size;

public class BeanEntity {

    @IsNotNull
    public String id;

    @EnumKey(valueRange={"1","2"} ,isNullValid = true)
    public String name;

    @Size(max=10,min=1,isNullValid=true,isChinese=true)
    public String sex;

    @Iteration
    public BeanEntity beanEntity;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
