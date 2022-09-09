package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: movie-rpc
 * @description: 系统推送消息实体类
 * @author: Lzy
 * @create: 2018-08-10 10:04
 **/
public class SystemMessages implements Serializable {
    //id
    private int id;
    //用户id
    private int userId;
    //推送消息内容
    private String content;
    //推送标题
    private String title;
    //推送状态
    private int status;
    //推送时间
    private Date pushTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }


    @Override
    public String toString() {
        return "SystemMessages{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", pushTime=" + pushTime +
                '}';
    }
}
