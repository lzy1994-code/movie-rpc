package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:14 2019/8/10
 */
public class UserFollowMovieVo implements Serializable {

    private int movieId;

    private String name;

    private String imageUrl;

    private String starring;

    private String director;

    private double score;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserFollowMovieVo{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", starring='" + starring + '\'' +
                ", director='" + director + '\'' +
                ", score=" + score +
                '}';
    }
}
