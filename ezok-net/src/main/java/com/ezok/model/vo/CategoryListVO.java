/*
 * CategorListVO.java 
 * Version: 2.01   2014-2-18
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.model.vo;

import com.ezok.model.CategoryInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-18
 */
public class CategoryListVO {
    CategoryInfo categoryInfo;
    List<CategoryInfo> childList=new ArrayList<CategoryInfo>();

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public List<CategoryInfo> getChildList() {
        return childList;
    }

    public void setChildList(List<CategoryInfo> childList) {
        this.childList = childList;
    }
}
