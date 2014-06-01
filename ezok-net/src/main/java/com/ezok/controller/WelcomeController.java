/*
 * WelcomeController.java 
 * Version: 2.01   2014-2-15
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.controller;

import com.ezok.model.AdminInfo;
import com.ezok.model.CategoryInfo;
import com.ezok.model.vo.CategoryListVO;
import com.ezok.utils.CateUtil;
import com.ezok.utils.EzokConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-15
 */
@Controller
public class WelcomeController {
    @Autowired
    CateUtil cateUtil;

    @RequestMapping(value = "example.html", method = RequestMethod.GET)
    public String example(HttpSession session, ModelMap map) {
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        StringBuilder html = new StringBuilder("<a href=\"#\" class=\"title\">全部分类<b class=\"caret\"></b></a>\n");
        html.append("<div class=\"lis_con\">\n");
        for (CategoryListVO vo : list) {
            CategoryInfo parent = vo.getCategoryInfo();
            html.append("<div class=\"lis\">\n");
            html.append("<h3><a href=\"${context}/" + parent.getNo() + "/list.html\" title=\"" + parent.getName() + "分类的微信公众号导航列表\">" + parent.getName() + "</a></h3>\n");
            html.append("<div class=\"sub_con\">\n");
            List<CategoryInfo> child = vo.getChildList();
            for (CategoryInfo info : child) {
                html.append("<a href=\"${context}/" + info.getNo() + "/list.html\" title=\"" + info.getName() + "分类的微信公众号导航列表\">" + info.getName() + "</a>\n");
            }
            html.append("</div>\n");
            html.append("</div>\n");

        }
        html.append("</div>\n");
        map.put("html", html.toString());
        return "example";
    }

    @RequestMapping(value = "example2.html", method = RequestMethod.GET)
    public String example2(HttpSession session) {
        return "example2";
    }

    @RequestMapping(value = "admin_login.html", method = RequestMethod.GET)
    public String adminLogin(HttpSession session) {
        return "example2";
    }

    @RequestMapping(value = "nav_ok.html")
    public String navOk(String success, ModelMap map) {
        map.put(EzokConstant.SUCCESS, success);
        return "nav_ok";

    }

    @RequestMapping(value = "admin/admin_login.html")
    public String adminToLogin(String success, ModelMap map) {
        map.put(EzokConstant.SUCCESS, success);
        return "admin/admin_login";

    }

    @RequestMapping(value = "admin/admin_loginAdmin.html")
    public String adminLogin(AdminInfo info, ModelMap map, HttpSession session) {
        if ("admin".equals(info.getUserName()) && "ezok#admin".equals(info.getPassword())) {
            session.setAttribute(EzokConstant.SESSION_LOGIN_ADMIN, info);
            return "admin/admin_index";
        } else {
            map.put(EzokConstant.ERROR, "用户名密码错误");
            return "admin/admin_login";
        }

    }

    @RequestMapping(value = "admin/admin_out.html")
    public String adminToLogOut(String success, ModelMap map, HttpSession session) {
        session.invalidate();
        map.put(EzokConstant.ERROR, "你已经登出管理平台");
        return "admin/admin_login";

    }

    @RequestMapping(value = "admin/admin_index.html")
    public String adminToIndex(String success, ModelMap map, HttpSession session) {

        return "admin/admin_index";

    }


    @RequestMapping("admin_info_success.html")
    public String adminSuccess(String success, ModelMap map) {

        map.put(EzokConstant.SUCCESS, success);
        return "admin/admin_info_success";

    }

    @RequestMapping("user_info_success.html")
    public String userSuccess(String success, ModelMap map) {
        map.put(EzokConstant.SUCCESS, success);
        return "user/user_info_success";

    }

    @RequestMapping(value = "user/user_index.html")
    public String userToIndex(String success, ModelMap map, HttpSession session) {

        return "user/user_index";

    }

    @RequestMapping(value = "about.html")
    public String aboutNav(String success, ModelMap map) {
        return "about";

    }

    @RequestMapping(value = "contact.html")
    public String contactNav(String success, ModelMap map) {
        return "contact";

    }
    @RequestMapping(value = "copyright.html")
    public String copyright(String success, ModelMap map) {
        return "copyright";

    }
}
