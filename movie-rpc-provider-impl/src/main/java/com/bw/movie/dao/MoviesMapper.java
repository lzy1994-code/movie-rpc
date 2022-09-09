package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.Movies;
import com.bw.movie.rpc.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoviesMapper {

    /**
     * 查询热门电影列表
     *
     * @param index 下标
     * @param count 数量
     * @return
     */
    List<MovieVo> findHotMovieList(@Param("index") int index, @Param("count") int count);

    /**
     * 2.0 查询热门电影列表
     *
     * @param index
     * @param count
     * @return
     */
    List<MovieInfoVo> findHotMovieInfoList(@Param("index") int index, @Param("count") int count);


    /**
     * 查询正在上映电影列表
     *
     * @param index 下标
     * @param count 数量
     * @return
     */
    List<MovieVo> findReleaseMovieList(@Param("index") int index, @Param("count") int count);

    /**
     * 2.0 查询正在上映电影列表
     *
     * @param index
     * @param count
     * @return
     */
    List<MovieInfoVo> findReleaseMovieInfoList(@Param("index") int index, @Param("count") int count);

    /**
     * 查询即将上映电影列表
     *
     * @param index 下标
     * @param count 数量
     * @return
     */
    List<MovieVo> findComingSoonMovieList(@Param("index") int index, @Param("count") int count);

    /**
     * 2.0 查询即将上映电影列表
     *
     * @param index
     * @param count
     * @return
     */
    List<ComingSoonMovieVo> findComingSoonMovieInfoList(@Param("index") int index, @Param("count") int count);

    /**
     * 根据ID查询电影信息
     *
     * @param movieId
     * @return
     */
    Movies findMoviesById(int movieId);

    /**
     * 查询用户关注的电影
     *
     * @param userId
     * @return
     */
    List<MovieListVo> findMovieListByUserId(int userId);

    /**
     * 分页查询
     *
     * @param index
     * @param count
     * @param userId
     * @return
     */
    List<MovieListVo> findMoviePageList(@Param("index") int index, @Param("count") int count, @Param("userId") int userId);

    /**
     * 查询电影类型
     *
     * @param movieId
     * @return
     */
    List<String> findMovieType(int movieId);

    List<MovieListVo> findMoviesByIds(List<Integer> list);

    /**
     * 根据影院ID查询该影院即将上映的电影列表
     *
     * @param cinemaId
     * @return
     */
    List<MovieListVo> findSoonMovieByCinemaId(int cinemaId);

    /**
     * 2.0 根据ID查询电影信息
     *
     * @param movieId
     * @return
     */
    MovieDetailVo findMovieDetailById(int movieId);

    /**
     * 2.0 根据电影id,区域id 查询播放影院信息
     *
     * @param movieId
     * @param regionId
     */
    List<CinemaVo> findCinemasInfo(@Param("movieId") int movieId, @Param("regionId") int regionId, @Param("index") int index, @Param("count") int count);

    /**
     * 2.0 根据电影id，时间 查询播放影院信息
     *
     * @param movieId
     * @return
     */
    List<CinemaVo> findCinemasInfoByDate(@Param("movieId") int movieId, @Param("index") int index, @Param("count") int count);


    /**
     * 2.0 根据电影id,价格查询播放影院信息
     *
     * @param movieId
     * @return
     */
    List<CinemaVo> findCinemasInfoByPrice(@Param("movieId") int movieId, @Param("index") int index, @Param("count") int count);


    /**
     * 2.0 根据关键字查询电影信息
     */
    List<MovieInfoVo> findMovieByKeyword(@Param("keyword") String keyword, @Param("index") int index, @Param("count") int count);

    /**
     * 2.0 查询我的电影评论
     *
     * @param userId
     * @param index
     * @param count
     * @return
     */
    List<MyMovieCommentVo> findMyMovieCommentList(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);


}