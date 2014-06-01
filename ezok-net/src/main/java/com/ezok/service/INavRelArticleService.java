package com.ezok.service;

import com.ezok.model.NavRelArticle;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavRelArticleVO;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-4-17
 * Time: 下午10:58
 * To change this template use File | Settings | File Templates.
 */
public interface INavRelArticleService  {

    public Integer insert(NavRelArticle navRelArticle);

    public Integer save(NavRelArticle navRelArticle);

    public NavRelArticle getNavRelArticleByNavInfoId(String navInfoId);

    NavRelArticleVO getNavRelArticleVo(PageInfo pageInfo);

}
