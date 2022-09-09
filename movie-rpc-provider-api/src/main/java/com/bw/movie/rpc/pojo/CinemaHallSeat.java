package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 17:24 2019/7/15
 */
public class CinemaHallSeat implements Serializable {

    private int id;

    private int hallId;

    private String row;

    private String seat;

    private int status;

    private Date createTime;

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

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CinemaHallSeat{" +
                "id=" + id +
                ", hallId=" + hallId +
                ", row='" + row + '\'' +
                ", seat='" + seat + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
