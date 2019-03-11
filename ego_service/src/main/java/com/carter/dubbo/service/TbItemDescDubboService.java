package com.carter.dubbo.service;


import com.carter.pojo.TbItemDesc;

public interface TbItemDescDubboService {
    /**
     * 新增商品描述
     * @param tbItemDesc
     * @return
     */
    int insDesc(TbItemDesc tbItemDesc);
}
