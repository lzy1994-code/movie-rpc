package com.bw.movie.rpc.vo;

import java.io.Serializable;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:37 2019/7/8
 */
public class MovieInfoVo implements Serializable {

    private int movieId;

    private String name;

    private String horizontalImage;

    private String imageUrl;

    private String director;

    private String starring;

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

    public String getHorizontalImage() {
        return horizontalImage;
    }

    public void setHorizontalImage(String horizontalImage) {
        this.horizontalImage = horizontalImage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MovieInfoVo{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", horizontalImage='" + horizontalImage + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", director='" + director + '\'' +
                ", starring='" + starring + '\'' +
                ", score=" + score +
                '}';
    }
}
