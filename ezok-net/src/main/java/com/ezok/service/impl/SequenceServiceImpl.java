/*
 * SequenceServiceImpl.java 
 * Version: 2.01   2014-2-16
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.service.impl;

import com.ezok.mapper.SequenceMapper;
import com.ezok.service.ISequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-16
 */
@Service
public class SequenceServiceImpl implements ISequenceService {
    @Autowired
    SequenceMapper sequenceMapper;


    @Override
    public String getNavNo() {
        return sequenceMapper.getNavNo();
    }

    @Override
    public String getCategoryNo() {
        return sequenceMapper.getCategoryNo();
    }
}
