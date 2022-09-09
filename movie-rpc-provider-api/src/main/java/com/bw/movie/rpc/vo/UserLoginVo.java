package com.bw.movie.rpc.vo;

import com.bw.movie.rpc.pojo.User;

import java.io.Serializable;

/**
 * Created by xyj on 2018/7/18.
 */
public class UserLoginVo implements Serializable {

    private static final long serialVersionUID = -374778384920181654L;

    private int userId;
    private String sessionId;

    private User userInfo;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserLoginVo{" +
                "userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
