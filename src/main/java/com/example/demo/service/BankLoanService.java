package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.BankLoanEntity;
import com.example.demo.entity.CardBindEntity;
import com.example.demo.entity.CustInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankLoanService(贷款的相关联操作)
 * @date 2019/3/22  11:31
 */

public interface BankLoanService extends IService<BankLoanEntity> {

    /*
     * <b>Description:</b>
     *  获取银行卡列表
     * @param: openId , cardType
     * @return: list
     * @Auther: jiaoguanping
     * @Date: 2019-03-22 11:36
     */
    List<CardBindEntity> getCardList(String openId, String cardType);

    List<CardBindEntity> getCardById (@Param(value = "userId") String userId);

    CustInfoEntity getCustInfo(String userId);

}
