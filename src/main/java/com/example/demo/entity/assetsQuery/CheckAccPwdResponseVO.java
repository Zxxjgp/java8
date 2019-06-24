package com.example.demo.entity.assetsQuery;


import com.example.demo.entity.Response;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Administrator on 2018/4/8 0008.
 */
@Data
public class CheckAccPwdResponseVO extends Response {

    @ApiModelProperty("IC卡数据（TLV格式)")
    private String EmvData;
}
