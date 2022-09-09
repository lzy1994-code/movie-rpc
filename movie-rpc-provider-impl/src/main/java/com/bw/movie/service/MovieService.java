package com.bw.movie.service;

import com.bw.movie.rpc.pojo.Movies;
import com.bw.movie.rpc.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
public interface MovieService {

    List<MovieListVo> findMovieListByUserId(int userId);

    /**
     * 查询热门电影列表
     *
     * @return
     */
    List<MovieVo> findHotMovieList(int userId, int page, int count);

    /**
     * 查询正在上映电影列表
     *
     * @return
     */
    List<MovieVo> findReleaseMovieList(int userId, int page, int count);

    /**
     * 查询即将上映电影列表
     *
     * @return
     */
    List<MovieVo> findComingSoonMovieList(int userId, int page, int count);

    /**
     * 根据电影ID查询电影信息
     *
     * @param movieId
     * @return
     */
    Movies findMoviesById(int movieId);

    /**
     * 查看电影详情
     *
     * @param movieId
     * @return
     */
    MovieVo findMoviesDetail(int userId, int movieId);

    /**
     * 分页查询用户关注的影片列表
     *
     * @param userId
     * @return
     */
    List<MovieListVo> findMoviePageList(int userId, int page, int count);

    /**
     * 关注电影
     *
     * @param userId
     * @param movieId
     * @return
     */
    int followMovie(int userId, int movieId);

    /**
     * 取消关注电影
     *
     * @param userId
     * @param movieId
     * @return
     */
    int cancelFollowMovie(int userId, int movieId);

    /**
     * 根据电影ID集合查询电影信息列表
     *
     * @param list
     * @return
     */
    List<MovieListVo> findMoviesByIds(List<Integer> list);

    /**
     * 根据影院ID查询该影院即将上映的电影列表
     *
     * @param cinemaId
     * @return
     */
    List<MovieListVo> findSoonMovieByCinemaId(int cinemaId);

    /**
     * 2.0 查询热门电影列表
     *
     * @param page
     * @param count
     * @return
     */
    List<MovieInfoVo> findHotMovieInfoList(int page, int count);

    /**
     * 2.0 查询正在上映电影列表
     *
     * @param page
     * @param count
     * @return
     */
    List<MovieInfoVo> findReleaseMovieInfoList(int page, int count);

    /**
     * 2.0 查询即将上映电影列表
     *
     * @param page
     * @param count
     * @return
     */
    List<ComingSoonMovieVo> findComingSoonMovieInfoList(int page, int count);

    /**
     * 2.0 查询电影详情
     *
     * @param userId
     * @param movieId
     * @return
     */
    MovieDetailVo findMoviesDetailById(int userId, int movieId);


    /**
     * 2.0 根据电影id,区域id 查询播放影院信息
     *
     * @param movieId
     * @param regionId
     */
    List<CinemaVo> findCinemasInfo(int movieId, int regionId, int page, int count);

    /**
     * 2.0 根据电影id，时间 查询播放影院信息
     *
     * @param movieId
     * @return
     */
    List<CinemaVo> findCinemasInfoByDate(int movieId, int page, int count);


    /**
     * 2.0 根据电影id,价格查询播放影院信息
     *
     * @param movieId
     * @return
     */
    List<CinemaVo> findCinemasInfoByPrice(int movieId, int page, int count);

    /**
     * 2.0 根据关键字查询电影信息
     */
    List<MovieInfoVo> findMovieByKeyword(String keyword, int page, int count);


    /**
     * 2.0 查询我的电影评论
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<MyMovieCommentVo> findMyMovieCommentList(int userId, int page, int count);


}
