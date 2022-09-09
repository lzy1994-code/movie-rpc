package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

public class MovieCommentReply implements Serializable {

    //自增id
    private int id;
    //电影评论id
    private int commentId;
    //回复用户的ID
    private int replyUserId;
    //回复内容
    private String replyContent;
    //回复时间
    private Date replyTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }


}

