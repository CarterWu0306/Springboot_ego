package com.carter.manage.controller;

import com.carter.commons.pojo.EasyUIDataGrid;
import com.carter.commons.pojo.EgoResult;
import com.carter.manage.service.TbItemService;
import com.carter.pojo.TbItem;
import com.carter.pojo.TbItemDesc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TbItemController {
    @Resource
    private TbItemService tbItemServiceImpl;


    /**
     * 分页显示商品
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("item/list")
    @ResponseBody
    public EasyUIDataGrid show(int page, int rows){
        return tbItemServiceImpl.show(page, rows);
    }

    /**
     * 显示商品修改
     * @return
     */
    @RequestMapping("rest/page/item-edit")
    public String showItemEdit(){
        return "item-edit";
    }

    /**
     * 商品删除
     * @param ids
     * @return
     */
    @RequestMapping("rest/item/delete")
    @ResponseBody
    public EgoResult delete(String ids){
        EgoResult egoResult = new EgoResult();
        int index = tbItemServiceImpl.update(ids, (byte) 3);
        if (index==1){
            egoResult.setStatus(200);
        }
        return egoResult;
    }

    /**
     * 商品下架
     * @param ids
     * @return
     */
    @RequestMapping("rest/item/instock")
    @ResponseBody
    public EgoResult instock(String ids){
        EgoResult egoResult = new EgoResult();
        int index = tbItemServiceImpl.update(ids, (byte) 2);
        if (index==1){
            egoResult.setStatus(200);
        }
        return egoResult;
    }

    /**
     * 商品上架
     * @param ids
     * @return
     */
    @RequestMapping("rest/item/reshelf")
    @ResponseBody
    public EgoResult reshelf(String ids){
        EgoResult egoResult = new EgoResult();
        int index = tbItemServiceImpl.update(ids, (byte) 1);
        if (index==1){
            egoResult.setStatus(200);
        }
        return egoResult;
    }

    /***
     * 商品新增
     * @return
     *
     */
    @RequestMapping("item/save")
    @ResponseBody
    public EgoResult save(TbItem tbItem, String desc,String itemParams){
        EgoResult egoResult = new EgoResult();
        int index;
        try {
            index = tbItemServiceImpl.save(tbItem, desc,itemParams);
            System.out.println("controler:index:"+index);
            if(index==1){
                egoResult.setStatus(200);
            }
        } catch (Exception e) {
//			e.printStackTrace();
            egoResult.setData(e.getMessage());
        }
        return egoResult;
    }
}
