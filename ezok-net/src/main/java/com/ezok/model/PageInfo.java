package com.ezok.model;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-15
 * Time: 下午10:35
 * To change this template use File | Settings | File Templates.
 */
public class PageInfo {
    //分页基本属性
    private Integer pageNo; //当前页
    private Integer pageSize;//页码
    private Integer count;//总数
    private Integer pageCount; //总页数
    private String pageUrl; //总页数

    //分页显示属性

    private Integer viewMinNo = 1;//分页展示从第几页开始  ，默认1
    private Integer viewMaxNo = 5;//默认5
    //   private int viewPageCount = 5;//底行显示几个数字(viewMinNo+viewPageCount)


    public PageInfo() {
    }

    public PageInfo(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageInfo(Integer pageNo, Integer pageSize, Integer count, String pageUrl) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.pageCount = (count - 1) / pageSize + 1;
        this.pageUrl = pageUrl;

        //如果达不到5页，就以最大页为参考
        if (viewMaxNo > pageCount) {
            viewMaxNo = pageCount;
        } else {
            if (pageNo <= pageCount && pageNo >= viewMaxNo) {
                int a = pageNo + 2;
                if (a <= pageCount) {
                    viewMaxNo = a;
                } else {
                    viewMaxNo = pageCount;
                }
                viewMinNo = viewMaxNo - 4;
                if (viewMinNo < 1) {
                    viewMinNo = 1;
                }


            }
        }


    }

    public Integer getPageNo() {
        if (null == pageNo) {
            pageNo = 1;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        if (null == pageSize) {
            pageSize =5;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getViewMinNo() {
        return viewMinNo;
    }

    public void setViewMinNo(Integer viewMinNo) {
        this.viewMinNo = viewMinNo;
    }

    public Integer getViewMaxNo() {
        return viewMaxNo;
    }

    public void setViewMaxNo(Integer viewMaxNo) {
        this.viewMaxNo = viewMaxNo;
    }


    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
}
