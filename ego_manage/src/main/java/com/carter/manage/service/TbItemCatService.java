package com.carter.manage.service;

import com.carter.commons.pojo.EasyUiTree;

import java.util.List;

public interface TbItemCatService {
    /**
     * 根据父菜单id显示所有子菜单
     * @param pid
     * @return
     */
    List<EasyUiTree> show(long pid);
}
