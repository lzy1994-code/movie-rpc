package com.bw.movie.dao;

import com.bw.movie.rpc.vo.ShortFilmVo;

import java.util.List;

public interface MovieShortFilmMapper {
    List<ShortFilmVo> findMovieShortFilms(int movieId);
}