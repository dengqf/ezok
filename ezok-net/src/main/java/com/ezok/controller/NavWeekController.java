package com.ezok.controller;

import com.app.tools.UUIDGenerator;
import com.ezok.model.NavInfo;
import com.ezok.model.NavWeek;
import com.ezok.model.NavWeekExtend;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavWeekExtendVO;
import com.ezok.model.vo.NavWeekVO;
import com.ezok.service.INavInfoService;
import com.ezok.service.INavWeekService;
import com.ezok.utils.EzokConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-26
 * Time: 下午1:15
 * To change this template use File | Settings | File Templates.
 * 每周推荐
 */
@Controller
public class NavWeekController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    INavInfoService navInfoService;
    @Autowired
    INavWeekService navWeekService;

    @RequestMapping(value = "admin/nav_week_toAdd.html", method = RequestMethod.GET)
    public String toAddNavWeek(String no, ModelMap map) {
        NavInfo navInfo = navInfoService.getNavInfoByNo(no);
        if (navInfo == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息不存在！");
            return "admin/admin_info_error";
        }
        if (EzokConstant.DEFAULT_STATUS_VALID != navInfo.getStatus()) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息状态非审核通过！");
            return "admin/admin_info_error";
        }

        NavWeek navWeek = navWeekService.getNavWeekByNavNo(no);
        if (null != navWeek) {
            map.put("navWeek", navWeek);

        }
        map.put("navInfo", navInfo);
        return "admin/admin_nav_addWeek";
    }

    @RequestMapping(value = "admin/nav_week_add.html", method = RequestMethod.GET)
    public String addNavWeek(String no, String reason, ModelMap map) {
        NavInfo navInfo = navInfoService.getNavInfoByNo(no);
        if (navInfo == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息不存在！");
            return "admin/admin_info_error";
        }
        if (EzokConstant.DEFAULT_STATUS_VALID != navInfo.getStatus()) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息状态非审核通过！");
            return "admin/admin_info_error";
        }
        //判断导航周推荐是否存在
        NavWeek navWeek = navWeekService.getNavWeekByNavNo(no);
        if (null != navWeek) {
            //更新
            navWeek.setTopReason(reason);
            navWeek.setUpdateDate(new Date());
            navWeekService.updateNavWeek(navWeek);
        } else {
            navWeek = new NavWeek();
            navWeek.setUpdateDate(new Date());
            navWeek.setTopReason(reason);
            navWeek.setNavNo(no);
            navWeek.setId(UUIDGenerator.getUUID());
            navWeekService.addNavWeek(navWeek);
        }

        map.put(EzokConstant.SUCCESS, "每周推荐添加成功");
        return "redirect:/admin_info_success.html";
    }

    @RequestMapping(value = "admin/admin_nav_weekList.html", method = RequestMethod.GET)
    public String adminNavWeekList(PageInfo pageInfo, ModelMap map) {
        pageInfo.setPageSize(1);//每页一条
        NavWeekExtendVO vo = navWeekService.getNavWeekExtendVo(pageInfo);
        pageInfo.setPageCount(vo.getCount());
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), "admin/admin_nav_weekList.html?");
        map.put("pageUtil", page);
        map.put("vo", vo);
        return "admin/admin_nav_weekList";
    }
}
