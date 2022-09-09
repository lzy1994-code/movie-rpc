package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/7/17.
 */
public class CinemasVo implements Serializable {

    private int id;

    private String name;

    private String address;

    private String logo;

    private String vehicleRoute;

    private String businessHoursContent;

    private String phone;

    //经度
    private String longitude;
    //纬度
    private String latitude;

    //   private boolean followCinema;
    //是否关注影院 1=是， 2=否
    private int followCinema;

    //新增影院评论总数字段
    private int commentTotal;

    private int distance;
    // 2.0 新增影院标签
    private String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public int getFollowCinema() {
        return followCinema;
    }

    public void setFollowCinema(int followCinema) {
        this.followCinema = followCinema;
    }

    public int getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(int commentTotal) {
        this.commentTotal = commentTotal;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getVehicleRoute() {
        return vehicleRoute;
    }

    public void setVehicleRoute(String vehicleRoute) {
        this.vehicleRoute = vehicleRoute;
    }

    public String getBusinessHoursContent() {
        return businessHoursContent;
    }

    public void setBusinessHoursContent(String businessHoursContent) {
        this.businessHoursContent = businessHoursContent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public String toString() {
        return "CinemasVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", logo='" + logo + '\'' +
                ", vehicleRoute='" + vehicleRoute + '\'' +
                ", businessHoursContent='" + businessHoursContent + '\'' +
                ", phone='" + phone + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", followCinema=" + followCinema +
                ", commentTotal=" + commentTotal +
                ", distance=" + distance +
                ", label='" + label + '\'' +
                '}';
    }
}
