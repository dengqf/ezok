package com.ezok.model.vo;

import com.ezok.model.NavWeek;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-26
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public class NavWeekVO extends VoObject {
    public NavWeekVO(int count, List<NavWeek> navWeekList) {
        super(count);
        this.navWeekList = navWeekList;
    }

    private List<NavWeek> navWeekList;

    public List<NavWeek> getNavWeekList() {
        return navWeekList;
    }

    public void setNavWeekList(List<NavWeek> navWeekList) {
        this.navWeekList = navWeekList;
    }
}
