/*
 * ICategoryInfoService.java
 * Version: 2.01   2014-2-16
 *  
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.service;

import com.ezok.model.CategoryInfo;
import com.ezok.model.vo.CategoryListVO;

import java.util.List;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-16
 */
public interface ICategoryInfoService {

    Integer addCategoryInfo(CategoryInfo info);

    Integer saveCategoryInfo(CategoryInfo info);

    Integer delCategoryInfo(String id);

    List<CategoryInfo> getAllCategoryInfoList();

    CategoryInfo getCategoryInfoByNo(String no);

    CategoryInfo getCategoryInfoByStruct(String struct);

    /**
     * 根据父NO得到总数
     *
     * @param parentNo 父NO
     * @return 总数
     */
    Integer getCategoryCountByParentNo(String parentNo);

    /**
     * 根据父分类NO得到所有父分类下的子分类
     *
     * @param parentNo 父分类NO
     * @return List<CategoryInfo>
     */
    List<CategoryInfo> getCategoryInfoListByParentNo(String parentNo);

    /**
     * 得到分类信息及子分类
     *
     * @return CategoryListVO
     */
    List<CategoryListVO> getCategoryListVos();

}
