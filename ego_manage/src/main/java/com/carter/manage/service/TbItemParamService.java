package com.carter.manage.service;

import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.commons.pojo.EgoResult;
import com.carter.pojo.TbItemParam;

public interface TbItemParamService {
    /**
     * 分页显示商品规格参数
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
    int delete(String ids) throws Exception;

    /**
     * 根据类目ID查询模板信息
     * @param catId
     * @return
     */
    EgoResult showParam(long catId);

    /**
     * 商品类目新增
     * @param tbItemParam
     * @return
     */
    EgoResult save(TbItemParam tbItemParam,long catId);
}
