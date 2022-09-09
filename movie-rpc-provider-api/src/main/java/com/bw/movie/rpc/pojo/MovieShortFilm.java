package com.bw.movie.rpc.pojo;

import java.util.Date;

public class MovieShortFilm {
    private int id;

    private int movieId;

    private String shortFilmUrl;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getShortFilmUrl() {
        return shortFilmUrl;
    }

    public void setShortFilmUrl(String shortFilmUrl) {
        this.shortFilmUrl = shortFilmUrl == null ? null : shortFilmUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}