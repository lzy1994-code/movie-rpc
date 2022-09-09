package com.bw.movie.dao;

import com.bw.movie.rpc.vo.MovieActorVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:10 2019/7/10
 */
public interface MovieActorMapper {
    /**
     * 2.0 查询电影演员信息
     *
     * @param movieId
     * @return
     */
    List<MovieActorVo> findMovieActor(int movieId);

}
