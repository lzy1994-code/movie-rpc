package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 16:57 2019/7/16
 */
public class CinemaHallSeatVo implements Serializable {


    //行
    private String row;
    //座位
    private String seat;
    //状态
    private int status;

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

    @Override
    public String toString() {
        return "CinemaHallSeatVo{" +
                "row='" + row + '\'' +
                ", seat='" + seat + '\'' +
                ", status=" + status +
                '}';
    }
}
