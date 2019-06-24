package com.example.demo.utils;

/**
 * @Author: madongfang
 * @Date: 2019/3/22 11:01
 * @Version 1.0
 */
public enum ZityReturnCode {

    /**
     * 成功
     */
    SUCCESS("0000", "成功"),

    /**
     * 失败
     */
    FAILURE("1111", "失败"),

    /**
     * 充值成功
     */
    RECHARGE_SUCCESS("0001", "充值成功"),

    /**
     * 充值失败
     */
    RECHARGE_FAILURE("0002", "充值失败"),

    /**
     * 找不到相应订单
     */
    ORDER_NOT_EXIST("0003", "找不到相应订单"),

    /**
     * 其他错误
     */
    RECHARGE_OTHER_ERROR("0004", "其他错误"),

    /**
     * CPID错误
     */
    CPID_ERROR("1100", "CPID错误"),

    /**
     * 错误的交易类型
     */
    TRADE_TYPE_ERROR("1000", "错误的交易类型"),

    /**
     * 错误的号码运营商
     */
    OPERATOR_ERROR("1001", "错误的号码运营商"),

    /**
     * 错误的充值金额
     */
    AMOUNT_ERROR("1002", "错误的充值金额"),

    /**
     * 错误的手机号码
     */
    MOBILE_NO_ERROR("1003", "错误的手机号码"),

    /**
     * 省份编码错误
     */
    PROVINCE_ERROR("1004", "省份编码错误"),

    /**
     * 号码与运营商不匹配
     */
    MOBILE_NO_NOT_MATCH_OPERATOR("1005", "号码与运营商不匹配"),

    /**
     * 错误的手机归属地
     */
    MOBILE_NO_ATTRIBUTION_ERROR("1006", "错误的手机归属地"),

    /**
     * 数字签名错误
     */
    SIGN_ERROR("1007", "数字签名错误"),

    /**
     * 错误的CP订单号
     */
    ORDER_NO_ERROR("1008", "错误的CP订单号"),

    /**
     * 重复的订单提交
     */
    RESUBMIT("1009", "重复的订单提交"),

    /**
     * CP余额不足
     */
    CP_BALANCE_INSUFFICIENT("1010", "CP余额不足"),

    /**
     * 该地区暂停充值服务
     */
    SUSPEND_RECHARGE_SERVICE("1011", "该地区暂停充值服务"),

    /**
     * 其它错误
     */
    OTHER_ERROR("1101", "其它错误"),;

    private String code;
    private String msg;

    ZityReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static boolean isValidEnum(String code) {
        boolean result = false;
        for (ZityReturnCode returnCode : values()) {
            if (returnCode.getCode().equals(code)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static ZityReturnCode getByCode(String code) {
        for (ZityReturnCode returnCode : values()) {
            if (returnCode.getCode().equals(code)) {
                return returnCode;
            }
        }
        return ZityReturnCode.OTHER_ERROR;
    }
}
