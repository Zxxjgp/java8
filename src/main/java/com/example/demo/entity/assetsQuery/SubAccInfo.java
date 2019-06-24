package com.example.demo.entity.assetsQuery;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubAccInfo {
    @ApiModelProperty("科目号")
    private String SubjectNum;
    @ApiModelProperty("账户类型：10-活期，15-零整，23-质押，24-最高额 ")
    private String AccType;
    @ApiModelProperty("01人民币")
    private String Ccy;
    @ApiModelProperty("钞汇标志：0-钞，1-汇")
    private String Draf;
    @ApiModelProperty("账户序号")
    private String AccSeq;
    @ApiModelProperty("账户余额")
    private String AccBal;
    @ApiModelProperty("账户可用余额")
    private String AccUseBal;
    @ApiModelProperty("存期")
    private String TermDate;
    @ApiModelProperty("费率")
    private String FeePercent;
    @ApiModelProperty("开户行")
    private String OpenCardProvinceCode;
    @ApiModelProperty("起始日期")
    private String StartDate;
    @ApiModelProperty("终止日期")
    private String EndDate;
    @ApiModelProperty("卡状态")
    private String CardStats;
    @ApiModelProperty("账号顺序号(最后四位)")
    private String AccSeqEnd;
}