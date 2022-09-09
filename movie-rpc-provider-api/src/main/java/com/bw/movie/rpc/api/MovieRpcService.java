package com.bw.movie.rpc.api;

import com.bw.movie.rpc.pojo.Movies;
import com.bw.movie.rpc.vo.*;
import com.bw.movie.rpc.pojo.*;

import java.util.List;

/**
 * Created by xyj on 2018/7/16.
 */
public interface MovieRpcService {

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
     * 查询用户关注的影片列表
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
     * 根据影院ID查询该影院当前排期的电影列表
     *
     * @param cinemaId
     * @return
     */
    List<MovieListVo> findMovieListByCinemaId(int cinemaId);

    /**
     * 根据电影ID查询当前排片该电影的影院列表
     *
     * @param movieId
     * @return
     */
    List<CinemasVo> findCinemasListByMovieId(int movieId);

    /**
     * 根据电影ID和影院ID查询电影排期列表
     *
     * @param movieId
     * @param cinemasId
     * @return
     */
    List<MovieScheduleVo> findMovieScheduleList(int movieId, int cinemasId);

    /**
     * 购买电影票
     *
     * @param userId
     * @param scheduleId
     * @param amount
     * @param sign
     * @return
     */
    String buyMovieTicket(int userId, int scheduleId, int amount, String sign);

    /**
     * 支付
     *
     * @param orderId
     * @param payType
     * @param ip
     * @return
     */
    String pay(String orderId, int payType, String ip);

    /**
     * 出票
     *
     * @param orderId
     * @return
     */
    String ticketing(String orderId);

    /**
     * 电影评论查询
     *
     * @param movieId
     */
    List<MovieCommentVo> findAllMovieComment(int userId, int movieId, int page, int count);

    /**
     * 增加评论
     *
     * @param movieComment
     * @return
     */
    int saveMovieComment(MovieComment movieComment);

    /**
     * 查询评论下的回复
     *
     * @param commentId
     * @return
     */
    List<MovieCommentReplyVo> findAllCommentReply(int commentId, int page, int count);

    /**
     * 增加评论回复
     *
     * @param movieCommentReply
     */
    boolean addCommentReply(MovieCommentReply movieCommentReply);

    /**
     * 影片评论总数
     *
     * @param movieId
     * @return
     */
    int movieCommentTotal(int movieId);

    /**
     * 通过用户id查询评论信息
     *
     * @param userId
     * @param movieId
     * @return
     */
    MovieComment findCommentById(int movieId, int userId);

    /**
     * 通过id查询回复信息
     *
     * @param userId
     * @param commentId
     * @return
     */
    MovieCommentReply findCommentReplyById(int commentId, int userId);

    /**
     * 判断影片评论是否点赞
     *
     * @param commentId
     * @param userId
     * @return
     */
    int whetherMovieGreat(int commentId, int userId);

    /**
     * 保存点赞信息
     *
     * @param movieCommentGreat
     */
    boolean saveMovieCommentGreat(MovieCommentGreat movieCommentGreat);

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
    List<ComingSoonMovieVo> findComingSoonMovieInfoList(int userId, int page, int count);

    /**
     * 2.0 预约
     *
     * @param userId
     * @param movieId
     * @return
     */
    int reserve(int userId, int movieId);

    /**
     * 2.0 查询电影详情
     *
     * @param userId
     * @param movieId
     * @return
     */
    MovieDetailVo findMoviesDetailById(int userId, int movieId);

    /**
     * 2.0 根据电影的id查询电影评论
     *
     * @param movieId
     * @param page
     * @param count
     * @return
     */
    List<MovieCommentVos> findAllMovieCommentById(int userId, int movieId, int page, int count);

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
     * 2.0 根据影厅id 查询座位信息
     *
     * @param hallId
     * @return
     */
    List<CinemaHallSeatVo> findSeatInfo(int hallId);

    /**
     * 2.0 修改座位状态
     *
     * @param hallId
     * @param row
     * @param seat
     * @return
     */
    int updateSeatStatus(int hallId, int row, int seat, int status);

    /**
     * 2.0 根据关键字查询电影信息
     */
    List<MovieInfoVo> findMovieByKeyword(String keyword, int page, int count);


    /**
     * 2.0 购票
     */
    String buyMovieTickets(int userId, int scheduleId, String seat, int amount);

    /**
     * 2.0 生成兑换码
     *
     * @param orderId
     * @return
     */
    String outTicket(String orderId) throws Exception;

    /**
     * 2.0 根据电影ID和影院ID查询电影排期列表
     *
     * @param movieId
     * @param cinemasId
     * @return
     */
    List<MovieCinemaScheduleVo> findMovieScheduleListV2(int movieId, int cinemasId);

}
