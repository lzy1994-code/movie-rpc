package com.bw.movie.service;

import com.bw.movie.rpc.vo.UserReserveVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 10:45 2019/7/8
 */
public interface MovieComingSoonReserveService {
    /**
     * 2.0 预约
     *
     * @param userId
     * @param movieId
     * @return
     */
    int reserve(int userId, int movieId);

    /**
     * 2.0 是否预约
     *
     * @param userId
     * @param movieId
     * @return
     */
    int whetherReserve(int userId, int movieId);

    /**
     * 2.0 预约数
     *
     * @param movieId
     * @return
     */
    int reserveNum(int movieId);


    /**
     * 2.0 查询用户预约电影信息
     *
     * @param userId
     * @return
     */
    List<UserReserveVo> findUserReserve(int userId);
}
