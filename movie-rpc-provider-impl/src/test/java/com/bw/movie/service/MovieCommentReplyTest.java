package com.bw.movie.service;

import com.bw.base.BaseTest;
import com.bw.movie.rpc.pojo.MovieCommentReply;
import com.bw.movie.rpc.vo.MovieCommentReplyVo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Ignore
public class MovieCommentReplyTest extends BaseTest {
    @Autowired
    private MovieCommentReplyService movieCommentReplyService;

    @Test
    public void findAllMovieCommentReply() {
        List<MovieCommentReplyVo> list = movieCommentReplyService.findAllCommentReply(1, 1, 5);
        if (list.isEmpty()) {
            System.out.println("没有数据！");
        }
        System.out.println(list.toString());
    }

    @Test
    public void addMovieCommentReply() {
        MovieCommentReply movieCommentReply = new MovieCommentReply();
        movieCommentReply.setReplyUserId(6);
        movieCommentReply.setReplyContent("赞赞啊");
        movieCommentReply.setCommentId(1);
        movieCommentReplyService.addCommentReply(movieCommentReply);
    }
}
