package com.example.demo.enums;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName LoanTradeStatus
 * @date 2019/6/3  9:34
 */
public enum LoanTradeStatus implements IErrorCode{

    LOAN_TYPE_CONSUME("1", "LOAN_TYPE_CONSUME"),
    LOAN_TYPE_RUN("2", "LOAN_TYPE_RUN"),
    LOAN_TYPE_HOUSE("3", "LOAN_TYPE_HOUSE"),
    LOAN_TYPE_COMPANY("4", "LOAN_TYPE_COMPANY"),
    LOAN_TYPE_HUINONG("5", "LOAN_TYPE_HUINONG"),;

    private String code;
    private String msg;

    LoanTradeStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
