package com.example.demo.enums;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName LoanStatusCode
 * @date 2019/6/6  11:02
 */
public enum LoanStatusCode {
    IN_PROCESS("1", "PERSON"),
    SUCCESS("2", "HOUSE"),
    FAILURE("3", "COMPANY"),
    CANCEL("4", "LUDAN"),
    ;

    private String code;
    private String msg;

    LoanStatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
