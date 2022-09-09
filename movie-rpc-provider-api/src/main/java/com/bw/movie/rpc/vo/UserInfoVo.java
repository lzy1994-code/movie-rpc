package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
public class UserInfoVo implements Serializable {

    private static final long serialVersionUID = -7186483983797676345L;

    private String nickName;

    private String phone;

    private String headPic;

    private int integral;

    //  private boolean userSignStatus;
    //1=可签到，2=不可签到
    private int userSignStatus;
    private List<MovieListVo> movieList;

    private List<CinemasVo> cinemasList;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public List<MovieListVo> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieListVo> movieList) {
        this.movieList = movieList;
    }

    public List<CinemasVo> getCinemasList() {
        return cinemasList;
    }

    public void setCinemasList(List<CinemasVo> cinemasList) {
        this.cinemasList = cinemasList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserSignStatus() {
        return userSignStatus;
    }

    public void setUserSignStatus(int userSignStatus) {
        this.userSignStatus = userSignStatus;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", headPic='" + headPic + '\'' +
                ", integral=" + integral +
                ", userSignStatus=" + userSignStatus +
                ", movieList=" + movieList +
                ", cinemasList=" + cinemasList +
                '}';
    }
}
