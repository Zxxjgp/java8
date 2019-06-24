package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;



/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CardBindEntity
 * @date 2019/3/20  16:38
 */
@Data
@TableName("T_WX_CARDBIND")
public class CardBindEntity implements Serializable {
    @ApiModelProperty(value = "用户的id")
    private String userId;
    @ApiModelProperty(value = "客户号码")
    private String custNo;
    @TableId
    @ApiModelProperty(value = "卡号")
    private String cardNo;
    @ApiModelProperty(value = "卡类型")
    private String cardType;
    @ApiModelProperty(value = "区域代码")
    private String areaCode;
    @ApiModelProperty(value = "开户行")
    private String branch;
    @ApiModelProperty(value = "电话号码")
    private String telNo;
    @ApiModelProperty(value = "绑定日期")
    private String bindDate;
    @ApiModelProperty(value = "主卡标志")
    private String mainCard;
    @ApiModelProperty(value = "身份证号码")
    private String certId;
    @ApiModelProperty(value = "解绑日期")
    private String unBindDate;
    @ApiModelProperty(value = "绑卡描述")
    private String bindEntry;
    @ApiModelProperty(value = "备注")
    private String bz;
    @ApiModelProperty(value = "农业银行的标识")
    private String abcFlag;
    private String alias;
}
