package com.ezok.model.vo;

import com.ezok.model.NavInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-15
 * Time: 下午10:26
 * To change this template use File | Settings | File Templates.
 */
public class NavInfoVO extends VoObject {

    public NavInfoVO(int count, List<NavInfo> navInfoList) {
        super(count);
        this.navInfoList = navInfoList;
    }

    private List<NavInfo> navInfoList;

    public List<NavInfo> getNavInfoList() {
        return navInfoList;
    }

    public void setNavInfoList(List<NavInfo> navInfoList) {
        this.navInfoList = navInfoList;
    }
}
