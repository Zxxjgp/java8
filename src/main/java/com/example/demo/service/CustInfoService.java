package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.CardBindEntity;
import com.example.demo.entity.CardInfoEntity;
import com.example.demo.entity.CustInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.awt.*;
import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CustInfoService
 * @date 2019/3/27  17:34
 */
public interface CustInfoService extends IService<CustInfoEntity> {

    CustInfoEntity getList();
    List<CardInfoEntity> getlist();

    List<CardBindEntity> cardList( String openId);
}
