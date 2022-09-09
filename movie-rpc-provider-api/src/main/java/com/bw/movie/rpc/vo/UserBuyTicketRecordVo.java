package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:41 2019/7/19
 */
public class UserBuyTicketRecordVo implements Serializable {

    //id
    private int id;
    //电影名称
    private String movieName;
    //影院
    private String cinemaName;
    //电影图片
    private String imageUrl;
    // 订单号
    private String orderId;
    //创建时间
    private Date createTime;
    //购票价格
    private double price;
    //购票数量
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UserBuyTicketRecordVo{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
