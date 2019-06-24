package com.example.demo.config;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankCardIdCode
 * @date 2019/3/28  9:34
 */
public enum BankCardIdCode {
    ID_CARD_LENGTH_ERROR(20000,"身份证号码长度应该为15位或18位"),
    ID_CARD_FORMAT_ERROR(20001,"身份证15位号码都应为数字;18位号码除最后一位外,都应为数字"),
    ID_CARD_BIRTHDAY_ERROR(20002,"身份证生日无效"),
    ID_CARD_BIRTHDAY_DAY_ERROR_(20003,"身份证生日不在有效范围"),
    ID_CARD_BIRTHDAY_MONTH_ERROR(20004,"身份证月份无效"),
    ID_CARD_BIRTHDAY_DATE_ERROR(20005,"身份证日期无效"),
    ID_CARD_REGIONAL_CODE_ERROR(20006,"身份证地区编码错误"),
    ID_CARD_INVALID_ERROR(20007,"身份证无效，不是合法的身份证号码"),
    ID_CARD_SUCCESS(0000,"身份证校验通过");



    private Integer code;
    private String msg;

    BankCardIdCode(Integer code, String msg) {
        this.code =  code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
