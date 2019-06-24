package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.CardInfoMapper;
import com.example.demo.entity.BankLoanEntity;
import com.example.demo.entity.CardBindEntity;
import com.example.demo.entity.CustInfoEntity;
import com.example.demo.service.BankLoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankLoanServiceImpl
 * @date 2019/3/22  17:00
 */
@Service
public class BankLoanServiceImpl extends ServiceImpl<CardInfoMapper, BankLoanEntity>  implements BankLoanService  {
    @Resource
    private CardInfoMapper cardInfoMapper;

    @Override
    public List<CardBindEntity> getCardList(String openId, String cardType) {
        List<CardBindEntity> cardInfoEntities = cardInfoMapper.cardList(openId, cardType);
        return cardInfoEntities;
    }

    @Override
    public List<CardBindEntity> getCardById(String userId) {
        List<CardBindEntity> cardByUserId = cardInfoMapper.getCardById(userId);
        return cardByUserId;
    }

    @Override
    public CustInfoEntity getCustInfo(String userId) {
        CustInfoEntity custInfoEntity = cardInfoMapper.queryCustInfoByUserId(userId);
        return custInfoEntity;
    }

}
