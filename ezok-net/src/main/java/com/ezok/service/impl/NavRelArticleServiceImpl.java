package com.ezok.service.impl;

import com.ezok.mapper.NavRelArticleMapper;
import com.ezok.model.NavRelArticle;
import com.ezok.model.NavRelArticleExample;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavRelArticleVO;
import com.ezok.service.INavRelArticleService;
import com.ezok.utils.CommonUtil;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-4-17
 * Time: 下午11:03
 * To change this template use File | Settings | File Templates.
 */
@Service
public class NavRelArticleServiceImpl implements INavRelArticleService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    NavRelArticleMapper navRelArticleMapper;
    @Override
    public Integer insert(NavRelArticle navRelArticle) {
        return navRelArticleMapper.insertSelective(navRelArticle);
    }

    @Override
    public Integer save(NavRelArticle navRelArticle) {
        return navRelArticleMapper.updateByPrimaryKeySelective(navRelArticle);
    }

    @Override
    public NavRelArticle getNavRelArticleByNavInfoId(String navInfoId) {
        NavRelArticleExample example=new NavRelArticleExample();
        example.or().andNavInfoIdEqualTo(navInfoId);
        List<NavRelArticle> list=navRelArticleMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public NavRelArticleVO getNavRelArticleVo(PageInfo pageInfo) {
        NavRelArticleExample example=new NavRelArticleExample();
        RowBounds rowBounds = CommonUtil.getRowBoundsByPageInfo(pageInfo);
        Integer count = pageInfo.getCount();
        if (null == pageInfo.getCount()) {
            //取总数
            count = navRelArticleMapper.countByExample(example);
        }
        List<NavRelArticle> list=navRelArticleMapper.selectByExample(example);
        return new NavRelArticleVO(count,list);
    }
}
