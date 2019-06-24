package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainAcc2DepositSubAccRO implements Serializable {
    @NotEmpty(message = "卡号不能为空")
    @ApiModelProperty("卡号")
    private String accNo;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty("加密后的密码")
    private String password;

    @NotEmpty(message = "交易金额不能为空")
    @ApiModelProperty("申请金额")
    private String buyAmount;

    @NotEmpty(message = "存款期限不能为空")
    @ApiModelProperty("存款期限")
    private String termCode;

    @NotEmpty(message = "是否转存不能为空")
    @ApiModelProperty("转存标志")
    private String trandepsign;

    @ApiModelProperty("转存期限")
    private String trandepsignTerm;

    @NotEmpty(message = "模式不能为空")
    @ApiModelProperty(value = "模式：0-只rsa解密，1-rsa解密之后boeing四期加密，2-rsa解密之后boeing三期加密")
    private String mode;

    @NotEmpty(message = "微信id不能为空")
    @ApiModelProperty("微信id")
    private String openId;

    @NotEmpty(message = "乱序密码编号不能为空")
    @ApiModelProperty("乱序密码编号")
    private String refNo;

    @ApiModelProperty("定期子账户号")
    private String subSeq;

}
