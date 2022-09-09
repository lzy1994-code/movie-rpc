package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 14:34 2019/7/11
 */
public class CinemaCommentGreatVo implements Serializable {

    private String greatHeadPic;

    public String getGreatHeadPic() {
        return greatHeadPic;
    }

    public void setGreatHeadPic(String greatHeadPic) {
        this.greatHeadPic = greatHeadPic;
    }

    @Override
    public String toString() {
        return "CinemaCommentGreatVo{" +
                "greatHeadPic='" + greatHeadPic + '\'' +
                '}';
    }
}
