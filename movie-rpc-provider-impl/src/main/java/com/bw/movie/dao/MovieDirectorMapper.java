package com.bw.movie.dao;

import com.bw.movie.rpc.vo.MovieDirectorVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:03 2019/7/10
 */
public interface MovieDirectorMapper {
    /**
     * 查询电影导演信息
     *
     * @param movieId
     * @return
     */
    List<MovieDirectorVo> findMovieDirector(int movieId);

}
