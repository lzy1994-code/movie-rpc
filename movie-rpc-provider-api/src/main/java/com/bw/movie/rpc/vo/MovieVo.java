package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MovieVo implements Serializable {

    private static final long serialVersionUID = 8986997340435355521L;

    private int id;

    private String name;

    private String summary;

    private String duration;

    private String placeOrigin;

    private String director;

    private String starring;

    private String imageUrl;

    private Date releaseTime;

    private String releaseTimeShow;

    private int rank;

    private String movieTypes;

    private List<String> posterList;

    private List<ShortFilmVo> shortFilmList;

    //   private boolean followMovie;
    private int followMovie;

    private int type;

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
        if (releaseTime != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.releaseTimeShow = sdf.format(releaseTime);
        }
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getReleaseTimeShow() {
        return releaseTimeShow;
    }

    public List<String> getPosterList() {
        return posterList;
    }

    public void setPosterList(List<String> posterList) {
        this.posterList = posterList;
    }

    public List<ShortFilmVo> getShortFilmList() {
        return shortFilmList;
    }

    public void setShortFilmList(List<ShortFilmVo> shortFilmList) {
        this.shortFilmList = shortFilmList;
    }

    public String getMovieTypes() {
        return movieTypes;
    }

    public void setMovieTypes(String movieTypes) {
        this.movieTypes = movieTypes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setReleaseTimeShow(String releaseTimeShow) {
        this.releaseTimeShow = releaseTimeShow;
    }

    public int getFollowMovie() {
        return followMovie;
    }

    public void setFollowMovie(int followMovie) {
        this.followMovie = followMovie;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MovieVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", duration='" + duration + '\'' +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", director='" + director + '\'' +
                ", starring='" + starring + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", releaseTime=" + releaseTime +
                ", releaseTimeShow='" + releaseTimeShow + '\'' +
                ", rank=" + rank +
                ", movieTypes='" + movieTypes + '\'' +
                ", posterList=" + posterList +
                ", shortFilmList=" + shortFilmList +
                ", followMovie=" + followMovie +
                ", type=" + type +
                '}';
    }
}