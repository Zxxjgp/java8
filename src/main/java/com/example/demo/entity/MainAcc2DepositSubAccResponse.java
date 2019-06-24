package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainAcc2DepositSubAccResponse extends Response {
    /**
     *
     */
    private String FmtCode;
    /**
     *
     */
    private String Count;
    /**
     *
     */
    private String AccNo;
    /**
     *
     */
    private String AccName;
    /**
     *
     */
    private String SubSeq;
    /**
     *
     */
    private String TranAmt;
    /**
     *
     */
    private String EndDate;
    /**
     *
     */
    private String InterestRate;
    /**
     *
     */
    private String DeAccBal;

}
