package com.bw.movie.service.impl;


import com.bw.movie.dao.UserMapper;
import com.bw.movie.rpc.pojo.User;
import com.bw.movie.service.UserService;
import com.bw.movie.utils.ConfigInfo;
import com.bw.movie.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger("UserService");

    @Resource
    private UserMapper userMapper;

    @Override
    public int register(User user) {

        if (user.getPwd() == null || "".equals(user.getPwd())) {
            return 0;
        }

        String pwd = user.getPwd();
        pwd = Util.conversionPwd(pwd);
        if (pwd == null || "".equals(pwd)) {
            logger.error("register 密码处理异常");
            return 0;
        }

        user.setPwd(pwd);
        user.setSex(1);

        //设置默认头像
        if (user.getHeadPic() == null || "".equals(user.getHeadPic())) {
            user.setHeadPic(ConfigInfo.getConfigInfo().getHeadUrl());
        }
        return userMapper.insert(user);
    }


    @Override
    public User login(String phone, String pwd) {
        pwd = Util.conversionPwd(pwd);
        User user = userMapper.login(phone, pwd);
        if (user == null) {
            return null;
        }
        userMapper.updateLoginTime(user.getId());
        return user;
    }

    @Override
    public User loginV2(String email, String pwd) {
        pwd = Util.conversionPwd(pwd);
        User user = userMapper.loginV2(email, pwd);
        if (user == null) {
            return null;
        }
        userMapper.updateLoginTime(user.getId());
        return user;
    }


    @Override
    public User login(int userId) {
        User user = userMapper.findUserByUserId(userId);
        if (user == null) {
            return null;
        }
        userMapper.updateLoginTime(user.getId());
        return user;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User findUserByUserId(int userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public int updateUserHeadPic(int userId, String headPic) {
        return userMapper.updateUserHeadPic(userId, headPic);
    }

    @Override
    public int updateUserPwd(int userId, String newPwd, String oldPwd) {
        newPwd = Util.conversionPwd(newPwd);
        oldPwd = Util.conversionPwd(oldPwd);
        return userMapper.updateUserPwd(userId, newPwd, oldPwd);
    }

    @Override
    public int checkPhone(String phone) {
        return userMapper.checkPhone(phone);
    }

    @Override
    public int checkNickName(String nickName) {
        return userMapper.checkNickName(nickName);
    }

    @Override
    public int checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override
    public int updateUserPhone(int userId, String phone) {
        return userMapper.updateUserPhone(userId, phone);
    }

    @Override
    public int updateUserBirthday(int userId, String birthday) {
        return userMapper.updateUserBirthday(userId, birthday);
    }

}
