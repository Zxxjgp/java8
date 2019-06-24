package com.example.demo.config;

/**
 * @author : CM
 * @date : 2019/3/4
 */
public interface IErrorCode {

    int BASE_CODE = 0;
    int ADMIN_BASE_CODE = 1000;
    int BANK_BASE_CODE = 9000;

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误描述
     *
     * @return 错误描述
     */
    String getMsg();
}
