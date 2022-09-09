package com.bw.movie.service;

import com.bw.movie.rpc.pojo.Cinemas;
import com.bw.movie.rpc.vo.CinemasVo;
import com.bw.movie.rpc.vo.MyCinemaCommentVo;

import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
public interface CinemaService {

    /**
     * 查询用户关注的影院信息
     *
     * @param userId
     * @return
     */
    List<CinemasVo> findCinemaListByUserId(int userId);

    /**
     * 查询推荐影院
     *
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
     * 分页查询所有影院信息
     *
     * @param page
     * @param count
     * @param cinemaName
     * @return
     */
    List<CinemasVo> findAllCinemas(int page, int count, String cinemaName);

    /**
     * 分页查询用户关注的影院信息
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
     * 根据id集合查询多个影院信息
     *
     * @param list
     * @return
     */
    List<CinemasVo> findCinemasByIds(List<Integer> list);

    CinemasVo findCinemaById(int cinemaId);

    Cinemas findCinemasByName(String name);


    /**
     * 2.0 根据区域查询影院
     *
     * @param regionId
     * @return
     */
    List<Cinemas> findCinemaByRegion(int regionId);

    /**
     * 2.0 查询我的影院评论
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<MyCinemaCommentVo> findMyCinemaCommentList(int userId, String longitude, String latitude, int page, int count);


}
