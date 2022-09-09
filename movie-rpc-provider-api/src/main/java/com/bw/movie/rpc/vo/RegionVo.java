package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:05 2019/7/11
 */
public class RegionVo implements Serializable {

    private int regionId;

    private String regionName;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "RegionVo{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
