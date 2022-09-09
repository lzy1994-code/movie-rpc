package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/7/18.
 */
public class UserExtend implements Serializable {

    private int id;
    private int userId;
    private String ak;
    private String imei;
    private String ua;
    private String screenSize;
    private String os;
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

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserExtend{" +
                "id=" + id +
                ", userId=" + userId +
                ", ak='" + ak + '\'' +
                ", imei='" + imei + '\'' +
                ", ua='" + ua + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", os='" + os + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
