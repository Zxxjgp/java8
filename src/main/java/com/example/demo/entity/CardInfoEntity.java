package com.example.demo.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CardInfoEntity(银行卡片信息)
 * @date 2019/3/20  17:17
 */
@Data
public class CardInfoEntity implements Serializable {
    /**
     *卡BIN
     */
    private String accBin;
    /**
     *卡BIN长度
     */
    private String accBinLen;
    /**
     *
     */
    private String accOffSetBit;
    /**
     *卡长度
     */
    private String accLen;
    /**
     *农行标志(Y:是；N:否)
     */
    private String abcFlg;
    /**
     *卡类型
     * a,s-借记卡
     * z-准贷记卡
     * c-贷记卡
     * 0:借记卡
     * 1:贷记卡
     */
    private String accType;
    /**
     * 评论或者备注
     */
    private String comment_;
    /**
     *地区码
     */
    private String areaCode;
}
