package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.util.Date;

public class MovieComment implements Serializable {

    private int id;

    //影片id
    private int movieId;

    //评论者id
    private int commentUserId;

    //评论内容
    private String commentContent;

    //是否为精选评价 默认为0 精选为1
    private int hotComment;
    //2.0 新增对影片的评分
    private double score;

    //评论时间
    private Date commentTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MovieComment{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", commentUserId=" + commentUserId +
                ", commentContent='" + commentContent + '\'' +
                ", hotComment=" + hotComment +
                ", score=" + score +
                ", commentTime=" + commentTime +
                '}';
    }
}
