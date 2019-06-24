package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.OPLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName LogMapper
 * @date 2019/3/25  18:08
 */
@Mapper
public interface LogMapper extends BaseMapper<OPLogEntity> {


    /**
     * <b>Description:</b>
     * 操作之后放入信息
     * @param: logNo,resCode,resMsg
     * @return: Integer
     * @Auther: jiaoguanping
     * @Date: 2019/3/25 19:47
     */
    @Update("update T_WX_OPLOG set OP_RESULT=#{resCode},BZ=#{resMsg} where LOG_NO=#{logNo}")
    Integer updates(@Param("logNo") String logNo, @Param("resCode") String resCode, @Param("resMsg") String resMsg);
}
