package com.bw.movie.service.impl;

import com.bw.movie.dao.MovieScheduleMapper;
import com.bw.movie.dao.MovieShortFilmMapper;
import com.bw.movie.rpc.pojo.MovieSchedule;
import com.bw.movie.rpc.vo.CinemaScheduleVo;
import com.bw.movie.rpc.vo.MovieCinemaScheduleVo;
import com.bw.movie.rpc.vo.MovieScheduleVo;
import com.bw.movie.rpc.vo.ShortFilmVo;
import com.bw.movie.service.MovieScheduleService;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 2018/7/26.
 */
@Service("movieScheduleService")
public class MovieScheduleServiceImpl implements MovieScheduleService {

    @Resource
    private MovieScheduleMapper movieScheduleMapper;

    @Resource
    private MovieShortFilmMapper movieShortFilmMapper;

    @Override
    public List<MovieScheduleVo> findMovieScheduleList(int movieId, int cinemasId) {
        return movieScheduleMapper.findMovieScheduleList(movieId, cinemasId);
    }

    @Override
    public MovieSchedule findMovieScheduleById(int id) {
        return movieScheduleMapper.findMovieScheduleById(id);
    }

    @Override
    public List<Integer> findCinemasByMovieId(int movieId) {
        return movieScheduleMapper.findCinemasByMovieId(movieId);
    }

    @Override
    public List<Integer> findMoviesByCinemaId(int cinemaId) {
        return movieScheduleMapper.findMoviesByCinemaId(cinemaId);
    }

    @Override
    public List<CinemaScheduleVo> findCinemaScheduleList(int cinemaId, int page, int count) {
        List<CinemaScheduleVo> cinemaScheduleList = movieScheduleMapper.findCinemaScheduleList(cinemaId, Util.getPageIndex(page, count), count);
        for (CinemaScheduleVo cs : cinemaScheduleList) {
            List<ShortFilmVo> movieShortFilms = movieShortFilmMapper.findMovieShortFilms(cs.getMovieId());
            cs.setTrailerUrl(movieShortFilms.get(0).getVideoUrl());
        }
        if (cinemaScheduleList.isEmpty()) {
            return new ArrayList<>();
        }
        return cinemaScheduleList;
    }

    @Override
    public List<MovieCinemaScheduleVo> findMovieScheduleListV2(int movieId, int cinemaId) {
        List<MovieCinemaScheduleVo> schedule = movieScheduleMapper.findMovieScheduleListV2(movieId, cinemaId);
        if (schedule.isEmpty()) {
            return new ArrayList<>();
        }
        return schedule;
    }
}
