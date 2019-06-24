package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Test
 * @date 2019/3/28  14:30
 */
@Data
@TableName("T_TEST")
public class Test implements Serializable {

    @TableId(type = IdType.UUID)
    private String id;

    private String name;

    private Date loginDate;

    @TableLogic
    private String isDelete;
}
