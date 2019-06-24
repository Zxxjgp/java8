package com.example.demo.entity.assetsQuery;

import com.example.demo.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName QryBalRequest
 * @date 2019/3/25  11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QryBalRequest extends Request {
    private String LocalSettleNo;
    private String UpperSettleNo;
    private String Area;
    private String TermType;
    private String MerchId;
    private String MMC;
    private String MerchName;
    private String DeviceNo;
    private String Cups60Field;
    private String InputType;
    private String AccNo;
    private String AccPwd;
    private String Track2;
    private String Track3;
    private String CardSeqNo;
    private String EmvData;
    private String ExpireDate;
    private String CVV2;
    private String CurrCode;
}
