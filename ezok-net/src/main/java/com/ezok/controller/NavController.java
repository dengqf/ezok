package com.ezok.controller;

import com.app.tools.PropertiesTool;
import com.app.tools.UUIDGenerator;
import com.app.tools.file.FileUpload;
import com.app.tools.image.ImageHelp;
import com.ezok.model.*;
import com.ezok.model.vo.CategoryListVO;
import com.ezok.model.vo.NavInfoVO;
import com.ezok.model.vo.NavRelArticleVO;
import com.ezok.service.ICategoryInfoService;
import com.ezok.service.INavInfoService;
import com.ezok.service.INavRelArticleService;
import com.ezok.service.ISequenceService;
import com.ezok.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-15
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class NavController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    INavInfoService navInfoService;
    @Autowired
    ISequenceService sequenceService;
    @Autowired
    INavRelArticleService navRelArticleService;
    @Autowired
    CateUtil cateUtil;


    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "nav_list.html")
    /**
     * 分类编号
     */
    public String navList(String no, PageInfo pageInfo, ModelMap map) {
        CategoryInfo cate = cateUtil.getCategoryInfoByNo(no);
        if (null == cate) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息所属分类已经被删除！");
            return "nav_error";
        }

        NavInfoVO vo = null;
        if (EzokConstant.DEFAULT_CATEGORY_PARENTNO.equals(cate.getParentNo())) {
            logger.info("查询的是第一级分类");
            vo = navInfoService.getNavInfoVoByParentCate(no, pageInfo);
        } else {
            vo = navInfoService.getNavInfoVo(no, pageInfo);
        }

        pageInfo.setPageCount(vo.getCount());
        String pageUrl = "nav_list.html?no=" + no + "&&";
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), pageUrl);
        map.put("pageUtil", page);
        map.put("vo", vo);
        map.put("no", no);
        return "nav_list";
    }

    @RequestMapping(value = "nav_info.html")
    public String navInfo(String no, ModelMap map) {
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
        map.put("navInfo", navInfo);
        map.put("cateInfo", cateInfo);
        map.put("parentCate", parentCate);
        return "nav_info";
    }

    @RequestMapping(value = "user/nav_to_add.html")
    public String navToAdd(ModelMap map) {
        //先从内存中读取
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        map.put("list", list);
        return "user/nav_add";
    }

    @RequestMapping(value = "user/nav_add.html")
    public String navAdd(NavInfo navInfo, HttpServletRequest request, ModelMap map) {
        logger.info("添加NAV信息");
        //TODO 以后去掉
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        map.put("list", list);

        String id = UUIDGenerator.getUUID();
        String no = sequenceService.getNavNo();

        String weixinAccount = navInfo.getWeixinAccount();
        if (StringUtils.isBlank(navInfo.getName())) {
            logger.error("信息名称不能为空");
            map.put(EzokConstant.ERROR, "信息名称不能为空");
            return "nav_error";
        }
        if (StringUtils.isBlank(weixinAccount)) {
            logger.error("微信账号不能为空");
            map.put(EzokConstant.ERROR, "微信账号不能为空");
            return "nav_error";
        }

        if (StringUtils.isBlank(navInfo.getWeixinName())) {
            logger.error("微信公共账号不能为空");
            map.put(EzokConstant.ERROR, "微信公共账号不能为空");
            return "nav_error";
        }

        String wxImgAudit = ImgUploadUtil.isSpecImg(request, "wxEwm");
        if (!EzokConstant.SUCCESS.equals(wxImgAudit)) {
            logger.error("微信图片规格不符合");
            map.put(EzokConstant.ERROR, "微信二维码图片错误," + wxImgAudit);
            return "nav_error";
        }
        String iconImgAudit = ImgUploadUtil.isSpecImg(request, "icon");
        if (!EzokConstant.SUCCESS.equals(iconImgAudit)) {
            logger.error("头像图片规格不符合");
            map.put(EzokConstant.ERROR, "头像图片错误," + iconImgAudit);
            return "nav_error";
        }

        String yxResult = ImgUploadUtil.isSpecImgIfExist(request, "yxEwm");
        if (!EzokConstant.SUCCESS.equals(yxResult)) {
            map.put(EzokConstant.ERROR, "易信二维码图片错误" + yxResult);
            return "nav_error";
        }

        NavInfo old = navInfoService.getNavInfoByWeixinAccount(weixinAccount);
        if (old != null) {
            map.put(EzokConstant.ERROR, "微信账号已经被收录，不能重复添加");
            return "nav_error";
        }
        String categoryNo = navInfo.getCategoryNo();
        if (StringUtils.isBlank(categoryNo)) {
            logger.error("分类编号为空");
            map.put(EzokConstant.ERROR, "请选择分类信息");
            return "nav_error";
        }
        if (StringUtils.isBlank(navInfo.getCity())) {
            map.put(EzokConstant.ERROR, "请选择城市");
            return "nav_error";
        }
        String url = navInfo.getUrl();
        String weiboUrl = navInfo.getWeiboUrl();
        if (StringUtils.isNotBlank(url) && !url.startsWith("http://")) {
            map.put(EzokConstant.ERROR, "官方网站地址格式错误，请以 http://开头");
            return "nav_error";
        }
        if (StringUtils.isNotBlank(weiboUrl) && !weiboUrl.startsWith("http://")) {
            map.put(EzokConstant.ERROR, "官方微博地址格式错误，请以 http://开头");
            return "nav_error";
        }
        CategoryInfo obj = cateUtil.getCategoryInfoByNo(categoryNo);
        if (null == obj) {
            logger.error("分类信息不存在");
            map.put(EzokConstant.ERROR, "请选择有效分类信息");
            return "nav_error";
        } else {
            navInfo.setCategoryName(obj.getName());
        }

        ImgUploadUtil.uploadImg(request, no, navInfo);
        UserInfo user = CommonUtil.getUser(request);
        if (user != null) {
            navInfo.setUsername(user.getUsername());
        }

        navInfo.setId(id);
        navInfo.setNo(no);
        navInfo.setStatus(EzokConstant.DEFAULT_STATUS_PAUSE);
        //TODO 判断权重
        Integer priority = getPriorityByNavInfo(navInfo);
        navInfo.setPriority(priority);
        navInfo.setCreateDate(new Date());
        navInfo.setUpdateDate(new Date());
        navInfoService.addNavInfo(navInfo);
        logger.debug("插入数据成功！");
        map.put(EzokConstant.SUCCESS, "信息添加成功，我们将会在1-3个工作日内对信息进行审核");
        return "redirect:/user_info_success.html";
//        return "nav_ok";
    }

    @RequestMapping(value = "admin/admin_nav_search.html")
    public String navToSearch(ModelMap map) {
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        map.put("list", list);
        return "admin/admin_nav_search";
    }


    @RequestMapping(value = "admin/admin_nav_info.html")
    public String navAdminInfo(String no, ModelMap map) {
        NavInfo navInfo = navInfoService.getNavInfoByNo(no);
        if (navInfo == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息不存在！");
            return "nav_error";
        }
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        CategoryInfo cate = cateUtil.getCategoryInfoByNo(navInfo.getCategoryNo());
        map.put("cate", cate);
        map.put("list", list);
        map.put("navInfo", navInfo);

        return "admin/admin_nav_info";
    }


    public String navUpdate(NavInfo info, HttpServletRequest request) {
        NavInfo obj = navInfoService.getNavInfoById(info.getId());
        if (obj == null) {
            return "对不起,你查询的信息不存在！";
        }
        String no = obj.getNo();
        //地域处理，先这样吧
        String province = info.getProvince();
        if (StringUtils.isNotBlank(province)) {
            if (province.contains("选择")) {
                info.setCity(null);
                info.setProvince(null);
            }
        }
        String cateNo = info.getCategoryNo();
        if (StringUtils.isNotBlank(cateNo)) {
            //判断
            CategoryInfo cate = cateUtil.getCategoryInfoByNo(cateNo);
            if (null == cate) {
                return "选择的分类不存在";
            }
            info.setCategoryNo(cateNo);
            info.setCategoryName(cate.getName());
        } else {
            info.setCategoryNo(null);
        }

        String iconResult = ImgUploadUtil.isSpecImgIfExist(request, "icon");
        if (!EzokConstant.SUCCESS.equals(iconResult)) {
            return "头像图片错误" + iconResult;
        }

        String wxResult = ImgUploadUtil.isSpecImgIfExist(request, "wxEwm");
        if (!EzokConstant.SUCCESS.equals(wxResult)) {
            return "微信二维码图片错误" + wxResult;
        }

        //单独判断易信,易信如果没上传就不判断，上传了，就判断大小和图片格式
        String yxResult = ImgUploadUtil.isSpecImgIfExist(request, "yxEwm");
        if (!EzokConstant.SUCCESS.equals(yxResult)) {
            return "易信二维码图片错误" + yxResult;
        }
        ImgUploadUtil.uploadImg(request, no, info);
        info.setUpdateDate(new Date());
        //判断权重
        navInfoService.saveNavInfo(info);
        obj = navInfoService.getNavInfoById(info.getId());
        Integer old = obj.getPriority();
        Integer priority = getPriorityByNavInfo(obj);
        if (old < priority) {
            info.setPriority(priority);
            navInfoService.saveNavInfo(info);
        }
        return EzokConstant.SUCCESS;
    }

    @RequestMapping(value = "admin/admin_nav_update.html")
    public String navAdminUpdate(NavInfo info, ModelMap map, HttpServletRequest request) {

        String result = navUpdate(info, request);
        if (EzokConstant.SUCCESS.equals(result)) {
            map.put(EzokConstant.SUCCESS, "信息修改成功");
            return "redirect:/admin_info_success.html";
        } else {
            map.put(EzokConstant.ERROR, result);
            return "admin/admin_info_error";
        }
    }


    @RequestMapping(value = "admin/admin_nav_list.html")
    public String navAdminSearch(NavInfo navInfo, PageInfo pageInfo, ModelMap map) {
        pageInfo.setPageSize(20);
        NavInfoVO vo = navInfoService.getNavInfoVo(navInfo, pageInfo);
        pageInfo.setPageCount(vo.getCount());
        StringBuilder pageUrl = new StringBuilder("admin/admin_nav_list.html?");
        if (StringUtils.isNotBlank(navInfo.getName())) {
            pageUrl.append("name=").append(navInfo.getName()).append("&&");
        }
        if (StringUtils.isNotBlank(navInfo.getWeixinAccount())) {
            pageUrl.append("weixinAccount=").append(navInfo.getWeixinAccount()).append("&&");
        }

        if (StringUtils.isNotBlank(navInfo.getWeixinName())) {
            pageUrl.append("weixinName=").append(navInfo.getWeixinName()).append("&&");
        }

        if (StringUtils.isNotBlank(navInfo.getYixinAccount())) {
            pageUrl.append("yixinAccount=").append(navInfo.getYixinAccount()).append("&&");
        }

        if (StringUtils.isNotBlank(navInfo.getYixinName())) {
            pageUrl.append("yixinName=").append(navInfo.getYixinName()).append("&&");
        }

        if (StringUtils.isNotBlank(navInfo.getCategoryNo())) {
            pageUrl.append("categoryNo=").append(navInfo.getCategoryNo()).append("&&");
        }
        String province = navInfo.getProvince();
        String city = navInfo.getCity();
        if (StringUtils.isNotBlank(province) && !province.contains("选择")) {
            pageUrl.append("province=").append(navInfo.getProvince()).append("&&");
        }

        if (StringUtils.isNotBlank(city) && !city.contains("选择")) {
            pageUrl.append("city=").append(navInfo.getCity()).append("&&");
        }
        if (null != navInfo.getStatus()) {
            pageUrl.append("status=").append(navInfo.getStatus()).append("&&");
        }
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), pageUrl.toString());
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        logger.error("-----------------COUNT=="+vo.getCount());
        map.put("list", list);
        map.put("pageUtil", page);
        map.put("vo", vo);

        return "admin/admin_nav_list";
    }

    @RequestMapping(value = "admin/admin_nav_audit.html")
    public String navAudit(NavInfo info, HttpServletRequest request, ModelMap map) {
        String[] noList = request.getParameterValues("no");
        if (noList == null || noList.length < 1) {
            logger.info("");
            map.put(EzokConstant.ERROR, "请选择审核的信息");
            return "admin/admin_info_error";
        }
        if (StringUtils.isBlank(info.getCategoryNo())) {
            info.setCategoryNo(null);
        }
        info.setNo(null);
        Integer result = 0;
        if (info.getPriority() != null && info.getPriority() < 0) {
            logger.info("初始化");
            for (String no : noList) {
                NavInfo obj = navInfoService.getNavInfoByNo(no);
                if (obj != null) {
                    Integer now = getPriorityByNavInfo(obj);
                    obj.setPriority(now);
                    obj.setStatus(info.getStatus());
                    if (StringUtils.isNotBlank(info.getCategoryNo())) {
                        obj.setCategoryNo(info.getCategoryNo());
                    }
                    navInfoService.saveNavInfo(obj);
                    result++;

                }
            }
        } else {
            result = navInfoService.updateStatusForNav(noList, info);
        }


        map.put(EzokConstant.SUCCESS, "提交成功，修改数据:" + result + "条");
        return "redirect:/admin_info_success.html";
    }

    @RequestMapping(value = "admin/admin_nav_auditList.html")
    public String navAuditList(PageInfo pageInfo, ModelMap map) {
        NavInfo navInfo = new NavInfo();
        navInfo.setStatus(EzokConstant.DEFAULT_STATUS_PAUSE);
        pageInfo.setPageSize(50);
        NavInfoVO vo = navInfoService.getNavInfoVo(navInfo, pageInfo);
        pageInfo.setPageCount(vo.getCount());
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), "admin/admin_nav_auditList.html?");
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        map.put("list", list);
        map.put("pageUtil", page);
        map.put("vo", vo);

        return "admin/admin_nav_list";


    }

    @RequestMapping(value = "user/user_nav_List.html")
    public String userNavList(PageInfo pageInfo, HttpServletRequest request, ModelMap map) {
        NavInfo navInfo = new NavInfo();
        UserInfo user = CommonUtil.getUser(request);
        navInfo.setUsername(user.getUsername());

        NavInfoVO vo = navInfoService.getNavInfoVo(navInfo, pageInfo);
        pageInfo.setPageCount(vo.getCount());
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), "user/user_nav_List.html?");
        map.put("pageUtil", page);
        map.put("vo", vo);

        return "user/user_nav_List";


    }

    @RequestMapping(value = "user/user_nav_update.html")
    public String navUserUpdate(NavInfo info, ModelMap map, HttpServletRequest request) {
        info.setStatus(EzokConstant.DEFAULT_STATUS_PAUSE);
        String result = navUpdate(info, request);
        if (EzokConstant.SUCCESS.equals(result)) {
            map.put(EzokConstant.SUCCESS, "信息修改后,我们将在3-5个工作日对信息进行审核!");
            return "redirect:/user_info_success.html";
        } else {
            map.put(EzokConstant.ERROR, result);
            return "nav_error";
        }
    }

    @RequestMapping(value = "user/user_nav_info.html")
    public String navUserInfo(String no, ModelMap map, HttpServletRequest request) {
        NavInfo navInfo = navInfoService.getNavInfoByNo(no);
        if (navInfo == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息不存在！");
            return "nav_error";
        }

        UserInfo user = CommonUtil.getUser(request);
        if (!StringUtils.equals(navInfo.getUsername(), user.getUsername())) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息不属于您！");
            return "nav_error";
        }

        //TODO 以后去掉
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        CategoryInfo cate = cateUtil.getCategoryInfoByNo(navInfo.getCategoryNo());
        map.put("cate", cate);
        map.put("list", list);
        map.put("navInfo", navInfo);
        return "user/user_nav_info";
    }


    @RequestMapping(value = "admin/admin_initPriority.html")
    public String initPriority(ModelMap map, HttpServletRequest request) {
        NavInfo info = new NavInfo();
        info.setStatus(EzokConstant.DEFAULT_STATUS_VALID);
        PageInfo page = new PageInfo(1, 10000);
        NavInfoVO vo = navInfoService.getNavInfoVo(info, page);
        int result = 0;
        for (NavInfo nav : vo.getNavInfoList()) {
            Integer old = nav.getPriority();
            Integer now = getPriorityByNavInfo(nav);
            if (old < now) {
                nav.setPriority(now);
                navInfoService.saveNavInfo(nav);
                result++;
            }
        }
        map.put(EzokConstant.SUCCESS, "提交成功，修改数据:" + result + "条");
        return "redirect:/admin_info_success.html";
    }

    //todo admin_nav_article.ftl
    @RequestMapping(value = "admin/admin_nav_article.html")
    public String navToAddArticle(String no, ModelMap map, HttpServletRequest request) {
        NavInfo navInfo = navInfoService.getNavInfoByNo(no);
        if (navInfo == null) {
            map.put(EzokConstant.ERROR, "对不起,你查询的信息不存在！");
            return "nav_error";
        }
        NavRelArticle article = navRelArticleService.getNavRelArticleByNavInfoId(navInfo.getId());
        if (article != null) {
            map.put("article", article);
        }
        map.put("navInfo", navInfo);
        return "admin/admin_nav_article";
    }

    @RequestMapping(value = "admin/admin_nav_addArticle.html")
    public String navAddArticle(NavRelArticle article, ModelMap map, HttpServletRequest request) {
        NavRelArticle obj = navRelArticleService.getNavRelArticleByNavInfoId(article.getNavInfoId());
        if (obj == null) {
            article.setId(UUIDGenerator.getUUID());
            article.setCreateDate(new Date());
            article.setIsGrab(EzokConstant.YES);
            article.setCreateDate(new Date());
            article.setUpdateDate(new Date());
            navRelArticleService.insert(article);
        } else {
            article.setId(obj.getId());
            article.setUpdateDate(new Date());
            navRelArticleService.save(article);
        }
        map.put(EzokConstant.SUCCESS, "添加成功!");
        return "redirect:/admin_info_success.html";
    }

    //需要分页
    @RequestMapping(value = "admin/admin_nav_articleList.html")
    public String navArticleList(PageInfo pageInfo,ModelMap map, HttpServletRequest request) {
        pageInfo.setPageSize(20);
        NavRelArticleVO vo=navRelArticleService.getNavRelArticleVo(pageInfo);
        //先判断是否已经有了，如果有就更新，没有就添加
        pageInfo.setPageCount(vo.getCount());
        PageInfo page = new PageInfo(pageInfo.getPageNo(), pageInfo.getPageSize(), vo.getCount(), "admin/admin_nav_articleList.html?");
        map.put("pageUtil", page);
        map.put("vo", vo);
        return "admin/admin_nav_articleList";
    }


    private Integer getPriorityByNavInfo(NavInfo info) {
        Integer priority = EzokConstant.DEFAULT_PRIORITY;
        if (null != info) {
            if (StringUtils.isNotBlank(info.getWeiboUrl())) {
                priority += 50;
            }
            if (StringUtils.isNotBlank(info.getUrl())) {
                priority += 50;
            }
            if (StringUtils.isNotBlank(info.getYixinAccount())) {
                priority += 25;
            }
            if (StringUtils.isNotBlank(info.getYixinName())) {
                priority += 25;
            }
            if (StringUtils.isNotBlank(info.getYxEwmUrl())) {
                priority += 90;
            }
            int length = info.getSummary().length();
            if (length > 20) {
                priority += 50;

            }

            if (info.getNavDesc().length() > 50) {
                priority += 50;
            }

            return priority;

        }
        return priority;
    }
}
