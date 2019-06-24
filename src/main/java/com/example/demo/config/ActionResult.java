package com.example.demo.config;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author : CM
 * @date : 2019/3/4
 */
public class ActionResult<T> implements Serializable {
    private int errCode;
    private String errMsg;
    private T value;

    public ActionResult() {
        this(ErrorCode.SUCCESS);
    }

    public ActionResult(IErrorCode errorCode) {
        this.errCode = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
        this.value = null;
    }

    public ActionResult(int errCode, String errMsg) {
        this.errCode = errCode;
        if (!StringUtils.isEmpty(errMsg)) {
            this.errMsg = errMsg;
        }
        this.value = null;
    }

    public ActionResult(int errCode, String errMsg, T value) {
        this.errCode = errCode;
        if (!StringUtils.isEmpty(errMsg)) {
            this.errMsg = errMsg;
        }
        this.value = value;
    }

    public ActionResult(IErrorCode errorCode, T value) {
        this.errCode = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
        this.value = value;
    }

    public ActionResult(IErrorCode errorCode, String errMsg, T value) {
        this.errCode = errorCode.getCode();
        if (!StringUtils.isEmpty(errMsg)) {
            this.errMsg = errMsg;
        } else {
            this.errMsg = errorCode.getMsg();
        }
        this.value = value;
    }

    public ActionResult(T value) {
        this.errCode = ErrorCode.SUCCESS.getCode();
        this.errMsg = ErrorCode.SUCCESS.getMsg();
        this.value = value;
    }

    public static ActionResult Success() {
        return new ActionResult(ErrorCode.SUCCESS);
    }

    public static ActionResult Failure() {
        return new ActionResult(ErrorCode.FAILURE);
    }

    public static ActionResult Error() {
        return new ActionResult(ErrorCode.UN_KNOWN_EXCEPTION);
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setErrorCode(IErrorCode errorCode) {
        this.errCode = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
    }
}
