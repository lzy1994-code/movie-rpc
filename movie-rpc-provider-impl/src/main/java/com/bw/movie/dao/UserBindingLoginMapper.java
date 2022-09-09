package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.UserBindingLogin;

/**
 * Created by xyj on 2018/8/10.
 */
public interface UserBindingLoginMapper {

    int saveUserBindingLogin(UserBindingLogin userBindingLogin);

    UserBindingLogin findUserBindingByOpenId(String openId);

    UserBindingLogin findUserBindingByUserId(int userId);

}
