package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:57 2019/7/19
 */
public class UserReserveVo implements Serializable {

    private int movieId;

    private String name;

    private String imageUrl;

    private Date releaseTime;

    private int wantSeeNum;

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

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getWantSeeNum() {
        return wantSeeNum;
    }

    public void setWantSeeNum(int wantSeeNum) {
        this.wantSeeNum = wantSeeNum;
    }

    @Override
    public String toString() {
        return "UserReserveVo{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", releaseTime=" + releaseTime +
                ", wantSeeNum=" + wantSeeNum +
                '}';
    }
}
