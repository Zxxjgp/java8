package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CustInfoEntity(客户信息实体类)
 * @date 2019/3/21  10:07
 */
@Data
public class CustInfoEntity implements Serializable {
    /**
     * 用户的ID
     */
    private String userId;
    /**
     * 客户号
     */
    private String custNo;
    /**
     * 卡号
     */
    private String certId;
    /**
     * 客户名
     */
    private String custName;
    /**
     * 地区码
     */
    private String regAreaCode;
    /**
     * 开户行
     */
    private String regEntry;
    /**
     * 绑定日期
     */
    private String regDate;
    /**
     * 绑定时间
     */
    private String regTime;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 手机号码
     */
    private String telNo;

    /**
     * 开户机构号
     */
    private String branch;

    /**
     * 解绑日期
     */
    private String unRegDate;
    /**
     * 解绑时间
     */
    private String unRegTime;

    /**
     * 备注
     */
    private String bz;
}
