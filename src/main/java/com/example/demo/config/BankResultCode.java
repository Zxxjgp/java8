package com.example.demo.config;

/**
 * BankResultCode
 *
 * @author jiaoguanping
 * @version 1.0.0
 * @date 2019/3/20  15:20
 */
public enum BankResultCode {
    VERIFICATION_CODE_MISMATCH(50,"验证码错误"),
    APPLICATION_FAILURE(51,"申请失败"),
    VERIFICATION_CODE_NOTEXPIRED(52,"短信已发送请勿频繁发送"),
    REPEATING_CARD(53,"不可重复绑卡"),
    CARDNUMBER_DOESNOT_EXIST(54,"卡号不存在"),
    IDCARD_IS_NOT_BOUNDCARDNUMBER(55,"身份证与卡号不匹配"),
    PHONE_NUMBER_NOT_MATCH_THE_CARD_NUMBER(56,"手机号码与卡号不匹配"),
    ONLY_SUPPORT_BINDING_THE_LINE_CARD(57,"只支持本行借记卡和贷记卡"),
    OPENID_NOT_USERID(58,"用户不存在"),
    SYSTEM_EXCEPTION(59,"连接失败"),
    IS_NOT_IP(60,"非法IP"),
    TIMEOUT_TRANSACTION(61,"交易超时"),
    PASSWORD_ERROR(62,"密码错误"),
    INVESTMENT_FAIL(63,"理财列表获取失败"),
    QUERY_FAIL(0,"验证密码失败"),
    FAIL(63,"理财列表获取失败");
    private String desc;
    private int code;
    BankResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
