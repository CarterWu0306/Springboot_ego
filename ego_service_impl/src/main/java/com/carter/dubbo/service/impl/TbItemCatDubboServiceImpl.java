package com.carter.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.carter.dubbo.service.TbItemCatDubboService;
import com.carter.mapper.TbItemCatMapper;
import com.carter.pojo.TbItemCat;
import com.carter.pojo.TbItemCatExample;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbItemCatDubboServiceImpl implements TbItemCatDubboService {
    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> show(long pid) {
        TbItemCatExample example =new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo(pid);
        return tbItemCatMapper.selectByExample(example);
    }

    @Override
    public TbItemCat selById(long id) {
        return tbItemCatMapper.selectByPrimaryKey(id);
    }
}
