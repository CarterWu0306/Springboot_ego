package com.carter.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.carter.commons.pojo.EasyUIDataGrid;

import com.carter.commons.utils.IDUtils;
import com.carter.dubbo.service.TbItemDescDubboService;
import com.carter.dubbo.service.TbItemDubboService;
import com.carter.manage.service.TbItemService;
import com.carter.pojo.TbItem;
import com.carter.pojo.TbItemDesc;
import com.carter.pojo.TbItemParamItem;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TbItemServiceImpl implements TbItemService {
    @Reference
    private TbItemDubboService tbItemDubboServiceImpl;
    @Reference
    private TbItemDescDubboService tbItemDescDubboServiceImpl;

    @Override
    public EasyUIDataGrid show(int page, int rows) {
        return tbItemDubboServiceImpl.show(page,rows);
    }

    @Override
    public int update(String ids, byte status) {
        int index=0;
        TbItem tbItem = new TbItem();
        String[] idsStr = ids.split(",");
        for (String id:idsStr) {
            tbItem.setId(Long.parseLong(id));
            tbItem.setStatus(status);
            index += tbItemDubboServiceImpl.updateItemStatus(tbItem);
        }
        if(index==idsStr.length){
            return 1;
        }
        return 0;
    }

    @Override
    public int save(TbItem item, String desc,String itemParams) throws Exception {
        long id = IDUtils.genItemId();
        item.setId(id);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        item.setStatus((byte)1);

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(id);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);

        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setItemId(id);
        tbItemParamItem.setCreated(date);
        tbItemParamItem.setUpdated(date);

        int index=0;
        index = tbItemDubboServiceImpl.insTbItemAndDesc(item,itemDesc,tbItemParamItem);
        System.out.println("index:" + index);
        return index;
    }
}
