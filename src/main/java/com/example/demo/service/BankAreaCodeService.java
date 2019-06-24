package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.BankAreaCodeEntity;
import com.example.demo.entity.CardInfoEntity;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankAreaCodeService
 * @date 2019/3/27  16:46
 */
public interface BankAreaCodeService extends IService<BankAreaCodeEntity> {
    String getAddressByCode( String code);

    List<BankAreaCodeEntity> lista();

    Integer up();

    List<CardInfoEntity> get();
}
