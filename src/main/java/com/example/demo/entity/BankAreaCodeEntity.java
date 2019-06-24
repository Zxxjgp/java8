package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName BankAreaCodeEntity
 * @date 2019/3/27  16:42
 */
@Data
@TableName("T_WX_BANK_AREACODE")
public class BankAreaCodeEntity implements Serializable {
    /**
     * 区域号码
     */
    @TableId
    private String proCod;

    /**
     * 地区名称
     */
    private String rpiChaNam;
}
