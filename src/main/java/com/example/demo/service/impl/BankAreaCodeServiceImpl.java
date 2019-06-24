package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.demo.dao.BankAreaCodeMapper;
import com.example.demo.entity.BankAreaCodeEntity;
import com.example.demo.entity.CardInfoEntity;
import com.example.demo.service.BankAreaCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankAreaCodeServiceImpl
 * @date 2019/3/27  16:46
 */
@Service
public class BankAreaCodeServiceImpl extends ServiceImpl<BankAreaCodeMapper, BankAreaCodeEntity> implements BankAreaCodeService {


    @Override
    public String getAddressByCode(String code) {
        return baseMapper.getAddressByCode(code);
    }

    @Override
    public List<BankAreaCodeEntity> lista() {
        QueryWrapper<BankAreaCodeEntity> queryWrapper = new QueryWrapper<>();

        List<BankAreaCodeEntity> bankAreaCodeEntities = baseMapper.selectList(queryWrapper.eq("RPI_CHA_NAM","12"));

        Integer integer = baseMapper.selectCount(queryWrapper);

        return bankAreaCodeEntities;
    }

    @Override
    public Integer up() {
        BankAreaCodeEntity c = new BankAreaCodeEntity();
        c.setProCod("10");
        c.setRpiChaNam("娃哈哈");
        return baseMapper.updateById(c);
    }

    @Override
    public List<CardInfoEntity> get() {
        return baseMapper.qryCardInfo();
    }


}
