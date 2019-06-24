package com.example.demo.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName
 * @date 2019/6/12  21:20
 */
@Data
public class MenuRO implements Serializable {

    //菜单名称
    private String menuName;
    //父级别id
    private String parentId;

    //菜单的等级
    private Integer lever;
}
