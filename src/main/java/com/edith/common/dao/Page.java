package com.edith.common.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName： Page <br>
 * Description：  <br>
 * Copyright © 2019  Inc. All rights reserved. <br>
 * Company：<br>
 *
 * @author 张博能 <br>
 * date 2019/11/18 15:59 <br>
 * @version v1.0 <br>
 **/
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE_SIZE = 20;

    private int pageSize = DEFAULT_PAGE_SIZE;
    private long start;//当前第一条数据再List中的位置
    private List<T> rows;
    private long total;
    private long totalPage;

    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
    }

    public Page(long start, long total, int pageSize, List<T> rows) {
        this.pageSize = pageSize;
        this.start = start;
        this.rows = rows;
        this.total = total;
        this.totalPage=getTotalPageCount();
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
    /**
     * Title：getTotalPageCount <br>
     * Description： 获取总页数<br>
     * author：张博能 <br>
     * date：16:11 2019/11/18 <br>
     * @param
     * @return long<br>
     */
    public long getTotalPageCount() {

        if (total % pageSize == 0) {
            return total / pageSize;
        } else {
            return total / pageSize + 1;
        }
    }
    /**
     * Title：getPageNo <br>
     * Description： 获取该页当前页码<br>
     * author：张博能 <br>
     * date：16:13 2019/11/18 <br>
     * @param
     * @return long<br>
     */
    public long getPageNo() {
        return start / pageSize + 1;
    }
    /**
     * Title：hasNextPage <br>
     * Description： 是否有下一页<br>
     * author：张博能 <br>
     * date：16:14 2019/11/18 <br>
     * @param
     * @return boolean<br>
     */
    public boolean hasNextPage() {
        return this.getPageNo() < this.getTotalPageCount()-1;
    }
    /**
     * Title：hasPreviousPage <br>
     * Description： 是否有上一页<br>
     * author：张博能 <br>
     * date：16:16 2019/11/18 <br>
     * @param
     * @return boolean<br>
     */
    public boolean hasPreviousPage() {
        return this.getPageNo() > 1;
    }
    /**
     * Title：getStartOfPage <br>
     * Description： 获取任意页第一条数据在数据集中的位置,每页条数使用默认值<br>
     * author：张博能 <br>
     * date：16:18 2019/11/18 <br>
     * @param pageNo
     * @return int<br>
     */
    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }
    /**
     * Title：getStartOfPage <br>
     * Description： <br>
     * author：张博能 <br>
     * date：16:19 2019/11/18 <br>
     * @param pageNo
     * @param pageSize
     * @return int<br>
     */
    private static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
}
