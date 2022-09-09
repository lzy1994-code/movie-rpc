package com.bw.movie.dao;

import com.bw.movie.rpc.vo.UserReserveVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 10:43 2019/7/8
 */
public interface MovieComingSoonReserveMapper {
    /**
     * 2.0 预约
     *
     * @param userId
     * @param movieId
     * @return
     */
    int addReserve(@Param("userId") int userId, @Param("movieId") int movieId);

    /**
     * 2.0 是否预约
     *
     * @param userId
     * @param movieId
     * @return
     */
    int whetherReserve(@Param("userId") int userId, @Param("movieId") int movieId);

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
