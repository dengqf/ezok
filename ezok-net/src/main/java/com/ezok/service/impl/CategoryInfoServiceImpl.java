/*
 * CategoryInfoServiceImpl.java 
 * Version: 2.01   2014-2-16
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.service.impl;

import com.ezok.mapper.CategoryInfoMapper;
import com.ezok.model.CategoryInfo;
import com.ezok.model.CategoryInfoExample;
import com.ezok.model.vo.CategoryListVO;
import com.ezok.service.ICategoryInfoService;
import com.ezok.utils.CateUtil;
import com.ezok.utils.ComparatorCate;
import com.ezok.utils.EzokConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-16
 */
@Service
public class CategoryInfoServiceImpl implements ICategoryInfoService {
    @Autowired
    CategoryInfoMapper categoryInfoMapper;
    @Autowired
    CateUtil cateUtil;

    private String orderSql = "PRIORITY DESC";

    @Override
    public Integer addCategoryInfo(CategoryInfo info) {
        return categoryInfoMapper.insertSelective(info);
    }

    @Override
    public Integer saveCategoryInfo(CategoryInfo info) {
        cateUtil.clear();
        return categoryInfoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public Integer delCategoryInfo(String id) {
        cateUtil.clear();
        return categoryInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryInfo> getAllCategoryInfoList() {
        //todo 暂时不排序
        CategoryInfoExample example = new CategoryInfoExample();
        example.or().andStatusEqualTo(EzokConstant.DEFAULT_STATUS_VALID);
        example.setOrderByClause(orderSql);
        return categoryInfoMapper.selectByExample(example);
    }

    @Override
    public CategoryInfo getCategoryInfoByNo(String no) {
        CategoryInfoExample example = new CategoryInfoExample();
        example.or().andNoEqualTo(no).andStatusEqualTo(EzokConstant.DEFAULT_STATUS_VALID);
        List<CategoryInfo> list = categoryInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public CategoryInfo getCategoryInfoByStruct(String struct) {
        CategoryInfoExample example = new CategoryInfoExample();
        example.or().andStructEqualTo(struct).andStatusEqualTo(EzokConstant.DEFAULT_STATUS_VALID);
        List<CategoryInfo> list = categoryInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Integer getCategoryCountByParentNo(String parentNo) {
        CategoryInfoExample example = new CategoryInfoExample();
        example.or().andParentNoEqualTo(parentNo);
        return categoryInfoMapper.countByExample(example);
    }

    @Override
    public List<CategoryInfo> getCategoryInfoListByParentNo(String parentNo) {
        CategoryInfoExample example = new CategoryInfoExample();
        example.or().andParentNoEqualTo(parentNo).andStatusEqualTo(EzokConstant.DEFAULT_STATUS_VALID);
        example.setOrderByClause(orderSql);
        return categoryInfoMapper.selectByExample(example);
    }

    @Override
    public List<CategoryListVO> getCategoryListVos() {
        List<CategoryListVO> voList = new ArrayList<CategoryListVO>();
        //取得所有有效分类信息

        List<CategoryInfo> list = getAllCategoryInfoList();
        //TODO 暂时不按STRUCT排序，
//        Collections.sort(list, new ComparatorCate());
        //取得所有一级分类
        for (CategoryInfo cate : list) {
            if (cate.getParentNo().equals(EzokConstant.DEFAULT_CATEGORY_PARENTNO)) {
                CategoryListVO vo = new CategoryListVO();
                vo.setCategoryInfo(cate);
                voList.add(vo);
            }
        }
        //循环VO，开始加载子分类 ,虽然多循环，但是可以避免查询数据库，以后可以用REDIS
        for (CategoryListVO vo : voList) {
            String no = vo.getCategoryInfo().getNo();
            for (CategoryInfo cate : list) {
                if (cate.getParentNo().equals(no)) {
                    vo.getChildList().add(cate);
                }
            }
        }
        return voList;
    }
}
