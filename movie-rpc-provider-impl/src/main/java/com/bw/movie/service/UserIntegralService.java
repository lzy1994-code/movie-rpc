package com.bw.movie.service;

/**
 * Created by xyj on 2018/7/19.
 */
public interface UserIntegralService {

    /**
     * 增加积分
     *
     * @param userId
     * @param integral
     * @return
     */
    int addIntegral(int userId, int integral);

    /**
     * 减少积分
     *
     * @param userId
     * @param integral
     * @return
     */
    int reduceIntegral(int userId, int integral);

    /**
     * 获取用户积分
     *
     * @param userId
     * @return
     */
    int getUserIntegral(int userId);

}
