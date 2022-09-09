package com.bw.movie.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Movies implements Serializable {

    private static final long serialVersionUID = 8986997340435355521L;

    private int id;

    private String name;

    private String summary;

    private String duration;

    private String placeOrigin;

    private String director;

    private String starring;

    private String imageUrl;

    private double fare;

    private Date releaseTime;

    private Date createTime;

    private double score;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin == null ? null : placeOrigin.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring == null ? null : starring.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", duration='" + duration + '\'' +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", director='" + director + '\'' +
                ", starring='" + starring + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", fare=" + fare +
                ", releaseTime=" + releaseTime +
                ", createTime=" + createTime +
                ", score=" + score +
                '}';
    }
}