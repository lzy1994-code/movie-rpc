package com.bw.movie.service;

import com.bw.movie.rpc.pojo.MovieCommentGreat;
import org.apache.ibatis.annotations.Param;

public interface MovieCommentGreatService {

    /**
     * 判断影片评论是否点赞
     *
     * @param commentId
     * @param userId
     * @return
     */
    int whetherMovieGreat(@Param("commentId") int commentId, @Param("userId") int userId);

    /**
     * 保存点赞信息
     *
     * @param movieCommentGreato
     */
    boolean saveMovieCommentGreat(MovieCommentGreat movieCommentGreato);
}
