package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/7/17.
 */
public class ShortFilmVo implements Serializable {

    private static final long serialVersionUID = -8044593621688560517L;

    private String imageUrl;
    private String videoUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "ShortFilmVo{" +
                "imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
