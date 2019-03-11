package com.carter.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.dubbo.service.TbItemParamDubboService;
import com.carter.mapper.TbItemParamMapper;
import com.carter.pojo.TbItemParam;
import com.carter.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(interfaceName = "com.carter.dubbo.service.TbItemParamDubboService")
public class TbItemParamDubboServiceImpl implements TbItemParamDubboService {
    @Resource
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public EasyUIDataGrid showPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(new TbItemParamExample());
        PageInfo<TbItemParam> pi = new PageInfo<>(list);
        EasyUIDataGrid datagrid = new EasyUIDataGrid();
        datagrid.setRows(pi.getList());
        datagrid.setTotal(pi.getTotal());
        return datagrid;
    }

    //事务回滚
    @Transactional(rollbackFor = java.lang.Exception.class)
    @Override
    public int delByIds(String ids) throws Exception {
        int index = 0;
        String[] idStr = ids.split(",");
        for (String id : idStr) {
            index += tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id));
        }
        if (index==idStr.length){
            return 1;
        }else {
            throw new Exception("规格删除失败,数据可能不存在");
        }
    }

    @Override
    public TbItemParam selByCatid(long catId) {
        TbItemParamExample example = new TbItemParamExample();
        example.createCriteria().andItemCatIdEqualTo(catId);
        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insParam(TbItemParam tbItemParam) {
        return tbItemParamMapper.insertSelective(tbItemParam);
    }
}
