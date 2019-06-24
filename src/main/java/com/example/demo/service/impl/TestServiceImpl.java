package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.config.ActionResult;
import com.example.demo.dao.TestMapper;
import com.example.demo.demo.MenuEntity;
import com.example.demo.demo.MenuRO;
import com.example.demo.entity.SysOrganization;
import com.example.demo.entity.Test;
import com.example.demo.service.TestService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestServiceImpl
 * @date 2019/3/28  14:33
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
    @Override
    public boolean update(Wrapper<Test> updateWrapper) {



        baseMapper.deleteById(1);
        return false;
    }

    @Override
    public List<SysOrganization> getList(String orgParent) {

        List<SysOrganization> list = baseMapper.getList(orgParent);
        List<SysOrganization> result = new ArrayList<>();
        result.addAll(list);
        List<SysOrganization> list1 = baseMapper.getList(list.get(0).getOrgId());
        List<SysOrganization> gh = list1.stream().filter(x ->
                x.getOrgName().contains("市分行")).collect(Collectors.toList());
        gh.stream().forEach( x -> {
            result.add(x);
            List<SysOrganization> list11 = baseMapper.getList(x.getOrgId());
            result.addAll(list11);
        });

        return result;
    }

    @Override
    public ActionResult addMenu(MenuRO ro) {
        MenuEntity entity = new MenuEntity();
        BeanUtils.copyProperties(ro,entity);

        //调用保存的方法
        return null;
    }
}
