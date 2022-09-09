package com.bw.movie.dao;

import java.util.List;

public interface MoviePosterMapper {

    List<String> findMoviePosters(int movieId);

}