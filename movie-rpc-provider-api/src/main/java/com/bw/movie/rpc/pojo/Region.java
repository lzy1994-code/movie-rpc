package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 8:56 2019/7/11
 */
public class Region implements Serializable {

    private int id;

    private String regionName;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
