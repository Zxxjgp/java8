package com.example.demo.entity.assetsQuery;


import com.example.demo.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CardSubAccBalanceRequest
 * @date 2019/3/25  14:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardSubAccBalanceRequest extends Request {
    //卡号
    private String CardNo;

    private String InputAccTye;

    private String InputCcy;

    //卡类型
    private String AccType;
    //货币
    private String Currency;

    private String SubSeq;

    private String QryFlag;


    private String StateQryFlag;
}
