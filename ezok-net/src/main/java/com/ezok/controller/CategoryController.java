/*
 * CategoryController.java 
 * Version: 2.01   2014-2-16
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.controller;

import com.app.tools.UUIDGenerator;
import com.ezok.model.CategoryInfo;
import com.ezok.model.NavInfo;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.CategoryListVO;
import com.ezok.model.vo.NavInfoVO;
import com.ezok.service.ICategoryInfoService;
import com.ezok.service.INavInfoService;
import com.ezok.service.ISequenceService;
import com.ezok.utils.CateUtil;
import com.ezok.utils.EzokConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-16
 */
@Controller
public class CategoryController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ISequenceService sequenceService;
    @Autowired
    ICategoryInfoService categoryInfoService;


    @Autowired
    INavInfoService navInfoService;

    //添加分类
    @RequestMapping(value = "admin/admin_cate_toAdd.html", method = RequestMethod.GET)
    public String categoryToAdd(ModelMap map) {
        //取得所有一级分类
        List<CategoryInfo> list = categoryInfoService.getCategoryInfoListByParentNo(EzokConstant.DEFAULT_CATEGORY_PARENTNO);
        map.put("list", list);
        return "admin/admin_cate_add";
    }

    //添加分类
    @RequestMapping(value = "admin/admin_cate_update.html", method = RequestMethod.GET)
    public String categoryToUpdate(String no, ModelMap map) {
        CategoryInfo info = categoryInfoService.getCategoryInfoByNo(no);
        if (null == info) {
            map.put(EzokConstant.ERROR, "分类不存在");
            return "admin/admin_info_error";
        }
        List<CategoryInfo> list = categoryInfoService.getCategoryInfoListByParentNo(EzokConstant.DEFAULT_CATEGORY_PARENTNO);
        map.put("list", list);
        map.put("cate", info);
        return "admin/admin_cate_update";
    }
