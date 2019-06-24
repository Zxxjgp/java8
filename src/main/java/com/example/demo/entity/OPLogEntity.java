package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName OPLogEntity(微信操作日志表)
 * @date 2019/3/25  17:13
 */
@Data
@TableName("T_WX_OPLOG")
public class OPLogEntity implements Serializable {
    /**
     * 日志号
     */
    @TableId
    private String logNo;
    /**
     * 微信的openid
     */
    private String openId;
    /**
     * 交易码
     */
    private String bizCode;
    /**
     * 日期
     */
    private Date opDate;
    /**
     * 时间
     */
    @TableField(exist = false)
    private String opTime;
    /**
     *
     */
    private String opContext;
    /**
     * 交易结构
     */
    private String opResult;
    /**
     *  交易卡号
     */

    private String accNo;
    /**
     * 交易金额
     */
    private String amount;
    /**
     * 实付手续费
     */
    private String paidFee;
    /**
     * 应付手续费
     */
    private String chargeAbleFee;
    /**
     * 转入卡号
     */
    private String otherAccno;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 转入方姓名
     */
    private String otherName;
    /**
     * 手机号
     */
    private String tellerNo;
    /**
     * 机构号   行号
     */

    private String branch;
    /**
     *备注
     */
    private String bz;
    /**
     * 备注1
     */
    private String bz1;
}
