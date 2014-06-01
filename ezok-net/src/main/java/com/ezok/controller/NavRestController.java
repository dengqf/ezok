/*
 * NavInfoController.java 
 * Version: 2.01   2014-3-21
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.controller;

import com.ezok.model.CategoryInfo;
import com.ezok.model.NavInfo;
import com.ezok.model.NavWeekExtend;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavInfoVO;
import com.ezok.model.vo.NavWeekExtendVO;
import com.ezok.service.ICategoryInfoService;
import com.ezok.service.INavInfoService;
import com.ezok.service.INavWeekService;
import com.ezok.service.ISequenceService;
import com.ezok.utils.CateUtil;
import com.ezok.utils.EzokConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-3-21
 * 导航页面静态化
 */
@Controller
public class NavRestController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    INavInfoService navInfoService;
    @Autowired
    INavWeekService navWeekService;
    @Autowired
    ICategoryInfoService categoryInfoService;
    @Autowired
    CateUtil cateUtil;


    @RequestMapping("/{no}/info.html")
    public String getNav(@PathVariable String no, ModelMap map) {
        NavInfo navInfo = navInfoService.getNavInfoByNo(no);
        if (navInfo == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息不存在！");
            return "nav_error";
        }
        String cateNo = navInfo.getCategoryNo();
        CategoryInfo cateInfo = cateUtil.getCategoryInfoByNo(cateNo);
        if (cateInfo == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息所属分类已经被删除！");
            return "nav_error";
        }

        CategoryInfo parentCate = cateUtil.getCategoryInfoByNo(cateInfo.getParentNo());
        if (parentCate == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息所属父分类已经被删除！");
            return "nav_error";
        }
        //点击率+1
        Integer clickSum = navInfo.getClickSum();
        if (null == clickSum) {
            clickSum = 0;
        }
        navInfo.setClickSum(clickSum + 1);
        //推荐权重的计算需要思考
//        navInfo.setPriority(navInfo.getPriority() + navInfo.getClickSum());
        //todo 以后可以优化
        navInfoService.saveNavInfo(navInfo);
        //猜你喜欢
        List<NavInfo> navInfoList = navInfoService.getLikeNavInfoList(navInfo);

        map.put("navInfo", navInfo);
        map.put("cateInfo", cateInfo);
        map.put("parentCate", parentCate);
        map.put("likeList", navInfoList);
        return "nav_info";
    }

    /**
     * 分类编号
     */
    @RequestMapping("/{no}/list.html")
    public String navList(@PathVariable String no, PageInfo pageInfo, ModelMap map) {
        CategoryInfo cate = categoryInfoService.getCategoryInfoByNo(no);
        if (null == cate) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息所属分类已经被删除！");
            return "nav_error";
        }
        CategoryInfo parent = null;
        NavInfoVO vo = null;
        if (EzokConstant.DEFAULT_CATEGORY_PARENTNO.equals(cate.getParentNo())) {
            logger.info("查询的是第一级分类");
            vo = navInfoService.getNavInfoVoByParentCate(no, pageInfo);
        } else {
            vo = navInfoService.getNavInfoVo(no, pageInfo);
            parent = categoryInfoService.getCategoryInfoByNo(cate.getParentNo());
            if (parent != null) {
                map.put("parent", parent);
                Integer parentClickSum = parent.getClickSum();
                if (null == parentClickSum) {
                    parentClickSum = 0;
                }
                parent.setClickSum(parentClickSum + 1);
                categoryInfoService.saveCategoryInfo(parent);
            }
            //如果是子分类，则给父分类
        }

        Integer clickSum = cate.getClickSum();
        if (null == clickSum) {
            clickSum = 0;
        }
        cate.setClickSum(clickSum + 1);
        categoryInfoService.saveCategoryInfo(cate);
        pageInfo.setPageCount(vo.getCount());
        String pageUrl = "nav_list.html?no=" + no + "&&";
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), pageUrl);
        map.put("pageUtil", page);
        map.put("cate", cate);
        map.put("vo", vo);
        map.put("no", no);
        return "nav_list";
    }

    /**
     * 分类编号
     */
    @RequestMapping("/{no}/{pageNo}/list.html")
    public String navList(@PathVariable("no") String no, @PathVariable("pageNo") Integer pageNo, ModelMap map) {
        CategoryInfo cate = cateUtil.getCategoryInfoByNo(no);
        if (null == cate) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息所属分类已经被删除！");
            return "nav_error";
        }

        NavInfoVO vo = null;
        CategoryInfo parent = null;
        PageInfo pageInfo = new PageInfo(pageNo, null);
        if (EzokConstant.DEFAULT_CATEGORY_PARENTNO.equals(cate.getParentNo())) {
            logger.info("查询的是第一级分类");
            vo = navInfoService.getNavInfoVoByParentCate(no, pageInfo);
        } else {
            vo = navInfoService.getNavInfoVo(no, pageInfo);
            parent = categoryInfoService.getCategoryInfoByNo(cate.getParentNo());
            if (parent != null) {
                map.put("parent", parent);
                Integer parentClickSum = parent.getClickSum();
                if (null == parentClickSum) {
                    parentClickSum = 0;
                }
                parent.setClickSum(parentClickSum + 1);
                categoryInfoService.saveCategoryInfo(parent);
            }
        }
        Integer clickSum = cate.getClickSum();
        if (null == clickSum) {
            clickSum = 0;
        }
        cate.setClickSum(clickSum + 1);
        categoryInfoService.saveCategoryInfo(cate);
        pageInfo.setPageCount(vo.getCount());
        String pageUrl = "nav_list.html?no=" + no + "&&";
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), pageUrl);
        map.put("pageUtil", page);
        map.put("vo", vo);
        map.put("no", no);
        map.put("cate", cate);
        return "nav_list";
    }


    @RequestMapping("/{pageNo}/nav_week_list.html")
    public String navWeekList(@PathVariable("pageNo") Integer pageNo, ModelMap map) {
        PageInfo pageInfo = new PageInfo(pageNo, 3);
        NavWeekExtendVO vo = navWeekService.getNavWeekExtendVo(pageInfo);
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), "");
        if (!CollectionUtils.isEmpty(vo.getList())) {
            NavWeekExtend navWeekExtend = vo.getList().get(0);
            map.put("navInfo", navWeekExtend);
        }

        map.put("vo", vo);
        map.put("pageUtil", page);
        return "nav_week_list";
    }
}
