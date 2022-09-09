package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xyj on 2018/7/26.
 */
public class MovieScheduleVo implements Serializable {

    private static final long serialVersionUID = -8212211282283959546L;

    /**
     * 可以购买当前场次的电影票
     */
    public final static int STATUS_YES = 1;

    /**
     * 不能购买当前场次的电影票
     */
    public final static int STATUS_NO = 2;


    private int id;
    private String screeningHall;
    private String beginTime;
    private String endTime;
    private int seatsTotal;
    private int seatsUseCount;
    private String duration;
    private int status;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreeningHall() {
        return screeningHall;
    }

    public void setScreeningHall(String screeningHall) {
        this.screeningHall = screeningHall;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBeginTime(Date beginTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.beginTime = sdf.format(beginTime);
        this.status = compareTime(beginTime);
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.endTime = sdf.format(endTime);
    }

    public int getSeatsTotal() {
        return seatsTotal;
    }

    public void setSeatsTotal(int seatsTotal) {
        this.seatsTotal = seatsTotal;
    }

    public int getSeatsUseCount() {
        return seatsUseCount;
    }

    public void setSeatsUseCount(int seatsUseCount) {
        this.seatsUseCount = seatsUseCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "MovieScheduleVo{" +
                "id=" + id +
                ", screeningHall='" + screeningHall + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", seatsTotal=" + seatsTotal +
                ", seatsUseCount=" + seatsUseCount +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                '}';
    }

    /**
     * 传入时间与当前时间比较小时和分
     *
     * @param time
     * @return
     */
    private static int compareTime(Date time) {
        Calendar arg = Calendar.getInstance();
        arg.setTime(time);

        Calendar now = Calendar.getInstance();

        if (arg.get(Calendar.HOUR_OF_DAY) > now.get(Calendar.HOUR_OF_DAY)) {
            return STATUS_YES;
        }

        if (arg.get(Calendar.HOUR_OF_DAY) == now.get(Calendar.HOUR_OF_DAY) && arg.get(Calendar.MINUTE) > now.get(Calendar.MINUTE)) {
            return STATUS_YES;
        }

        return STATUS_NO;
    }

    public static void main(String[] args) throws Exception {
        String time = "12:40:00";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = sdf.parse(time);
        System.out.println(compareTime(date));
    }

}
