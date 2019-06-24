package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.config.ActionResult;
import com.example.demo.demo.MenuRO;
import com.example.demo.entity.SysOrganization;
import com.example.demo.entity.Test;

import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestService
 * @date 2019/3/28  14:33
 */
public interface TestService extends IService<Test> {

    List<SysOrganization> getList(String orgParent);

    ActionResult addMenu(MenuRO ro );
}
