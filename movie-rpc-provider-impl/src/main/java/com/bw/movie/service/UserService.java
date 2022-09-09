package com.bw.movie.service;

import com.bw.movie.rpc.pojo.User;

/**
 * Created by xyj on 2018/7/18.
 */
public interface UserService {

    /**
     * 注册
     *
     * @param user
     * @return
     */
    int register(User user);


    /**
     * 登陆
     *
     * @param phone
     * @param pwd
     * @return
     */
    User login(String phone, String pwd);

    /**
     * 2.0登陆
     *
     * @param email
     * @param pwd
     * @return
     */
    User loginV2(String email, String pwd);

    /**
     * 登陆
     *
     * @param userId
     * @return
     */
    User login(int userId);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     */
    User findUserByUserId(int userId);

    /**
     * 修改用户头像信息
     *
     * @param userId
     * @param headPic
     * @return
     */
    int updateUserHeadPic(int userId, String headPic);

    /**
     * 修改用户密码
     *
     * @param userId
     * @param newPwd
     * @param oldPwd
     * @return
     */
    int updateUserPwd(int userId, String newPwd, String oldPwd);

    /**
     * 判断手机号是否可用
     *
     * @param phone
     * @return
     */
    int checkPhone(String phone);

    /**
     * 判断用户昵称是否可用
     *
     * @param nickName
     * @return
     */
    int checkNickName(String nickName);

    /**
     * 判断邮箱是否可用
     *
     * @param email
     * @return
     */
    int checkEmail(String email);

    /**
     * 修改用户手机号
     *
     * @param userId
     * @param phone
     * @return
     */
    int updateUserPhone(int userId, String phone);

    /**
     * 修改用户生日
     *
     * @param userId
     * @param birthday
     * @return
     */
    int updateUserBirthday(int userId, String birthday);

}
