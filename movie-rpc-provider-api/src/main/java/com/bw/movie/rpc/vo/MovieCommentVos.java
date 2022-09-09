package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 10:32 2019/7/10
 */
public class MovieCommentVos implements Serializable {
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
    //评论时间
    private Date commentTime;
    //用于判断用户是否点过赞(0：否 ，1 是)
    private int isGreat;
    //回复总数
    private int replyNum;
    //评分
    private double score;
    //评论回复者头像
    private List<String> replyHeadPic;


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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<String> getReplyHeadPic() {
        return replyHeadPic;
    }

    public void setReplyHeadPic(List<String> replyHeadPic) {
        this.replyHeadPic = replyHeadPic;
    }

    @Override
    public String toString() {
        return "MovieCommentVos{" +
                "commentId=" + commentId +
                ", commentUserId=" + commentUserId +
                ", commentHeadPic='" + commentHeadPic + '\'' +
                ", commentUserName='" + commentUserName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", greatNum=" + greatNum +
                ", commentTime=" + commentTime +
                ", isGreat=" + isGreat +
                ", replyNum=" + replyNum +
                ", score=" + score +
                ", replyHeadPic=" + replyHeadPic +
                '}';
    }
}
