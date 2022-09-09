package com.bw.movie.rpc.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:30 2019/7/9
 */
public class MovieDetailVo implements Serializable {

    //电影id
    private int movieId;
    //电影名称
    private String name;
    //评分
    private double score;
    //海报
    private String imageUrl;

    //电影类型
    private String movieType;
    //时长
    private String duration;
    //放映时间
    private Date releaseTime;
    //产地
    private String placeOrigin;
    //是否关注
    private int whetherFollow;
    //简介
    private String summary;
    //导演集合
    private List<MovieDirectorVo> movieDirector;
    //演员集合
    private List<MovieActorVo> movieActor;
    //剧照
    private List<String> posterList;
    //预告片
    private List<ShortFilmVo> shortFilmList;
    //评论数
    private int commentNum;

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public int getWhetherFollow() {
        return whetherFollow;
    }

    public void setWhetherFollow(int whetherFollow) {
        this.whetherFollow = whetherFollow;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<MovieDirectorVo> getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(List<MovieDirectorVo> movieDirector) {
        this.movieDirector = movieDirector;
    }

    public List<MovieActorVo> getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(List<MovieActorVo> movieActor) {
        this.movieActor = movieActor;
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

    @Override
    public String toString() {
        return "MovieDetailVo{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", imageUrl='" + imageUrl + '\'' +
                ", commentNum=" + commentNum +
                ", movieType='" + movieType + '\'' +
                ", duration='" + duration + '\'' +
                ", releaseTime=" + releaseTime +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", whetherFollow=" + whetherFollow +
                ", summary='" + summary + '\'' +
                ", movieDirector=" + movieDirector +
                ", movieActor=" + movieActor +
                ", posterList=" + posterList +
                ", shortFilmList=" + shortFilmList +
                '}';
    }
}
