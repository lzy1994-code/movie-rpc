package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.MovieComment;
import com.bw.movie.rpc.vo.MovieCommentVo;
import com.bw.movie.rpc.vo.MovieCommentVos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieCommentMapper {

    /**
     * 根据电影的id查询电影评论
     *
     * @param movieId
     * @return
     */

    List<MovieCommentVo> findAllMovieComment(@Param("movieId") int movieId, @Param("index") int index, @Param("count") int count);

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
     * @param commentUserId
     * @param movieId
     * @return
     */
    MovieComment findCommentById(@Param("movieId") int movieId, @Param("commentUserId") int commentUserId);

    /**
     * 2.0 根据电影的id查询电影评论
     *
     * @param movieId
     * @param index
     * @param count
     * @return
     */
    List<MovieCommentVos> findAllMovieCommentById(@Param("movieId") int movieId, @Param("index") int index, @Param("count") int count);


}
