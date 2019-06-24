package com.example.demo.utils;

import com.example.demo.enums.IErrorCode;

/**
* @ClassName EnumUtil
* @Description: 枚举工具类，通过Code返回枚举
* T extends CodeEnum 定义泛型的上限
* enumClass.getEnumConstants() 通过反射取出Enum所有常量的属性值
* @Author jgp
* @Date 2019/06/03 11:38
* @Version
*/
public class EnumUtil {

    public static <T extends IErrorCode> T getByCode(String code, Class<T> enumClass) {
        //通过反射取出Enum所有常量的属性值
        for (T each: enumClass.getEnumConstants()) {
        //利用code进行循环比较，获取对应的枚举
                if (code.equals(each.getCode())) {
                return each;
                }
            }
        return null;
    }
}
