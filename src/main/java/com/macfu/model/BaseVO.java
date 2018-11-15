package com.macfu.model;

/**
 * @Author: liming
 * @Date: 2018/11/14 16:41
 * @Description:
 */
public class BaseVO {
    private int pageSize = 1;
    private int pageNumber = 20;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 100) {
            pageSize = 100;
        } else {
            pageSize = pageSize;
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
