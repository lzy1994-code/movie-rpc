package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 影院评论实体类
 */
public class CinemaComment implements Serializable {
    //自增id
    private int id;
    //影院id
    private int cinemaId;
    //评论者id
    private int commentUserId;
    //评论内容
    private String commentContent;
    //是否为热评
    private int hotComment;
    //评论时间
    private Date commentTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getHotComment() {
        return hotComment;
    }

    public void setHotComment(int hotComment) {
        this.hotComment = hotComment;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "CinemaComment{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", userId=" + commentUserId +
                ", commentContent='" + commentContent + '\'' +
                ", hotComment=" + hotComment +
                ", commentTime=" + commentTime +
                '}';
    }
}
