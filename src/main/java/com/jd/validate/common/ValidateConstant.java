package com.jd.validate.common;

public interface ValidateConstant {
    /**
     * 关键字 get
     */
    String _GETKEY_ = "get";
    /**
     * 数值 0
     */
    int _LENGTH_ZERO_ = 0;
    /**
     * 数值 1
     */
    int _LENGTH_ONE_ = 1;
    /**
     * 关键字 逗号
     */
    String _REGEX_ = ",";
    /**
     * 关键字 max
     */
    String MAX = "max";
    /**
     * 关键字 min
     */
    String MIN = "min";
    /**
     * 关键字 isNullValid 为空是否校验默认校验
     */
    String ISNULLVALID = "isNullValid";
    /**
     * 关键字 isNumber  是否为0-9数字 默认不校验
     */
    String ISNUMBER = "isNumber";
    /**
     * 关键字 isChinese  是否为汉字 默认不校验
     */
    String ISCHINESE = "isChinese";
    /**
     * 关键字 judge  是为某个值还是不能为某值   默认不能为某个特定值
     */
    String JUDGE = "judge";
    /**
     * 关键字 isExist 判断数据库中必须存在此值（默认） 还是不能存在值
     */
    String ISEXIST = "isExist";


}
