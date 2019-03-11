package com.carter.dubbo.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.dubbo.service.TbItemDubboService;
import com.carter.mapper.TbItemDescMapper;
import com.carter.mapper.TbItemMapper;
import com.carter.mapper.TbItemParamItemMapper;
import com.carter.pojo.TbItem;
import com.carter.pojo.TbItemDesc;
import com.carter.pojo.TbItemExample;
import com.carter.pojo.TbItemParamItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(interfaceName = "com.carter.dubbo.service.TbItemDubboService")
public class TbItemDubboServiceImpl implements TbItemDubboService {
    @Resource
    private TbItemMapper tbItemMapper;
    @Resource
    private TbItemDescMapper tbItemDescMapper;
    @Resource
    private TbItemParamItemMapper tbItemParamItemMapper;

    @Override
    public EasyUIDataGrid show(int page, int rows) {
        PageHelper.startPage(page, rows);
        //查询全部
        List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());
        //分页代码
        //设置分页条件
        PageInfo<TbItem> pi = new PageInfo<>(list);

        //放入到实体类
        EasyUIDataGrid datagrid = new EasyUIDataGrid();
        datagrid.setRows(pi.getList());
        datagrid.setTotal(pi.getTotal());
        return datagrid;
    }

    @Override
    public int updateItemStatus(TbItem tbItem) {
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    @Override
    public int insTbItem(TbItem tbItem) {
        return tbItemMapper.insert(tbItem);
    }

    //事务回滚
    @Transactional(rollbackFor = java.lang.Exception.class)
    @Override
    public int insTbItemAndDesc(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParamItem) throws Exception {
        int index=0;
        try {
            index = tbItemMapper.insertSelective(tbItem);
            index += tbItemDescMapper.insertSelective(tbItemDesc);
            index += tbItemParamItemMapper.insertSelective(tbItemParamItem);
        } catch (Exception e) {
            e.printStackTrace();
        }if (index==3){
            return 1;
        }else throw new Exception("新增失败,数据还原");
    }
}
