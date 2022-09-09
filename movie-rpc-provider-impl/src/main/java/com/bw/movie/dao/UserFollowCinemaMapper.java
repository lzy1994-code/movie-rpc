package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.UserFollowCinema;
import com.bw.movie.rpc.vo.UserFollowCinemaVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/7/23.
 */
public interface UserFollowCinemaMapper {

    int findFollowCinema(@Param("userId") int userId, @Param("cinemaId") int cinemaId);

    List<UserFollowCinemaVo> findFollowCinemaList(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

    List<Integer> findFollowCinemaIdList(int userId);

    int followCinema(@Param("userId") int userId, @Param("cinemaId") int cinemaId);

    int cancelFollowCinema(@Param("userId") int userId, @Param("cinemaId") int cinemaId);

}
