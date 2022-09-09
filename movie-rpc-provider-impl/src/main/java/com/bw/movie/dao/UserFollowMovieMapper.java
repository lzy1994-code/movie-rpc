package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.UserFollowMovie;
import com.bw.movie.rpc.vo.UserFollowMovieVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/7/23.
 */
public interface UserFollowMovieMapper {

    int findFollowMovie(@Param("userId") int userId, @Param("movieId") int movieId);

    List<UserFollowMovieVo> findFollowMovieList(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

    int followMovie(@Param("userId") int userId, @Param("movieId") int movieId);

    int cancelFollowMovie(@Param("userId") int userId, @Param("movieId") int movieId);

}
