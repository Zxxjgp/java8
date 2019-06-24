package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName SysOrganization
 * @date 2019/4/7  16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysOrganization implements Serializable {
    private String orgId;
    private String orgName;
    private String orgParent;
}
