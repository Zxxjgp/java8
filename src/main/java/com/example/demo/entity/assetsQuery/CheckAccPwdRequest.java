package com.example.demo.entity.assetsQuery;


import com.example.demo.entity.Request;
import lombok.Data;


@Data
public class CheckAccPwdRequest extends Request {
    /**
     *
     */
    private String InputType;
    /**
     * 账号
     */
    private String AccNo;
    /**
     * 密码
     */
    private String AccPwd;
    private String Track2;
    private String Track3;
    private String CardSeqNo;
    private String EmvData;
    /**
     * 过期时间
     */
    private String ExpireDate;
    private String CVV2;
    private String CurrCode;

}
