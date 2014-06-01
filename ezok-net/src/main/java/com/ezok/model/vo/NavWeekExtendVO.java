package com.ezok.model.vo;

import com.ezok.model.NavWeekExtend;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-26
 * Time: 下午6:15
 * To change this template use File | Settings | File Templates.
 */
public class NavWeekExtendVO extends VoObject {
    public NavWeekExtendVO(int count, List<NavWeekExtend> list) {
        super(count);
        this.list = list;
    }

    List<NavWeekExtend>  list;

    public List<NavWeekExtend> getList() {
        return list;
    }

    public void setList(List<NavWeekExtend> list) {
        this.list = list;
    }
}
