package com.bw.movie.service;

import com.bw.base.BaseTest;
import com.bw.movie.rpc.pojo.MovieComment;
import com.bw.movie.rpc.vo.MovieDetailVo;
import com.bw.movie.rpc.vo.MovieInfoVo;
import com.bw.movie.rpc.vo.MovieVo;
import com.bw.movie.rpc.vo.MyMovieCommentVo;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 2018/7/23.
 */
@Ignore
public class MovieServiceTest extends BaseTest {

    @Resource
    private MovieService movieService;

    @Resource
    private MovieCommentService movieCommentService;

    @Test
    public void findMovieListByUserId() {
    }

    @Test
    public void findHotMovieList() {
        List<MovieVo> hotMovieList = movieService.findHotMovieList(2978, 1, 5);
        System.out.println(hotMovieList);
    }

    @Test
    public void findReleaseMovieList() {
    }

    @Test
    public void findComingSoonMovieList() {
    }

    @Test
    public void findMoviesById() {
    }

    @Test
    public void findMoviesDetail() {
        System.out.println(movieService.findMoviesDetail(5, 1));
    }

    @Test
    public void findMoviePageList() {
    }

    @Test
    public void followMovie() {
        int i = movieService.followMovie(2978, 20);
        System.out.println(i);
    }

    @Test
    public void cancelFollowMovie() {
    }

    @Test
    public void findMoviesByIds() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(movieService.findMoviesByIds(list));
    }

    @Test
    public void findCommentById() {
        MovieComment movieComment = movieCommentService.findCommentById(1, 5);
        System.out.println(movieComment);
    }

    @Test
    public void saveMovieComment() {
        MovieComment movieComment = new MovieComment();
        movieComment.setCommentUserId(6);
        movieComment.setMovieId(1);
        movieComment.setCommentContent("哈哈哈");
        int boo = movieCommentService.saveMovieComment(movieComment);
        System.out.println(boo);
    }

    @Test
    public void findSoonMovieByCinemaId() {
        System.out.println(movieService.findSoonMovieByCinemaId(2));
    }

    @Test
    public void findMoviesDetailById() {
        MovieDetailVo moviesDetail = movieService.findMoviesDetailById(0, 2);
        System.out.println(moviesDetail);
    }

    @Test
    public void findMovieByKeyword() {
        List<MovieInfoVo> movieInfoVos = movieService.findMovieByKeyword("我", 1, 5);
        System.out.println(movieInfoVos);
    }

    @Test
    public void findMyMovieCommentList() {
        List<MyMovieCommentVo> myMovieCommentList = movieService.findMyMovieCommentList(13466, 1, 5);
        System.out.println(myMovieCommentList);
    }


}