package com.bw.movie.rpc.api;

import com.bw.movie.rpc.pojo.CinemaComment;
import com.bw.movie.rpc.pojo.CinemaCommentGreat;
import com.bw.movie.rpc.pojo.Cinemas;
import com.bw.movie.rpc.vo.CinemaCommentVo;
import com.bw.movie.rpc.vo.CinemaScheduleVo;
import com.bw.movie.rpc.vo.CinemasVo;

import java.util.List;

/**
 * Created by xyj on 2018/7/17.
 */
public interface CinemaRpcService {

    /**
     * 查询推荐影院信息
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<CinemasVo> findRecommendCinemas(int userId, int page, int count);

    /**
     * 查询附近影院
     *
     * @param userId
     * @param longitude
     * @param latitude
     * @param page
     * @param count
     * @return
     */
    List<CinemasVo> findNearbyCinemas(int userId, String longitude, String latitude, int page, int count);

    /**
     * 查询影院详细信息
     *
     * @param cinemaId
     * @return
     */
    CinemasVo findCinemaInfo(int userId, int cinemaId);

    /**
     * 查询所有影院信息
     *
     * @param page
     * @param count
     * @param cinemaName
     * @return
     */
    List<CinemasVo> findAllCinemas(int page, int count, String cinemaName);

    /**
     * 查询用户关注的影院信息
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<CinemasVo> findCinemaPageList(int userId, int page, int count);

    /**
     * 关注电影院
     *
     * @param userId
     * @param cinemaId
     * @return
     */
    int followCinema(int userId, int cinemaId);

    /**
     * 取消关注电影院
     *
     * @param userId
     * @param cinemaId
     * @return
     */
    int cancelFollowCinema(int userId, int cinemaId);

    /**
     * 查询影院评论
     *
     * @param cinemaId
     * @param page
     * @param count
     * @return
     */
    List<CinemaCommentVo> findAllCinemaComment(int userId, int cinemaId, int page, int count);

    /**
     * 保存用户对影院的评论
     *
     * @param cinemaComment
     */
    int saveCinemaComment(CinemaComment cinemaComment);

    /**
     * 查找影院评论总数
     *
     * @param cinemaId
     * @return
     */
    int commentTotal(int cinemaId);

    /**
     * 通过用户Id,影院id查找评论内容
     *
     * @param userId
     * @return
     */
    CinemaComment findCommentById(int cinemaId, int userId);

    /**
     * 保存点赞信息
     *
     * @param cinemaCommentGreat
     */
    boolean saveCinemaCommentGreat(CinemaCommentGreat cinemaCommentGreat);


    /**
     * 判断影院评论是否点赞
     *
     * @param commentId
     * @param userId
     * @return
     */
    int whetherCinemaGreat(int commentId, int userId);


    /**
     * 2.0 根据区域查询影院
     *
     * @param regionId
     * @return
     */
    List<Cinemas> findCinemaByRegion(int regionId);

    /**
     * 2.0 查询影院下的电影排期
     */
    List<CinemaScheduleVo> findCinemaScheduleList(int cinemaId, int page, int count);

}
