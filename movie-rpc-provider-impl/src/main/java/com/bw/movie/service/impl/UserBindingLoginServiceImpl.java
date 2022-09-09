package com.bw.movie.service.impl;

import com.bw.movie.dao.UserBindingLoginMapper;
import com.bw.movie.rpc.pojo.UserBindingLogin;
import com.bw.movie.service.UserBindingLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/8/10.
 */
@Service("userBindingLoginService")
public class UserBindingLoginServiceImpl implements UserBindingLoginService {

    @Resource
    private UserBindingLoginMapper userBindingLoginMapper;

    @Override
    public int saveUserBindingLogin(UserBindingLogin userBindingLogin) {
        return userBindingLoginMapper.saveUserBindingLogin(userBindingLogin);
    }

    @Override
    public UserBindingLogin findUserBindingByOpenId(String openId) {
        return userBindingLoginMapper.findUserBindingByOpenId(openId);
    }

    @Override
    public UserBindingLogin findUserBindingByUserId(int userId) {
        return userBindingLoginMapper.findUserBindingByUserId(userId);
    }
}
