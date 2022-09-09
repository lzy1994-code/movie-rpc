package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:17 2019/7/8
 */
public class BannerVo implements Serializable {

    //图片地址
    private String imageUrl;
    //跳转地址
    private String jumpUrl;
    //排序
    private int rank;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "BannerVo{" +
                "imageUrl='" + imageUrl + '\'' +
                ", jumpUrl='" + jumpUrl + '\'' +
                ", rank=" + rank +
                '}';
    }
}
