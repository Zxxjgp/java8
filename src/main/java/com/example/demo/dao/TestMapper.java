package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SysOrganization;
import com.example.demo.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestMapper
 * @date 2019/3/28  14:32
 */
@Mapper
public interface TestMapper extends BaseMapper<Test> {

    @Select("SELECT ORG_ID, ORG_NAME , ORG_PARENT FROM T_SYS_ABIS_ORGANIZATION WHERE ORG_PARENT = #{orgParent}")
    List<SysOrganization> getList(@Param("orgParent") String orgParent);
}
