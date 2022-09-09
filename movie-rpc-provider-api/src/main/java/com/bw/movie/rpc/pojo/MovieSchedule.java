package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/7/26.
 */
public class MovieSchedule implements Serializable {

    private static final long serialVersionUID = -2213287402212798650L;

    private int id;
    private int movieId;
    private int cinemasId;
    private int hallId;
    private String screeningHall;
    private Date beginTime;
    private Date endTime;
    private int seatsTotal;
    private int seatsUseCount;
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

    public int getCinemasId() {
        return cinemasId;
    }

    public void setCinemasId(int cinemasId) {
        this.cinemasId = cinemasId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getScreeningHall() {
        return screeningHall;
    }

    public void setScreeningHall(String screeningHall) {
        this.screeningHall = screeningHall;
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

    public int getSeatsTotal() {
        return seatsTotal;
    }

    public void setSeatsTotal(int seatsTotal) {
        this.seatsTotal = seatsTotal;
    }

    public int getSeatsUseCount() {
        return seatsUseCount;
    }

    public void setSeatsUseCount(int seatsUseCount) {
        this.seatsUseCount = seatsUseCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MovieSchedule{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", cinemasId=" + cinemasId +
                ", hallId=" + hallId +
                ", screeningHall='" + screeningHall + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", seatsTotal=" + seatsTotal +
                ", seatsUseCount=" + seatsUseCount +
                ", createTime=" + createTime +
                '}';
    }
}
