package com.example.demo.entity.assetsQuery;


import com.example.demo.entity.Response;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName QryBalResponseVO
 * @date 2019/3/25  11:08
 */
@Data
public class QryBalResponseVO extends Response {
    @ApiModelProperty("户名")
    private String accName;
    @ApiModelProperty("账户余额")
    private String balance;
    @ApiModelProperty("可用余额")
    private String useBal;
    @ApiModelProperty("冻结余额")
    private String avlBal;
    @ApiModelProperty("返回币种")
    private String balCurrCode;
    @ApiModelProperty("IC卡数据（TLV格式）")
    private String emvData;
}
