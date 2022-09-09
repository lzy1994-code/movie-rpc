package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:47 2019/7/8
 */
public class ComingSoonMovieVo implements Serializable {

    private int movieId;

    private String name;

    private String horizontalImage;

    private String imageUrl;

    private Date releaseTime;

    private int wantSeeNum;

    private int whetherReserve;

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

    public String getHorizontalImage() {
        return horizontalImage;
    }

    public void setHorizontalImage(String horizontalImage) {
        this.horizontalImage = horizontalImage;
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

    public int getWhetherReserve() {
        return whetherReserve;
    }

    public void setWhetherReserve(int whetherReserve) {
        this.whetherReserve = whetherReserve;
    }

    @Override
    public String toString() {
        return "ComingSoonMovieVo{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", horizontalImage='" + horizontalImage + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", releaseTime=" + releaseTime +
                ", wantSeeNum=" + wantSeeNum +
                ", whetherReserve=" + whetherReserve +
                '}';
    }
}
