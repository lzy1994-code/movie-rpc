package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:49 2019/8/31
 */
public class MySeenMovieCommentVo implements Serializable {


    //影片的评论
    private int movieId;

    private String movieName;

    private String movieCommentContent;

    private double score;

    //影院的评论
    private int cinemaId;

    private String cinemaName;

    private String cinemaCommentContent;


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCommentContent() {
        return movieCommentContent;
    }

    public void setMovieCommentContent(String movieCommentContent) {
        this.movieCommentContent = movieCommentContent;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaCommentContent() {
        return cinemaCommentContent;
    }

    public void setCinemaCommentContent(String cinemaCommentContent) {
        this.cinemaCommentContent = cinemaCommentContent;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public String toString() {
        return "MySeenMovieCommentVo{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieCommentContent='" + movieCommentContent + '\'' +
                ", score=" + score +
                ", cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaCommentContent='" + cinemaCommentContent + '\'' +
                '}';
    }
}
