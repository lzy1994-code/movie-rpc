package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;

public class MovieCommentReplyVo implements Serializable {
    //回复人id
    private int replyUserId;
    //回复人头像
    private String replyHeadPic;
    //回复人名称
    private String replyUserName;
    //回复内容
    private String replyContent;
    //评论时间
    private Date replyTime;

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyHeadPic() {
        return replyHeadPic;
    }

    public void setReplyHeadPic(String replyHeadPic) {
        this.replyHeadPic = replyHeadPic;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
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


    @Override
    public String toString() {
        return "MovieCommentReplyVo{" +
                "replyUserId=" + replyUserId +
                ", replyHeadPic='" + replyHeadPic + '\'' +
                ", replyUserName='" + replyUserName + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }
}