//    admin_cate_update.html

    @RequestMapping(value = "admin/admin_cate_updateSubmit.html")
    @Transactional
    public String categoryUpdate(CategoryInfo cateInfo, ModelMap map) {
        String no = cateInfo.getNo();
        CategoryInfo info = categoryInfoService.getCategoryInfoByNo(no);
        if (null == info) {
            map.put(EzokConstant.ERROR, "分类不存在");
            return "admin/admin_info_error";
        }
        if (null != cateInfo.getPriority()) {
            info.setPriority(cateInfo.getPriority());
        }
        String _name = cateInfo.getName();
        if (StringUtils.isBlank(_name)) {
            map.put(EzokConstant.ERROR, "分类名称不能为空");
            return "admin/admin_info_error";
        }
        if (info.getParentNo().equals(EzokConstant.DEFAULT_CATEGORY_PARENTNO)) {
            //修改的分类是第一级分类，只需要看名字

            //名字有值，判断是否修改过
            if (!StringUtils.equals(info.getName(), _name)) {
                logger.info("分类名称有修改，需要修改子分类的STRUCT_NAME");
                info.setName(_name);
                info.setStructName(_name);
                List<CategoryInfo> list = categoryInfoService.getCategoryInfoListByParentNo(no);
                for (CategoryInfo cate : list) {
                    cate.setStructName(_name + "-" + cate.getName());
                    categoryInfoService.saveCategoryInfo(cate);
                }
            }
            categoryInfoService.saveCategoryInfo(info);
        } else {
            //如果是二级分类 ，判断父分类是否有更换
            //判断名字是否有变动
            if (!StringUtils.equals(info.getName(), _name)) {
                info.setName(_name);
                //修改STRUCT_NAME
                CategoryInfo oldParent = categoryInfoService.getCategoryInfoByNo(info.getParentNo());
                if (oldParent == null) {
                    map.put(EzokConstant.ERROR, "数据错误,父分类不存在");
                    return "admin/admin_info_error";
                }
                info.setStructName(oldParent.getName() + "-" + info.getName());
            }

            String parentNo = cateInfo.getParentNo();
            if (StringUtils.isNotBlank(parentNo)) {
                //父分类NO不为空
                logger.info("父分类NO不为空:{}", parentNo);
                if (!StringUtils.equals(info.getParentNo(), parentNo)) {
                    logger.info("父分类NO:{}有变动，新NO:{}", info.getParentNo(), parentNo);
                    //判断父分类是否存在
                    CategoryInfo parent = categoryInfoService.getCategoryInfoByNo(parentNo);
                    if (parent == null) {
                        map.put(EzokConstant.ERROR, "选择的父分类不存在");
                        return "admin/admin_info_error";
                    }
                    //如果存在，需要修改STUCT,STRUCT_NAME
                    String struct = getStructByParentNo(parentNo, parent.getStruct());
                    info.setStruct(struct);
                    info.setStructName(parent.getName() + "-" + info.getName());
                    info.setParentNo(parentNo);

                }
            }
            categoryInfoService.saveCategoryInfo(info);

        }

        map.put(EzokConstant.SUCCESS, "分类修改成功");
        return "redirect:/admin_info_success.html";
    }

    //删除分类
    @RequestMapping(value = "admin/admin_cate_del.html")
    public String categoryToDel(String no, ModelMap map) {
        CategoryInfo info = categoryInfoService.getCategoryInfoByNo(no);
        if (null == info) {
            map.put(EzokConstant.ERROR, "分类不存在");
            return "admin/admin_info_error";
        }

        List<CategoryInfo> child = categoryInfoService.getCategoryInfoListByParentNo(no);
        if (!CollectionUtils.isEmpty(child)) {
            map.put(EzokConstant.ERROR, "分类下有子分类不能删除");
            return "admin/admin_info_error";
        }
        NavInfo navInfo = new NavInfo();
        navInfo.setCategoryNo(no);
        NavInfoVO vo = navInfoService.getNavInfoVo(navInfo, new PageInfo());
        if (vo.getCount() > 0) {
            map.put(EzokConstant.ERROR, "分类下有商品，不能删除");
            return "admin/admin_info_error";
        }
        info.setStatus(EzokConstant.DEFAULT_STATUS_STOP);

        categoryInfoService.saveCategoryInfo(info);
        //取得所有一级分类
        map.put(EzokConstant.SUCCESS, "分类删除成功");
        return "redirect:/admin_info_success.html";
    }

    //添加分类
    @RequestMapping(value = "admin/admin_cate_list.html", method = RequestMethod.GET)
    public String categoryList(ModelMap map) {
        //取得所有一级分类
        List<CategoryListVO> list = categoryInfoService.getCategoryListVos();
        map.put("list", list);
        return "admin/admin_cate_list";
    }

    /**
     * 添加分类
     *
     * @param info  分类信息
     * @param level 分类级别
     * @param map   ModelMap
     * @return String
     */
    @RequestMapping(value = "admin/admin_cate_add.html", method = RequestMethod.GET)
    public String categoryAdd(CategoryInfo info, Integer level, ModelMap map) {
        String id = UUIDGenerator.getUUID();
        String no = sequenceService.getCategoryNo();
        info.setId(id);
        info.setNo(no);
        info.setCreateDate(new Date());
        info.setStatus(EzokConstant.DEFAULT_STATUS_VALID);
        if (level == 1) {
            info.setParentNo(EzokConstant.DEFAULT_CATEGORY_PARENTNO);
            info.setStructName(info.getName());
            //设立结构
            //从10开始
            String struct = getStructByParentNo(EzokConstant.DEFAULT_CATEGORY_PARENTNO, null);
            info.setStruct(struct);


        } else if (level == 2) {
            //取得父NO
            String parentNo = info.getParentNo();
            CategoryInfo parent = categoryInfoService.getCategoryInfoByNo(parentNo);
            if (null == parent) {
                logger.error("分类父NO不存在:{}", parentNo);
                map.put(EzokConstant.SUCCESS, "分类添加成功");
                return "admin/admin_info_error";
            }
            info.setStructName(parent.getStructName() + "-" + info.getName());
            //从10开始
            String struct = getStructByParentNo(parentNo, parent.getStruct());
            info.setStruct(struct);

        } else {
            logger.error("错误的分类级别:{}", level);
            map.put(EzokConstant.ERROR, "错误的分类级别");
            return "admin/admin_info_error";
        }
        categoryInfoService.addCategoryInfo(info);
        map.put(EzokConstant.SUCCESS, "分类添加成功");
        return "redirect:/admin_info_success.html";
    }

    private String getStructByParentNo(String parentNo, String parentStuct) {
        String struct = null;
        int i = 10;
        while (true) {
            int index = categoryInfoService.getCategoryCountByParentNo(EzokConstant.DEFAULT_CATEGORY_PARENTNO) + i;
            if (StringUtils.isBlank(parentStuct)) {
                struct = index + "";
            } else {
                struct = parentStuct + "-" + index;
            }
            CategoryInfo info = categoryInfoService.getCategoryInfoByStruct(struct);
            if (info == null) {
                return struct;
            }
            i++;
        }
    }
}
