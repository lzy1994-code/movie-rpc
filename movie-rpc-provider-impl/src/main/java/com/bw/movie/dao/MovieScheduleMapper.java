package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.MovieSchedule;
import com.bw.movie.rpc.vo.CinemaScheduleVo;
import com.bw.movie.rpc.vo.MovieCinemaScheduleVo;
import com.bw.movie.rpc.vo.MovieScheduleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/7/26.
 */
public interface MovieScheduleMapper {

    List<MovieScheduleVo> findMovieScheduleList(@Param("movieId") int movieId, @Param("cinemasId") int cinemasId);

    MovieSchedule findMovieScheduleById(int id);

    List<Integer> findCinemasByMovieId(int movieId);

    List<Integer> findMoviesByCinemaId(int cinemaId);

    /**
     * 2.0 查询影院下的电影排期
     *
     * @param cinemaId
     * @param index
     * @param count
     * @return
     */
    List<CinemaScheduleVo> findCinemaScheduleList(@Param("cinemaId") int cinemaId, @Param("index") int index, @Param("count") int count);

    /**
     * 2.0 根据电影ID和影院ID查询电影排期列表
     *
     * @param movieId
     * @param cinemasId
     * @return
     */
    List<MovieCinemaScheduleVo> findMovieScheduleListV2(@Param("movieId") int movieId, @Param("cinemasId") int cinemasId);


}
