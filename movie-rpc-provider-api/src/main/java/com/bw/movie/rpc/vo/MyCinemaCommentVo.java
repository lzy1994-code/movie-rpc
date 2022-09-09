package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:54 2019/8/16
 */
public class MyCinemaCommentVo implements Serializable {

    private int cinemaId;

    private String cinemaName;

    private String address;

    private String logo;

    private String longitude;

    private String latitude;

    private int distance;

    private String myCommentContent;

    private Date commentTime;

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getMyCommentContent() {
        return myCommentContent;
    }

    public void setMyCommentContent(String myCommentContent) {
        this.myCommentContent = myCommentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "MyCinemaCommentVo{" +
                "cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", address='" + address + '\'' +
                ", logo='" + logo + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", distance=" + distance +
                ", myCommentContent='" + myCommentContent + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
