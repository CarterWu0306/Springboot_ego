package com.carter.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.carter.dubbo.service.TbItemDescDubboService;
import com.carter.mapper.TbItemDescMapper;
import com.carter.pojo.TbItemDesc;

import javax.annotation.Resource;

@Service
public class TbItemDescDubboServiceImpl implements TbItemDescDubboService {
    @Resource
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public int insDesc(TbItemDesc tbItemDesc) {
        return tbItemDescMapper.insert(tbItemDesc);
    }
}
