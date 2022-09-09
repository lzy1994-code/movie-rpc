package com.bw.movie.rpc.pojo;

import java.io.Serializable;

public class CinemaCommentGreat implements Serializable {

    //自增id
    private int id;
    //评论id
    private int commentId;
    //用户id
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
