package com.ezok.service.impl;

import com.ezok.mapper.UserInfoMapper;
import com.ezok.model.UserInfo;
import com.ezok.model.UserInfoExample;
import com.ezok.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-24
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(String userName) {
        UserInfoExample example = new UserInfoExample();
        example.or().andUsernameEqualTo(userName);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userInfos)) {
            return null;
        }
        return userInfos.get(0);
    }

    @Override
    public Integer addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public Integer saveUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
