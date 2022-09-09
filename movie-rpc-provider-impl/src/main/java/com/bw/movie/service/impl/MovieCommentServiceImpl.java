package com.bw.movie.service.impl;

import com.bw.movie.dao.MovieCommentGreatMapper;
import com.bw.movie.dao.MovieCommentMapper;
import com.bw.movie.dao.MovieCommentReplyMapper;
import com.bw.movie.rpc.pojo.MovieComment;
import com.bw.movie.rpc.pojo.MovieCommentGreat;
import com.bw.movie.rpc.vo.MovieCommentReplyVo;
import com.bw.movie.rpc.vo.MovieCommentVo;
import com.bw.movie.rpc.vo.MovieCommentVos;
import com.bw.movie.service.MovieCommentService;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("movieCommentService")
public class MovieCommentServiceImpl implements MovieCommentService {

    @Resource
    private MovieCommentMapper movieCommentMapper;

    @Resource
    private MovieCommentGreatMapper greatMapper;

    @Resource
    private MovieCommentReplyMapper movieCommentReplyMapper;


    @Override
    public List<MovieCommentVo> findAllMovieComment(int userId, int movieId, int page, int count) {

        List<MovieCommentVo> movieCommentVoList = new ArrayList<>();
        List<MovieCommentVo> movieCommentVos = movieCommentMapper.findAllMovieComment(movieId, Util.getPageIndex(page, count), count);
        for (MovieCommentVo movieComment : movieCommentVos) {
            movieComment.setReplyNum(movieCommentReplyMapper.findCommentReplyTotal(movieComment.getCommentId()));
            movieComment.setGreatNum(greatMapper.getMovieGreatNum(movieComment.getCommentId()));
            //判断登录状态下是否点过赞
            if (userId > 0) {
                movieComment.setIsGreat(greatMapper.whetherMovieGreat(movieComment.getCommentId(), userId));
            }
            movieCommentVoList.add(movieComment);
        }
        return movieCommentVoList;
    }

    @Override
    public int saveMovieComment(MovieComment movieComment) {
        //是否已评论
        MovieComment comment = findCommentById(movieComment.getMovieId(), movieComment.getCommentUserId());
        if (comment != null) {
            return 2;
        }
        return movieCommentMapper.saveMovieComment(movieComment);
    }

    @Override
    public int movieCommentTotal(int movieId) {
        return movieCommentMapper.movieCommentTotal(movieId);
    }

    @Override
    public MovieComment findCommentById(int movieId, int userId) {
        return movieCommentMapper.findCommentById(movieId, userId);
    }

    @Override
    public List<MovieCommentVos> findAllMovieCommentById(int userId, int movieId, int page, int count) {
        List<MovieCommentVos> movieCommentList = new ArrayList<>();
        List<MovieCommentVos> movieComment = movieCommentMapper.findAllMovieCommentById(movieId, Util.getPageIndex(page, count), count);
        for (MovieCommentVos movieCommentVos : movieComment) {
            //判断登录状态下是否点过赞
            if (userId > 0) {
                movieCommentVos.setIsGreat(greatMapper.whetherMovieGreat(movieCommentVos.getCommentId(), userId));
            }
            movieCommentVos.setReplyNum(movieCommentReplyMapper.findCommentReplyTotal(movieCommentVos.getCommentId()));
            movieCommentVos.setGreatNum(greatMapper.getMovieGreatNum(movieCommentVos.getCommentId()));
            //回复者信息
            List<MovieCommentReplyVo> allCommentReply = movieCommentReplyMapper.findAllCommentReply(movieCommentVos.getCommentId(), 0, 5);
            List<String> list = new ArrayList<>();
            for (MovieCommentReplyVo commentReplyVo : allCommentReply) {
                String headPic = commentReplyVo.getReplyHeadPic();
                list.add(headPic);
            }
            movieCommentVos.setReplyHeadPic(list);
            movieCommentList.add(movieCommentVos);
        }
        return movieCommentList;
    }


}
