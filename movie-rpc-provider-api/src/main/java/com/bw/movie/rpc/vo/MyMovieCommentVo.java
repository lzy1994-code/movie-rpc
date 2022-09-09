package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:47 2019/8/16
 */
public class MyMovieCommentVo implements Serializable {

    private int movieId;

    private String movieName;

    private String director;

    private String starring;

    private String imageUrl;

    private double movieScore;

    private String myCommentContent;

    private double myCommentScore;

    private Date commentTime;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(double movieScore) {
        this.movieScore = movieScore;
    }

    public String getMyCommentContent() {
        return myCommentContent;
    }

    public void setMyCommentContent(String myCommentContent) {
        this.myCommentContent = myCommentContent;
    }

    public double getMyCommentScore() {
        return myCommentScore;
    }

    public void setMyCommentScore(double myCommentScore) {
        this.myCommentScore = myCommentScore;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "MyMovieCommentVo{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", director='" + director + '\'' +
                ", starring='" + starring + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", movieScore=" + movieScore +
                ", myCommentContent='" + myCommentContent + '\'' +
                ", myCommentScore=" + myCommentScore +
                ", commentTime=" + commentTime +
                '}';
    }
}
