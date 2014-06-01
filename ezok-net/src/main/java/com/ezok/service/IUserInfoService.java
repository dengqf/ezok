package com.ezok.service;

import com.ezok.model.UserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-24
 * Time: 下午9:55
 * To change this template use File | Settings | File Templates.
 */
public interface IUserInfoService {

    UserInfo getUserInfo(String userName);

    Integer addUserInfo(UserInfo userInfo);

    Integer saveUserInfo(UserInfo userInfo);


}
