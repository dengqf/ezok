package com.ezok.model.vo;

import com.ezok.model.NavRelArticle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-4-17
 * Time: 下午11:00
 * To change this template use File | Settings | File Templates.
 */
public class NavRelArticleVO extends VoObject {

    public NavRelArticleVO(int count, List<NavRelArticle> navRelArticleList) {
        super(count);
        this.navRelArticleList = navRelArticleList;
    }

    private List<NavRelArticle> navRelArticleList;

    public List<NavRelArticle> getNavRelArticleList() {
        return navRelArticleList;
    }

    public void setNavRelArticleList(List<NavRelArticle> navRelArticleList) {
        this.navRelArticleList = navRelArticleList;
    }
}
