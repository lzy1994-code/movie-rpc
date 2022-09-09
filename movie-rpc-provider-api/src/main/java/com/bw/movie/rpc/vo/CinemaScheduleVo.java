package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description: 影院电影排期
 * @Date: Create in 14:54 2019/7/15
 */
public class CinemaScheduleVo implements Serializable {

    private int movieId;

    private String name;

    private String imageUrl;

    private String director;

    private String starring;

    private double score;

    private String trailerUrl;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Override
    public String toString() {
        return "CinemaScheduleVo{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", director='" + director + '\'' +
                ", starring='" + starring + '\'' +
                ", score=" + score +
                ", trailerUrl='" + trailerUrl + '\'' +
                '}';
    }
}
