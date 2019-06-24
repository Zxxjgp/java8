package com.example.demo.service;


import com.example.demo.entity.CloseDepositSubAcc2MainAccResponse;
import com.example.demo.entity.MainAcc2DepositSubAccResponse;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankFinanceService
 * @date 2019/4/3  14:35
 */
public interface BankFinanceService {

    /**
     * <b>Description:</b>
     *  活期转定期
     * @Auther: jiaoguanping
     * @Date: 2019/4/3 14:38
     */
    MainAcc2DepositSubAccResponse mainAcc2DepositSubAccOp(String CardNo, String TrnAmt, String TermCode, String Passwd,
                                                          String Trandepsign, String TrandepsignTerm);


    /**
     * <b>Description:</b>
     *  定期转活期
     * @Auther: jiaoguanping
     * @Date: 2019/4/3 14:53
     */
    CloseDepositSubAcc2MainAccResponse closeDepositSubAcc2MainAccOp(String accNo, String subSeq, String accPwd);
}
