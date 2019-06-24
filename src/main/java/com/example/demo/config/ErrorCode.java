package com.example.demo.config;

/**
 * @author : CM
 * @date : 2019/3/4
 */
public enum ErrorCode implements IErrorCode {
    SUCCESS(0, "操作成功"),
    FAILURE(1, "操作失败"),
    PARAMS_INVALID(2, "参数无效,操作失败"),
    UN_AUTH(401, "未登录"),
    NO_AUTHORITY(403, "没有权限，请联系管理员授权"),
    UN_KNOWN_EXCEPTION(500, "未知异常，请联系管理员"),
    ;

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = IErrorCode.BASE_CODE + code;
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
