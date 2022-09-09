package com.bw.movie.service;

import com.bw.base.BaseTest;
import com.bw.movie.rpc.pojo.MovieComment;
import com.bw.movie.rpc.vo.MovieCommentVo;
import com.bw.movie.rpc.vo.MovieCommentVos;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class MovieCommentServiceTest extends BaseTest {

    @Autowired
    private MovieCommentService movieCommentService;
    @Resource
    private MovieCommentGreatService movieCommentGreatService;

    @Test
    public void findAllMovieComment() {
        List<MovieCommentVo> list = movieCommentService.findAllMovieComment(5, 1, 1, 5);
        System.out.println(list.toString());
    }

    @Test
    public void addMovieComment() {
        MovieComment movieComment = new MovieComment();
        movieComment.setCommentUserId(13466);
        movieComment.setMovieId(15);
        movieComment.setCommentContent("就是这么！");
        int i = movieCommentService.saveMovieComment(movieComment);
        System.out.println(i);
    }

    @Test
    public void whetherMovieGreat() {
        int a = movieCommentGreatService.whetherMovieGreat(0, 5);
        System.out.println(a);
    }

    @Test
    public void findAllMovieCommentById() {
        List<MovieCommentVos> allMovieCommentById = movieCommentService.findAllMovieCommentById(0, 1, 1, 5);
        System.out.println(allMovieCommentById);
    }
}
