package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xyj on 2018/7/17.
 */
public class CinemasInfoVo implements Serializable {

    private List<CinemasVo> followCinemas;

    private List<CinemasVo> nearbyCinemaList;

    public List<CinemasVo> getFollowCinemas() {
        return followCinemas;
    }

    public void setFollowCinemas(List<CinemasVo> followCinemas) {
        this.followCinemas = followCinemas;
    }

    public List<CinemasVo> getNearbyCinemaList() {
        return nearbyCinemaList;
    }

    public void setNearbyCinemaList(List<CinemasVo> nearbyCinemaList) {
        this.nearbyCinemaList = nearbyCinemaList;
    }
}
