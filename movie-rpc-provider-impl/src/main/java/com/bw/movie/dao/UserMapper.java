package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(User user);

    User login(@Param("phone") String phone, @Param("pwd") String pwd);

    int updateLoginTime(int userId);

    int updateUser(User user);

    User findUserByUserId(int userId);

    int updateUserHeadPic(@Param("userId") int userId, @Param("headPic") String headPic);

    int updateUserPwd(@Param("userId") int userId, @Param("newPwd") String newPwd, @Param("oldPwd") String oldPwd);

    int checkPhone(String phone);

    int checkNickName(String nickName);

    int checkEmail(String email);

    User loginV2(@Param("email") String email, @Param("pwd") String pwd);

    int updateUserPhone(@Param("userId") int userId, @Param("phone") String phone);

    int updateUserBirthday(@Param("userId") int userId, @Param("birthday") String birthday);


}