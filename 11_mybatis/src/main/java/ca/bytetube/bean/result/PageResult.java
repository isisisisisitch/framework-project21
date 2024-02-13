package ca.bytetube.bean.result;

import java.util.List;

public class PageResult<B> {
    private Integer count;
    private List<B> beans;
    private Integer pageSize;
    private Integer pageNo;

    public Integer getPageSize() {
        return Math.max(pageSize == null ? 0 : pageSize, 10);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return Math.max(pageNo == null ? 0 : pageNo, 1);
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPages() {
        int pageSize = getPageSize();
        return (count + pageSize - 1) / pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<B> getBeans() {
        return beans;
    }

    public void setBeans(List<B> beans) {
        this.beans = beans;
    }
}
