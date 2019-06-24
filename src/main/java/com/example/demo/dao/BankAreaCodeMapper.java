package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.entity.BankAreaCodeEntity;
import com.example.demo.entity.CardInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankAreaCodeMapper
 * @date 2019/3/21  14:03
 */
@Mapper
public interface BankAreaCodeMapper extends BaseMapper<BankAreaCodeEntity> {

    /**
     * 根据地区码得到地区名称
     * @param code
     * @return
     */
    @Select("select RPI_CHA_NAM from T_WX_BANK_AREACODE where PRO_COD=#{code}")
    String getAddressByCode(@Param("code") String code);



    @Select("SELECT * FROM T_WX_CARDINFO")
    List<CardInfoEntity> qryCardInfo();

}
