package com.ezok.service.impl;

import com.ezok.mapper.NavInfoMapper;
import com.ezok.model.NavInfo;
import com.ezok.model.NavInfoExample;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavInfoVO;
import com.ezok.service.INavInfoService;
import com.ezok.utils.CommonUtil;
import com.ezok.utils.EzokConstant;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-15
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
@Service
public class NavInfoServiceImpl implements INavInfoService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    NavInfoMapper navInfoMapper;
    String orderSql="PRIORITY DESC";

    @Override
    public Integer addNavInfo(NavInfo navInfo) {
        return navInfoMapper.insertSelective(navInfo);
    }

    @Override
    public Integer saveNavInfo(NavInfo navInfo) {
        return navInfoMapper.updateByPrimaryKeySelective(navInfo);
    }

    @Override
    public NavInfoVO getNavInfoVo(String categoryNo, PageInfo pageInfo) {
        NavInfoExample example = new NavInfoExample();
        example.or().andCategoryNoEqualTo(categoryNo).andStatusEqualTo(EzokConstant.DEFAULT_STATUS_VALID);
        Integer count = pageInfo.getCount();
        if (null == pageInfo.getCount()) {
            //取总数
            count = navInfoMapper.countByExample(example);
        }
        example.setOrderByClause(orderSql);
        RowBounds rowBounds = CommonUtil.getRowBoundsByPageInfo(pageInfo);
        List<NavInfo> list = navInfoMapper.selectByExample(example, rowBounds);
        return new NavInfoVO(count, list);
    }

    @Override
    public NavInfoVO getNavInfoVoByParentCate(String categoryNo, PageInfo pageInfo) {
        RowBounds rowBounds = CommonUtil.getRowBoundsByPageInfo(pageInfo);
        Integer count = pageInfo.getCount();
        if (null == pageInfo.getCount()) {
            //取总数
            count = navInfoMapper.countNavInfoVoByParentCate(categoryNo);
        }
        List<NavInfo> list = navInfoMapper.getNavInfoVoByParentCate(categoryNo, rowBounds);
        return new NavInfoVO(count, list);
    }

    @Override
    public NavInfoVO getNavInfoVo(NavInfo navInfo, PageInfo pageInfo) {
        NavInfoExample example = new NavInfoExample();
        NavInfoExample.Criteria criteria = example.or();
        if (StringUtils.isNotBlank(navInfo.getName())) {
            String name = "%" + navInfo.getName() + "%";
            criteria.andNameLike(name);
        }
        if (StringUtils.isNotBlank(navInfo.getWeixinAccount())) {
            criteria.andWeixinAccountEqualTo(navInfo.getWeixinAccount());
        }

        if (StringUtils.isNotBlank(navInfo.getUsername())) {
            criteria.andUsernameEqualTo(navInfo.getUsername());
        }

        if (StringUtils.isNotBlank(navInfo.getWeixinName())) {
            criteria.andWeixinNameEqualTo(navInfo.getWeixinName());
        }

        if (StringUtils.isNotBlank(navInfo.getYixinAccount())) {
            criteria.andYixinAccountEqualTo(navInfo.getYixinAccount());
        }

        if (StringUtils.isNotBlank(navInfo.getYixinName())) {
            criteria.andYixinNameEqualTo(navInfo.getYixinName());
        }

        if (StringUtils.isNotBlank(navInfo.getCategoryNo())) {
            criteria.andCategoryNoEqualTo(navInfo.getCategoryNo());
        }
        String province = navInfo.getProvince();
        String city = navInfo.getCity();
        if (StringUtils.isNotBlank(province) && !province.contains("选择")) {
            logger.info("搜索选择的省份:{}", province);
            criteria.andProvinceEqualTo(province);
        }

        if (StringUtils.isNotBlank(city) && !city.contains("选择")) {
            logger.info("搜索选择的城市:{}", city);
            criteria.andCityEqualTo(city);
        }
        if (null != navInfo.getStatus()) {
            criteria.andStatusEqualTo(navInfo.getStatus());
        }
        //todo 暂时屏蔽
        example.setOrderByClause("CREATE_DATE DESC");
        Integer count = pageInfo.getCount();
        if (null == pageInfo.getCount()) {
            //取总数
            count = navInfoMapper.countByExample(example);
        }
        RowBounds rowBounds = CommonUtil.getRowBoundsByPageInfo(pageInfo);
        List<NavInfo> list = navInfoMapper.selectByExample(example, rowBounds);
        return new NavInfoVO(count, list);

    }

    @Override
    public NavInfo getNavInfoByNo(String no) {
        NavInfoExample example = new NavInfoExample();
        example.or().andNoEqualTo(no);
        List<NavInfo> list = navInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public NavInfo getNavInfoById(String id) {
        return navInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public NavInfo getNavInfoByWeixinAccount(String account) {
        NavInfoExample example = new NavInfoExample();
        example.or().andWeixinAccountEqualTo(account);
        List<NavInfo> list = navInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Integer updateStatusForNav(String[] nos, NavInfo info) {
        List<String> noList = new ArrayList<String>();
        Collections.addAll(noList, nos);
        NavInfoExample example = new NavInfoExample();
        example.or().andNoIn(noList);
        info.setUpdateDate(new Date());
        return navInfoMapper.updateByExampleSelective(info, example);

    }

    @Override
    public List<NavInfo> getLikeNavInfoList(NavInfo navInfo) {
        NavInfoExample example = new NavInfoExample();
        example.or().andCategoryNoEqualTo(navInfo.getCategoryNo()).andNoNotEqualTo(navInfo.getNo()).andStatusEqualTo(EzokConstant.DEFAULT_STATUS_VALID);
        example.setOrderByClause(orderSql);
        RowBounds rowBounds=new RowBounds(0,6);
        return navInfoMapper.selectByExample(example,rowBounds);

    }

    @Override
    public List<NavInfo> getSiteMapList(Date startDate, Date endDate) {
        NavInfoExample example = new NavInfoExample();
        example.or().andStatusEqualTo(EzokConstant.DEFAULT_STATUS_VALID).andUpdateDateBetween(startDate,endDate);
        return navInfoMapper.selectByExample(example);
    }
}
