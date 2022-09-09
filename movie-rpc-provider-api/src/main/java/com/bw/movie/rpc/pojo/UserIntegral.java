package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/7/19.
 */
public class UserIntegral implements Serializable {
    private static final long serialVersionUID = -4802119532182263120L;

    private int id;
    private int userId;
    private int balance;
    private Date updateTime;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserIntegral{" +
                "id=" + id +
                ", userId=" + userId +
                ", balance=" + balance +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
