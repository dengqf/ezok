/*
 * SequenceMapper.java
 * Version: 2.01   2014-2-16
 *  
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.mapper;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-16
 */
public interface SequenceMapper {
    /**
     * 生成导航信息NO
     *
     * @return
     */
    String getNavNo();

    /**
     * 得到分类信息
     *
     * @return
     */
    String getCategoryNo();
}
