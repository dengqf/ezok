/*
 * AdminController.java 
 * Version: 2.01   2014-4-4
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.controller;

import com.ezok.model.CategoryInfo;
import com.ezok.model.NavInfo;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.CategoryListVO;
import com.ezok.service.INavInfoService;
import com.ezok.utils.CateUtil;
import com.ezok.utils.EzokConstant;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ezok.utils.*;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-4-4
 */
@Controller
public class AdminController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    INavInfoService navInfoService;
    @Autowired
    CateUtil cateUtil;

    @RequestMapping(value = "admin/renewCate.html", method = RequestMethod.GET)
    public String example(HttpSession session, ModelMap map) {
        logger.info("刷新分类信息");
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        StringBuilder html = new StringBuilder("<a href=\"#\" class=\"title\">全部分类<b class=\"caret\"></b></a>\n");
        html.append("<div class=\"lis_con\">\n");
        for (CategoryListVO vo : list) {
            CategoryInfo parent = vo.getCategoryInfo();
            html.append("<div class=\"lis\">\n");
            html.append("<h3><a href=\"${context}/" + parent.getNo() + "/list.html\" title=\"" + parent.getName() + "分类的微信公众号\">" + parent.getName() + "</a></h3>\n");
            html.append("<div class=\"sub_con\">\n");
            List<CategoryInfo> child = vo.getChildList();
            for (CategoryInfo info : child) {
                html.append("<a href=\"${context}/" + info.getNo() + "/list.html\" title=\"" + info.getName() + "分类的微信公众号\">" + info.getName() + "</a>\n");
            }
            html.append("</div>\n");
            html.append("</div>\n");

        }
        html.append("</div>\n");
        createFile("/home/superman/ezok-net/WEB-INF/include/allCate.ftl", html.toString());

        map.put(EzokConstant.SUCCESS, "分类刷新成功");
        return "redirect:/admin_info_success.html";
    }

    @RequestMapping(value = "admin/sitemap.html")
    public String sitemap(ModelMap map) {
        return "admin/admin_sitemap";
    }

    @RequestMapping(value = "admin/createSitemap.html")
    public String createSitemap(ModelMap map, String start, String end, HttpServletRequest request) {
        Date startDate = DateUtil.parseDate((start + " 00:00:00"));
        Date endDate = DateUtil.parseDate((end + " 23:59:59"));
        //得到需要更新的列表
        List<NavInfo> list = navInfoService.getSiteMapList(startDate, endDate);
        List<CategoryListVO> voList = cateUtil.getCategoryListVos();
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZZ";
//        System.out.println(DateFormatUtils.format(new Date(), pattern));


        String today = DateFormatUtils.format(new Date(), pattern);
        StringBuilder xml = new StringBuilder("");
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n").
                append("<?xml-stylesheet type=\"text/xsl\" href=\"sitemap.xsl\"?>\n").
                append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n").
                append("<url>\n").
                append("<loc>http://www.ezok.net/</loc>\n").
                append("<priority>1.0</priority>\n").
                append("<lastmod>").append(today).append("</lastmod>\n").
                append("<changefreq>Daily</changefreq>\n").
                append("</url>\n").
                append("<url>\n").
                append("<loc>http://www.ezok.net/about.html</loc>\n").
                append("<priority>0.8</priority>\n").
                append("<lastmod>").append(today).append("</lastmod>\n").
                append("<changefreq>Monthly</changefreq>\n").
                append("</url>\n").
                append("<url>\n").
                append("<loc>http://www.ezok.net/contact.html</loc>\n").
                append("<priority>0.8</priority>\n").
                append("<lastmod>").append(today).append("</lastmod>\n").
                append("<changefreq>Monthly</changefreq>\n").
                append("</url>\n").
                append("<url>\n").
                append("<loc>http://www.ezok.net/copyright.html</loc>\n").
                append("<priority>0.8</priority>\n").
                append("<lastmod>").append(today).append("</lastmod>\n").
                append("<changefreq>Monthly</changefreq>\n").append("</url>\n").
                append("<url>\n").append("<loc>http://www.ezok.net/index.html</loc>\n").append("<priority>0.8</priority>\n").append("<lastmod>").append(today).append("</lastmod>\n").append("<changefreq>Daily</changefreq>\n").append("</url>\n").append("<url>\n").append("<loc>http://www.ezok.net/1/nav_week_list.html</loc>\n").append("<priority>0.6</priority>\n").append("<lastmod>").append(today).append("</lastmod>\n").append("<changefreq>Weekly</changefreq>\n").append("</url>\n");
        for (CategoryListVO vo : voList) {
            CategoryInfo parent = vo.getCategoryInfo();
            xml.append("<url>\n").append("<loc>http://www.ezok.net/").append(parent.getNo()).append("/list.html</loc>\n").append("<priority>0.6</priority>\n").append("<lastmod>").append(today).append("</lastmod>\n").append("<changefreq>Weekly</changefreq>\n").append("</url>");
            for (CategoryInfo child : vo.getChildList()) {
                xml.append("<url>\n").append("<loc>http://www.ezok.net/").append(child.getNo()).append("/list.html</loc>\n").append("<priority>0.6</priority>\n").append("<lastmod>").append(today).append("</lastmod>\n").append("<changefreq>Weekly</changefreq>\n").append("</url>");
            }
        }
        for (NavInfo nav : list) {
            xml.append("<url>\n" + "<loc>http://www.ezok.net/").append(nav.getNo()).append("/info.html</loc>\n").append("<priority>0.6</priority>\n").append("<lastmod>").append(today).append("</lastmod>\n").append("<changefreq>Daily</changefreq>\n").append("</url>\n");
        }
        xml.append("</urlset>");

        createFile("/home/superman/ezok-net/sitemap.xml", xml.toString());

        map.put(EzokConstant.SUCCESS, "提交成功");
        return "redirect:/admin_info_success.html";
    }

    @RequestMapping(value = "admin/cleanNav.html")
    public String navTop(ModelMap map) {
        NavInfo navInfo = new NavInfo();
        navInfo.setStatus(9);
        navInfo.setCategoryNo("1039");
//        navInfo.setNo("10008066");
        List<NavInfo> list = navInfoService.getNavInfoVo(navInfo, new PageInfo(1, 20000)).getNavInfoList();
        String[] replaces = {"<p>", "</p>", "<br>", "</br>"};
        for (NavInfo nav : list) {
            String navDesc = nav.getNavDesc();
            logger.info("BEFORE-----------:{}", navDesc);
            for (String replace : replaces) {
                navDesc = navDesc.replaceAll(replace, "");
            }
            nav.setNavDesc(navDesc);
//            nav.setSummary(navDesc);
            logger.info("\n\nAFTER-------:{}", navDesc);
            navInfoService.saveNavInfo(nav);


        }
        map.put(EzokConstant.SUCCESS, "修改成功");
        return "redirect:/admin_info_success.html";
    }

    private void createFile(String fileUrl, String content) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileUrl);
            fw.write(content);
            fw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
