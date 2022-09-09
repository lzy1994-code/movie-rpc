package com.bw.movie.service;

import com.bw.movie.rpc.pojo.MovieComment;
import com.bw.movie.rpc.vo.MovieCommentVo;
import com.bw.movie.rpc.vo.MovieCommentVos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieCommentService {

    /**
     * 根据电影的id查询电影评论
     *
     * @param movieId
     * @return
     */

    List<MovieCommentVo> findAllMovieComment(@Param("userId") int userId, @Param("movieId") int movieId, @Param("page") int page, @Param("count") int count);

    /**
     * 增加评论
     *
     * @param movieComment
     * @return
     */
    int saveMovieComment(MovieComment movieComment);

    /**
     * 影片评论总数
     *
     * @param movieId
     * @return
     */
    int movieCommentTotal(int movieId);

    /**
     * 通过用户id查询评论信息
     *
     * @param userId
     * @param movieId
     * @return
     */
    MovieComment findCommentById(int movieId, int userId);

    /**
     * 2.0 根据电影的id查询电影评论
     *
     * @param movieId
     * @param page
     * @param count
     * @return
     */
    List<MovieCommentVos> findAllMovieCommentById(int userId, int movieId, int page, int count);

}
