package com.carter.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.commons.pojo.EgoResult;
import com.carter.dubbo.service.TbItemCatDubboService;
import com.carter.dubbo.service.TbItemParamDubboService;
import com.carter.manage.pojo.TbItemParamChild;
import com.carter.manage.service.TbItemParamService;
import com.carter.pojo.TbItemParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {
    @Reference
    private TbItemParamDubboService tbItemParamDubboServiceImpl;
    @Reference
    private TbItemCatDubboService tbItemCatDubboServiceImpl;

    @Override
    public EasyUIDataGrid showPage(int page, int rows) {
        EasyUIDataGrid dataGrid = tbItemParamDubboServiceImpl.showPage(page,rows);
        List<TbItemParam> list = (List<TbItemParam>)dataGrid.getRows();
        List<TbItemParamChild> listChild = new ArrayList<>();
        for (TbItemParam param : list) {
            TbItemParamChild child = new TbItemParamChild();

            child.setCreated(param.getCreated());
            child.setId(param.getId());
            child.setItemCatId(param.getItemCatId());
            child.setParamData(param.getParamData());
            child.setUpdated(param.getUpdated());
            child.setItemCatName(tbItemCatDubboServiceImpl.selById(child.getItemCatId()).getName());

            listChild.add(child);
        }
        dataGrid.setRows(listChild);
        return dataGrid;
    }

    @Override
    public int delete(String ids) throws Exception {
        return tbItemParamDubboServiceImpl.delByIds(ids);
    }

    @Override
    public EgoResult showParam(long catId) {
        EgoResult egoResult = new EgoResult();
        TbItemParam tbItemParam = tbItemParamDubboServiceImpl.selByCatid(catId);
        if (tbItemParam!=null){
            egoResult.setStatus(200);
            egoResult.setData(tbItemParam);
        }
        return egoResult;
    }

    @Override
    public EgoResult save(TbItemParam tbItemParam,long catId) {
        EgoResult egoResult = new EgoResult();
        Date date = new Date();
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);
        tbItemParam.setItemCatId(catId);
        int index = tbItemParamDubboServiceImpl.insParam(tbItemParam);
        if (index>0){
            egoResult.setStatus(200);
        }
        return egoResult;
    }
}
