package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xyj on 2018/7/27.
 */
public class UserBuyTicketRecord implements Serializable {

    private static final long serialVersionUID = 3934354948298767780L;

    /**
     * 待付款
     */
    public static int TYPE_NO_PAY = 1;

    /**
     * 已付款
     */
    public static int TYPE_YES_PAY = 2;
    //购票记录id
    private int id;
    //订单号
    private String orderId;
    //用户id
    private int userId;
    //电影名称
    private String movieName;
    //影院名称
    private String cinemaName;
    //放映厅
    private String screeningHall;
    //购票价格
    private double price;
    //购票状态   1=待付款   2=已付款
    private int status;
    //购票数量
    private int amount;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //创建时间
    private Date createTime;

    //座位
    private String seat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getScreeningHall() {
        return screeningHall;
    }

    public void setScreeningHall(String screeningHall) {
        this.screeningHall = screeningHall;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBeginTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(beginTime);
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(endTime);
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "UserBuyTicketRecord{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", movieName='" + movieName + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", screeningHall='" + screeningHall + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", amount=" + amount +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", seat='" + seat + '\'' +
                '}';
    }
}
