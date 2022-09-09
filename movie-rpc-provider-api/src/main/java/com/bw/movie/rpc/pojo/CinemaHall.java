package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 17:23 2019/7/15
 */
public class CinemaHall implements Serializable {

    private int id;

    private int cinemaId;

    private String screeningHall;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getScreeningHall() {
        return screeningHall;
    }

    public void setScreeningHall(String screeningHall) {
        this.screeningHall = screeningHall;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CinemaHall{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", screeningHall='" + screeningHall + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
