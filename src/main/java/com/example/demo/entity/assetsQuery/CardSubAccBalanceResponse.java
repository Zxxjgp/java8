package com.example.demo.entity.assetsQuery;

import com.example.demo.entity.Response;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CardSubAccBalanceResponse
 * @date 2019/3/25  14:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardSubAccBalanceResponse extends Response {
    @ApiModelProperty(value = "格式码")
    private String FormatNo;
    @ApiModelProperty(value = "条目计数")
    private String Count;
    @ApiModelProperty(value = "省市代码")
    private String ProvinceCode;
    @ApiModelProperty(value = "卡号")
    private String CardNo;
    @ApiModelProperty(value = "户名")
    private String AccName;
    @ApiModelProperty(value = "后继查询标志：0-无后继查询，1-有后继查询 ")
    private String NextQryFlag;
    @ApiModelProperty(value = "子账户信息列表")
    private List<SubAccInfo> subAccInfoList;
}
