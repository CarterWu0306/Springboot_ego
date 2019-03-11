package com.carter.dubbo.service;

import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.pojo.TbItemParam;

public interface TbItemParamDubboService {
    /**
     * 规格参数查询
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid showPage(int page,int rows);

    /**
     * 规格批量删除
     * @param ids
     * @return
     */
    int delByIds(String ids) throws Exception;

    /**
     * 根据类目ID查询类目模板
     * @param catId
     * @return
     */
    TbItemParam selByCatid(long catId);

    /**
     * 商品类目新增
     * @param tbItemParam
     * @return
     */
    int insParam(TbItemParam tbItemParam);
}
