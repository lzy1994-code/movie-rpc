package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 16:11 2019/7/19
 */
public class UserSeenMovieRecordVo implements Serializable {

    private int recordId;

    private int movieId;

    private int cinemaId;

    private String movieName;
    //电影图片
    private String imageUrl;

    private Date beginTime;

    private Date endTime;

    private int whetherComment;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getWhetherComment() {
        return whetherComment;
    }

    public void setWhetherComment(int whetherComment) {
        this.whetherComment = whetherComment;
    }

    @Override
    public String toString() {
        return "UserSeenMovieRecordVo{" +
                "recordId=" + recordId +
                ", movieId=" + movieId +
                ", cinemaId=" + cinemaId +
                ", movieName='" + movieName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", whetherComment=" + whetherComment +
                '}';
    }
}
