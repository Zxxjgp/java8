package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.CardBindEntity;
import com.example.demo.entity.CardInfoEntity;
import com.example.demo.entity.CustInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CustInfoMapper
 * @date 2019/3/21  10:22
 */
@Mapper
public interface CustInfoMapper extends BaseMapper<CustInfoEntity> {
    @Select("SELECT * FROM T_WX_CUSTINFO WHERE USERID=#{userId}")
    @Results(id = "CustInfoMap",value = {
            @Result(property = "userId",column = "USERID"),
            @Result(property = "custNo",column = "CUSTNO"),
            @Result(property = "certId",column = "CERTID"),
            @Result(property = "custName",column = "CUSTNAME"),
            @Result(property = "regAreaCode",column = "REGAREACODE"),
            @Result(property = "regEntry",column = "REGENTRY"),
            @Result(property = "regDate",column = "REGDATE"),
            @Result(property = "regTime",column = "REGTIME"),
            @Result(property = "cardNo",column = "CARDNO"),
            @Result(property = "telNo",column = "TELNO"),
            @Result(property = "branch",column = "BRANCH"),
            @Result(property = "unRegDate",column = "UNREGDATE"),
            @Result(property = "unRegTime",column = "UNREGTIME"),
            @Result(property = "bz",column = "BZ")
    })
    CustInfoEntity queryCustInfoByUserId(@Param("userId") String userId);

    @Select("SELECT * FROM T_WX_CARDINFO")
    List<CardInfoEntity> qryCardInfo();

    @Select("SELECT wc.USER_ID, wc.CUST_NO, wc.CARD_NO, wc.CARD_TYPE, wc.BRANCH, wc.CERT_ID " +
            "FROM T_WX_CARDBIND wc " +
            "LEFT JOIN T_WX_USER wu ON wc.USER_ID = wu.USER_ID " +
            "WHERE wc.ABC_FLAG = 'Y' AND wu.OPEN_ID = #{openId} AND wc.UNBIND_DATE is NULL")
    List<CardBindEntity> cardList(@Param("openId") String openId);
}
