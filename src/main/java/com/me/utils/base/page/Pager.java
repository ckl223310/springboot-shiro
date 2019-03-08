package com.me.utils.base.page;

/**
 * 2016-12-28 copy from dmp
 */

/**
 * 分页参数
 *
 * @version 2.0
 */
// oracle,sqlserver,mysql分页技术
public class Pager {
    /**
     * 当前页
     */
    private int pageId = 1;
    /**
     * 总行数
     */
    private Long rowCount = 0L;
    /**
     * 页大小
     */
    private int pageSize = 10;
    /**
     * 总页数
     */
    private int pageCount = 0;
    /**
     * 当前页起始记录
     */
    private int pageOffset = 0;
    /**
     * 当前页到达的记录
     */
    private int pageTail = 0;
    /**
     * 排序字段
     */
    private String orderField;
    /**
     * 是否排序
     */
    private boolean orderDirection;
    /**
     * 是否分页
     */
    private boolean pageEnabled;



    /**
     * 页面显示分页按钮个数
     */
    private int length = 6;

    /**
     * 开始分页数字
     */
    private int startIndex = 0;
    /**
     * 结束分页数字
     */
    private int endIndex = 0;
    /**
     * indexs
     */
    private int[] indexs;

    public Pager() {
        this.orderDirection = true;
        this.pageEnabled = true;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 获取每页的长度
     * @return
     */
    public int[] getIndexs() {
        int len = getEndIndex() - getStartIndex() + 1;
        indexs = new int[len];
        for (int i = 0; i < len; i++) {
            indexs[i] = (getStartIndex() + i);
        }
        return indexs;
    }

    /**
     * setIndexs
     * @param indexs
     */
    public void setIndexs(int[] indexs) {
        this.indexs = indexs;
    }

    /**
     * getStartIndex
     * @return
     */
    public int getStartIndex() {
        startIndex = (pageId - 1) * pageSize + 1;
        return startIndex;
    }

    /**
     * setStartIndex
     * @param startIndex
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = (pageId - 1) * pageSize + 1;
    }

    /**
     * getEndIndex
     * @return
     */
    public int getEndIndex() {
        endIndex = (pageId * pageSize);
        return endIndex;
    }

    public void setEndIndex(int endIndex) {

        this.endIndex = pageId * pageSize;
    }

    /**
     * doPage
     */
    protected void doPage() {
        this.pageCount = this.rowCount.intValue() / this.pageSize + 1;
        // 如果模板==0，且总数大于1，则减一
        if ((this.rowCount % this.pageSize == 0) && pageCount > 1) {
            this.pageCount--;
        }

        // Mysql 算法
        this.pageOffset = (this.pageId - 1) * this.pageSize;
        this.pageTail = this.pageOffset + this.pageSize;
        if ((this.pageOffset + this.pageSize) > this.rowCount) {
            this.pageTail = this.rowCount.intValue();
        }
    }

    /**
     * getOrderCondition
     */
    public String getOrderCondition() {
        String condition = "";
        if (this.orderField != null && this.orderField.length() != 0) {
            condition = " order by " + orderField + (orderDirection ? " " : " desc ");
        }
        return condition;
    }

    /**
     * getMysqlQueryCondition
     * @return
     */
    public String getMysqlQueryCondition() {
        String condition = "";
        if (this.pageEnabled) {
//            condition = " limit " + pageOffset + "," + pageSize;
        }
        return condition;
    }

    public void setOrderDirection(boolean orderDirection) {
        this.orderDirection = orderDirection;
    }

    public boolean isOrderDirection() {
        return orderDirection;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageTail(int pageTail) {
        this.pageTail = pageTail;
    }

    public int getPageTail() {
        return pageTail;
    }

    /**
     * setRowCount
     * @param rowCount
     */
    public void setRowCount(Long rowCount) {
        this.rowCount = rowCount;
        this.doPage();
    }

    public int getRowCount() {
        return rowCount.intValue();
    }

    public boolean isPageEnabled() {
        return pageEnabled;
    }

    public void setPageEnabled(boolean pageEnabled) {
        this.pageEnabled = pageEnabled;
    }

}
