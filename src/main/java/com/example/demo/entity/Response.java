package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Response
 * @date 2019/3/20  18:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @ApiModelProperty(value = "错误码，0000表示成功，其它表示失败")
    private String retCode;
    @ApiModelProperty(value = "错误码对应信息")
    private String retMsg;
    @ApiModelProperty(value = "网关流水号")
    private String logNo;
    @ApiModelProperty(value = "后台交易码")
    private String transCode;
    @ApiModelProperty(value = "后台流水号")
    private String jrnNo;
}
