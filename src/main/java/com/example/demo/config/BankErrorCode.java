package com.example.demo.config;

public enum BankErrorCode implements IErrorCode {
    USAP_LOGIN_EXCEPTION(1, "USAP登录异常"),
    PARAMETER_ERROR(1, "参数异常"),
    SEARCH_CUSTINFO_FAIL(1, "查询失败"),
    INSERT_STATUS_SUCCESS(0, "操作成功"),
    INSERT_STATUS_FAIL(1, "操作失败");


    private int code;
    private String msg;

    BankErrorCode(int code, String msg) {
        this.code = IErrorCode.BANK_BASE_CODE + code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
