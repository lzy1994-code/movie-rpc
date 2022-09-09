package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

public class MovieCommentVo implements Serializable {
    //评论id(自增id)
    private int commentId;
    //用户id
    private int commentUserId;
    //用户头像
    private String commentHeadPic;
    //用户名称
    private String commentUserName;
    //影片评论内容
    private String commentContent;
    //点赞数
    private int greatNum;
    //热评
    private int hotComment;
    //评论时间
    private Date commentTime;
    //用于判断用户是否点过赞(0：否 ，1 是)
    private int isGreat;
    //回复总数
    private int replyNum;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentHeadPic() {
        return commentHeadPic;
    }

    public void setCommentHeadPic(String commentHeadPic) {
        this.commentHeadPic = commentHeadPic;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getGreatNum() {
        return greatNum;
    }

    public void setGreatNum(int greatNum) {
        this.greatNum = greatNum;
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

    public int getIsGreat() {
        return isGreat;
    }

    public void setIsGreat(int isGreat) {
        this.isGreat = isGreat;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }


    @Override
    public String toString() {
        return "MovieCommentVo{" +
                "commentId=" + commentId +
                ", commentUserId=" + commentUserId +
                ", commentHeadPic='" + commentHeadPic + '\'' +
                ", commentUserName='" + commentUserName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", greatNum=" + greatNum +
                ", hotComment=" + hotComment +
                ", commentTime=" + commentTime +
                ", isGreat=" + isGreat +
                ", replyNum=" + replyNum +
                '}';
    }
}
