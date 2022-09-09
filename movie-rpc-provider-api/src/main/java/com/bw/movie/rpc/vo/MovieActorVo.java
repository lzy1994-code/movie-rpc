package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:47 2019/7/9
 */
public class MovieActorVo implements Serializable {

    private String name;

    private String role;

    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "MovieActorVo{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
