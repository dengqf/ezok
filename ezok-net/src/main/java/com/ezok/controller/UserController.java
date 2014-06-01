package com.ezok.controller;

import com.app.tools.UUIDGenerator;
import com.ezok.model.UserInfo;
import com.ezok.service.IUserInfoService;
import com.ezok.utils.CommonUtil;
import com.ezok.utils.EzokConstant;
import com.ezok.utils.RandomValidateCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-24
 * Time: 下午10:00
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IUserInfoService userInfoService;

    @RequestMapping(value = "user_loginUse.html", method = RequestMethod.GET)
    public String userLogin(UserInfo info, String randomCode, ModelMap map, HttpSession session) {
        String random = (String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
        if (!StringUtils.equalsIgnoreCase(random, randomCode)) {
            logger.info("登录异常，用户名:{},验证码错误");
            map.put(EzokConstant.ERROR, "您好，验证码错误");
            return "user/user_login";
        }
        String userName = info.getUsername();
        if (StringUtils.isBlank(userName)) {
            map.put(EzokConstant.ERROR, "您好，用户名不能为空");
            return "user/user_login";
        }
        UserInfo obj = userInfoService.getUserInfo(userName);
        if (obj == null) {
            map.put(EzokConstant.ERROR, "您好，密码错误或者用户名不存在");
            return "user/user_login";
        }

        if (!StringUtils.equals(info.getPassword(), obj.getPassword())) {
            map.put(EzokConstant.ERROR, "密码错误或者用户名不存在");
            return "user/user_login";
        }
        session.setAttribute(EzokConstant.SESSION_LOGIN_USER, info);
        return "index";
    }

    @RequestMapping(value = "user_logOut.html", method = RequestMethod.GET)
    public String userToLogOut(HttpSession session, ModelMap map) {
        session.invalidate();
        map.put(EzokConstant.ERROR, "你已经登出用户平台");
        return "user/user_login";
    }

    @RequestMapping(value = "user/user_password.html", method = RequestMethod.GET)
    public String userToPassword() {

        return "user/user_password";
    }

    @RequestMapping(value = "user/user_update_password.html", method = RequestMethod.GET)
    public String userUpdatePassword(String oldPassword, String newPassword, ModelMap map, HttpServletRequest request) {
        UserInfo user = CommonUtil.getUser(request);
        if (!StringUtils.equals(oldPassword, user.getPassword())) {
            map.put(EzokConstant.ERROR, "旧密码不正确，请重新输入。");
            return "nav_error";
        }
        user.setPassword(newPassword);
        userInfoService.saveUserInfo(user);
        map.put(EzokConstant.SUCCESS, "密码修改成功!");
        return "redirect:/user_info_success.html";
    }

    @RequestMapping(value = "user/user_login.html", method = RequestMethod.GET)
    public String userToLogin(HttpSession session, String error, ModelMap map) {

        if (StringUtils.isNotBlank(error)) {
            map.put(EzokConstant.ERROR, "session过期或你尚未登录，请登录后使用。");
        }
        return "user/user_login";
    }

    @RequestMapping(value = "user_add.html", method = RequestMethod.GET)
    public String userAdd(UserInfo info, ModelMap map,String randomCode, HttpSession session) {
        String random = (String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
        if (!StringUtils.equalsIgnoreCase(random, randomCode)) {
            logger.info("登录异常，用户名:{},验证码错误");
            map.put(EzokConstant.ERROR, "您好，验证码错误");
            return "user/user_login";
        }
        String userName = info.getUsername();
        if (StringUtils.isBlank(userName)) {
            map.put(EzokConstant.ERROR, "您好，注册用户名不能为空。");
            return "user/user_login";
        }
        UserInfo obj = userInfoService.getUserInfo(userName);
        if (obj != null) {
            map.put(EzokConstant.ERROR, "您好，该用户名已经被注册。");
            return "user/user_login";
        }
        info.setId(UUIDGenerator.getUUID());
        info.setCreateDate(new Date());
        userInfoService.addUserInfo(info);
        session.setAttribute(EzokConstant.SESSION_LOGIN_USER, info);
        return "index";
    }


}
