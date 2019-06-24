package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloseDepositSubAcc2MainAccResponse extends Response {
    private String FmtCode;
    private String Count;
    private String AccNo;
    private String AccName;
    private String SubAccBal;
    private String StarIntDate;
    private String EndDate;
    private String Interest;
    private String InterestRate;
    private String OughtTaxInterest;
    private String TaxRate;
    private String InterestTax;
    private String DeAccBal;
    private String TermCode;
    private String BankName;
    private String OrigPrincipal;
    private String AccumuInterest;
    private String AccumuInterestTax;
    private String AccumuOughtTaxInterest;

}
