package com.example.demo.demo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName MenuEntity
 * @date 2019/6/12  21:22
 */
@Data
@TableName("T_TEST")
public class MenuEntity {

    private String menuId;
    private String menuName;
    //父级别id
    private String parentId;
}
