package com.example.demo.entity.assetsQuery;

import com.example.demo.entity.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName QryBalResponse
 * @date 2019/3/25  11:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QryBalResponse extends Response {
    //账户名
    private String AccName;

    //
    private String Balance;

    private String UseBal;

    private String AvlBal;

    private String BalCurrCode;
    private String EmvData;

}
