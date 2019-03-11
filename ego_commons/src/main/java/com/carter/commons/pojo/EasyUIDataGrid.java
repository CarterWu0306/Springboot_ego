package com.carter.commons.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIDataGrid implements Serializable {
    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    //当前页显示数据
    private List<?> rows;
    //总条数
    private long total;
}