package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/7/27.
 */
public class UserBuyTicketDetail implements Serializable {

    private static final long serialVersionUID = -1122072226859896424L;
    //明细id
    private int id;
    //关联购票记录ID
    private int recordId;
    //兑换码
    private String exchangeCode;
    //过期时间
    private Date expiredTime;
    //兑换码状态   1=未使用  2=已使用   3=已过期
    private int status;
    //创建时间
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserBuyTicketDetail{" +
                "id=" + id +
                ", recordId=" + recordId +
                ", exchangeCode='" + exchangeCode + '\'' +
                ", expiredTime=" + expiredTime +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
