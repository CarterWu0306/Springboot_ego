package com.carter.dubbo.service;

import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.pojo.TbItem;
import com.carter.pojo.TbItemDesc;
import com.carter.pojo.TbItemParamItem;

public interface TbItemDubboService {
    /**
     * 商品分页查询
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid show(int page,int rows);

    /**
     * 商品状态修改
     * @param tbItem
     * @return
     */
    int updateItemStatus(TbItem tbItem);
    /**
     * 商品新增
     * @param tbItem
     * @return
     */
    int insTbItem(TbItem tbItem);

    /**
     * 新增商品和商品描述
     * @param tbItem
     * @param tbItemDesc
     * @return
     */
    int insTbItemAndDesc(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParamItem) throws Exception;
}
