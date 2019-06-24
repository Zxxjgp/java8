package com.example.demo.entity.assetsQuery;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CheckAccPwdRO
 * @date 2019/3/25  11:13
 */
@Data
public class CheckAccPwdRO {
    @NotEmpty(message = "卡号不能为空")
    @ApiModelProperty(value = "卡号")
    private String accNo;

    @ApiModelProperty(value = "密码")
    private String accPwd;

    @ApiModelProperty(value = "模式：0-只rsa解密，1-rsa解密之后boeing四期加密，2-rsa解密之后boeing三期加密")
    private String mode;

    @ApiModelProperty(value = "ref_no")
    private String refNo;

    @NotEmpty(message = "微信id不能为空")
    @ApiModelProperty(value = "微信id")
    private String openId;

    @ApiModelProperty(value = "业务跟踪单编号")
    private String businessNo;
}
