package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainAcc2DepositSubAccResponseVO implements Serializable {
    /**
     *
     */
    private String fmtCode;
    /**
     *
     */
    private String count;
    /**
     *
     */
    private String accNo;
    /**
     *
     */
    private String accName;
    /**
     *
     */
    private String subSeq;
    /**
     *
     */
    private String tranAmt;
    /**
     *
     */
    private String endDate;
    /**
     *
     */
    private String interestRate;
    /**
     *
     */
    private String deAccBal;

}
