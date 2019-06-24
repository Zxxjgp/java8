package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.CustInfoMapper;
import com.example.demo.entity.CardBindEntity;
import com.example.demo.entity.CardInfoEntity;
import com.example.demo.entity.CustInfoEntity;
import com.example.demo.service.CustInfoService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CustInfoServiceImpl
 * @date 2019/3/27  17:35
 */
@Service
public class CustInfoServiceImpl extends ServiceImpl<CustInfoMapper, CustInfoEntity> implements CustInfoService {
    @Override
    public CustInfoEntity getList() {
        return baseMapper.selectById("1");
    }

    @Override
    public List<CardInfoEntity> getlist() {
        return baseMapper.qryCardInfo();
    }

    @Override
    public List<CardBindEntity> cardList(String openId) {
        return baseMapper.cardList(openId);
    }

    @Override
    public boolean update(Wrapper<CustInfoEntity> updateWrapper) {
        baseMapper.deleteById(1);
        return false;
    }

}
