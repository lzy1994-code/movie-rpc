package com.bw.movie.service;

/**
 * Created by xyj on 2018/7/19.
 */
public interface UserSignService {

    int addUserSign(int userId);

    /**
     * 查看今天是否签到
     *
     * @param userId
     * @return
     */
    int getUserDaySign(int userId);

}
