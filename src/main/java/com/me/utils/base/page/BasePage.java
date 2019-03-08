package com.me.utils.base.page;


/**
 * 2016-12-28 copy from dmp
 */
public class BasePage<T> {

    /**
     * 默认第一页
     */
    private Integer page = 1;
    /**
     * 默认每页数据量为20
     */
    private Integer pageSize = 20;
    /**
     * 前台要显示的起始数量（后台查询时用）
     */
    private Integer startIndex;
    /**
     * 前台要显示的结束数量（后台查询时用）
     */
    private Integer endIndex;
    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 待定
     **/
    private String order;

    /**
     * 实体
     **/
    private T entity;

    /**
     * 分页导航
     */
    private Pager pager = new Pager();

    /**
     * 获取分页导航
     */
    public Pager getPager() {
        pager.setPageId(getPage());
        pager.setPageSize(getPageSize());
        String orderField = "";
        if (orderBy != null && orderBy.trim().length() > 0) {
            orderField = orderBy;
        }
        if (orderField.trim().length() > 0 && (order != null && order.trim().length() > 0)) {
            orderField += " " + order;
        }
        pager.setOrderField(orderField);
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {

        this.startIndex = ((page - 1) * pageSize + 1);
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = page * pageSize;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
