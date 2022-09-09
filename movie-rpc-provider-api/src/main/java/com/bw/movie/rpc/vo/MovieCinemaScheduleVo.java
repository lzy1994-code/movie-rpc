package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 16:05 2019/7/16
 */
public class MovieCinemaScheduleVo implements Serializable {


    private int id;
    //放映厅id
    private int hallId;
    //放映厅
    private String screeningHall;
    //放映开始时间
    private String beginTime;
    //放映结束时间
    private String endTime;
    //价格
    private double fare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "MovieCinemaScheduleVo{" +
                "id=" + id +
                ", hallId=" + hallId +
                ", screeningHall='" + screeningHall + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", fare=" + fare +
                '}';
    }
}
