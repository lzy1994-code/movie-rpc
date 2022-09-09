package com.bw.movie.service;

import com.bw.movie.rpc.pojo.MovieSchedule;
import com.bw.movie.rpc.vo.CinemaScheduleVo;
import com.bw.movie.rpc.vo.MovieCinemaScheduleVo;
import com.bw.movie.rpc.vo.MovieScheduleVo;

import java.util.List;

/**
 * Created by xyj on 2018/7/26.
 */
public interface MovieScheduleService {

    /**
     * 根据电影ID和影院ID查询电影排期列表
     *
     * @param movieId
     * @param cinemasId
     * @return
     */
    List<MovieScheduleVo> findMovieScheduleList(int movieId, int cinemasId);

    /**
     * 根据排期ID查询排期对象信息
     *
     * @param id
     * @return
     */
    MovieSchedule findMovieScheduleById(int id);

    /**
     * 根据电影ID查询影院ID集合
     *
     * @param movieId
     * @return
     */
    List<Integer> findCinemasByMovieId(int movieId);

    /**
     * 根据影院ID查询电影ID集合
     *
     * @param cinemaId
     * @return
     */
    List<Integer> findMoviesByCinemaId(int cinemaId);


    /**
     * 2.0 查询影院下的电影排期
     *
     * @param cinemaId
     * @param page
     * @param count
     * @return
     */
    List<CinemaScheduleVo> findCinemaScheduleList(int cinemaId, int page, int count);

    /**
     * 2.0 根据电影ID和影院ID查询电影排期列表
     *
     * @param movieId
     * @param cinemaId
     * @return
     */
    List<MovieCinemaScheduleVo> findMovieScheduleListV2(int movieId, int cinemaId);


}
