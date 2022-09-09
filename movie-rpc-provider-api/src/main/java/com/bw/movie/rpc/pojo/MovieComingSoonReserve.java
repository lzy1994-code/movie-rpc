package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 10:41 2019/7/8
 */
public class MovieComingSoonReserve implements Serializable {

    private int id;

    private int userId;

    private int movieId;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MovieComingSoonReserve{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", createTime=" + createTime +
                '}';
    }
}
