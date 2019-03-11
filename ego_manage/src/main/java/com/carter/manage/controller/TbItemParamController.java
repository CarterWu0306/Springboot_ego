package com.carter.manage.controller;

import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.commons.pojo.EgoResult;
import com.carter.manage.service.TbItemParamService;
import com.carter.pojo.TbItemParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TbItemParamController {
    @Resource
    private TbItemParamService tbItemParamServiceImpl;

    @RequestMapping("item/param/list")
    @ResponseBody
    public EasyUIDataGrid showPage(int page,int rows){
        return tbItemParamServiceImpl.showPage(page,rows);
    }

    @RequestMapping("item/param/delete")
    @ResponseBody
    public EgoResult delete(String ids){
        EgoResult egoResult = new EgoResult();
        try {
            int index = tbItemParamServiceImpl.delete(ids);
            if (index==1){
                egoResult.setStatus(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            egoResult.setData(e.getMessage());
        }
        return egoResult;
    }

    @RequestMapping("item/param/query/itemcatid/{catId}")
    @ResponseBody
    public EgoResult show(@PathVariable long catId){
        return tbItemParamServiceImpl.showParam(catId);
    }

    @RequestMapping("item/param/save/{catId}")
    @ResponseBody
    public EgoResult save(TbItemParam tbItemParam,@PathVariable long catId){
        return tbItemParamServiceImpl.save(tbItemParam, catId);
    }
}
