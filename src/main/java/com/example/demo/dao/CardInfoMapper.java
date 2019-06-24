package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.BankLoanEntity;
import com.example.demo.entity.CardBindEntity;
import com.example.demo.entity.CardInfoEntity;
import com.example.demo.entity.CustInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CardInfoMapper
 * @date 2019/3/22  16:30
 */
@Mapper
public interface CardInfoMapper  extends BaseMapper<BankLoanEntity> {

    @Select("SELECT * FROM T_WX_CARDBIND WHERE CARDNO=#{accNo}")
    @Results(id = "CardBindMapId",value = {
            @Result(column = "USERID",property = "userId"),
            @Result(column = "CUSTNO",property = "custNo"),
            @Result(column = "CARDNO",property = "cardNo"),
            @Result(column = "CARDTYPE",property = "cardType"),
            @Result(column = "AREACODE",property = "areaCode"),
            @Result(column = "BRANCH",property = "branch"),
            @Result(column = "TELNO",property = "telNo"),
            @Result(column = "BINDDATE",property = "bindDate"),
            @Result(column = "BINDTIME",property = "bindTime"),
            @Result(column = "MAINCARD",property = "mainCard"),
            @Result(column = "CERTID",property = "certId"),
            @Result(column = "UNBINDDATE",property = "unBindDate"),
            @Result(column = "UNBINDTIME",property = "unBindTime"),
            @Result(column = "BINDENTRY",property = "bindEntry"),
            @Result(column = "BZ",property = "bz"),
            @Result(column = "ABCFLAG",property = "abcFlag"),
            @Result(column = "ALIAS",property = "alias")
    })

    CardBindEntity qryCardBind(@Param(value = "accNo") String accNo);

    @Select("SELECT wc.USER_ID, wc.CUST_NO, wc.CARD_NO, wc.CARD_TYPE , wc.BRANCH, wc.CERT_ID FROM  T_WX_CARDBIND wc LEFT JOIN T_WX_USER wu ON wc.USER_ID = wu.USERID WHERE wc.ABC_FLAG = 'Y' AND wc.CARD_TYPE = #{ cardType } AND wu.OPENID = #{openId} AND wc.UNBIND_DATE is NULL ")
    List<CardBindEntity> cardList(@Param("openId") String openId, @Param("cardType") String cardType);

    @Select("SELECT wc.USER_ID, wc.CUST_NO, wc.CARD_NO, wc.CARD_TYPE , wc.BRANCH, wc.CERT_ID FROM T_WX_CARDBIND wc WHERE wc.USER_ID = #{ userId } ")
    List<CardBindEntity> getCardById ( @Param(value = "userId") String userId );


    @Select("SELECT * FROM T_WX_CUSTINFO WHERE USERID = #{userId} ")
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
